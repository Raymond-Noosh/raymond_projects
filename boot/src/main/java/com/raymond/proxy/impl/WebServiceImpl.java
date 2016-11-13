package com.raymond.proxy.impl;

import com.raymond.proxy.WebService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Raymond Kwong on 11/10/2016.
 */
@Service
public class WebServiceImpl implements WebService {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);

    //Http
    private CloseableHttpClient createCloseableHttpClient_AcceptsUntrustedCerts() {
        CloseableHttpClient httpclient = null;
        SSLContext sslContext = null;
        try {
            sslContext = new org.apache.http.ssl.SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();
            HttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

            httpclient = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .setConnectionManager(poolingConnManager).build();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (KeyManagementException e) {
            e.printStackTrace();
        }
        catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return httpclient;
    }

    @Override
    public ResponseEntity proxyGet(HttpServletRequest httpRequest, URI uri) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient = createCloseableHttpClient_AcceptsUntrustedCerts();
        try {
            HttpGet httpget = new HttpGet(uri);
            Header[] requestHeaders = buildHeadersFromRequest(httpRequest, uri);
            httpget.setHeaders(requestHeaders);

            CloseableHttpResponse response = httpclient.execute(httpget);
            logger.info("GET:" + uri.toString() + " : " +response.getStatusLine());
            return proxyResponseHandler(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                httpclient.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ResponseEntity proxyPost(HttpServletRequest httpRequest, URI uri) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient = createCloseableHttpClient_AcceptsUntrustedCerts();
        try {
            HttpPost httpPost = new HttpPost(uri);
            Header[] requestHeaders = buildHeadersFromRequest(httpRequest, uri);
            httpPost.setHeaders(requestHeaders);
            String bodyString = httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            //httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setEntity(new StringEntity(bodyString));
            /*EntityBuilder entityBuilder = EntityBuilder.create().setText(bodyString);
            httpPost.setEntity(entityBuilder.build());*/

            CloseableHttpResponse response = httpclient.execute(httpPost);
            logger.info("POST:" + uri.toString() + " : " +response.getStatusLine());
            return proxyResponseHandler(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                httpclient.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Header[] buildHeadersFromRequest(HttpServletRequest httpRequest, String scheme, String host) {
        Enumeration<String> stringEnumeration = httpRequest.getHeaderNames();
        ArrayList<BasicHeader> headersList = new ArrayList();
        while (stringEnumeration.hasMoreElements()) {
            String headerName = stringEnumeration.nextElement();
            String headerValue = httpRequest.getHeader(headerName);
            if (headerName.equalsIgnoreCase("host")) {
                headersList.add(new BasicHeader("host", host));
            }
            else if (headerName.equalsIgnoreCase("origin")) {
                String origin = scheme + "://" + host;
                headersList.add(new BasicHeader("origin", origin));
            }
            else if (headerName.equalsIgnoreCase("content-length")) {//headers to ignore from original request
                continue;
            }
            else {
                headersList.add(new BasicHeader(headerName, headerValue));
            }
        }

        Header[] headers = new Header[headersList.size()];
        int count = 0;
        for (BasicHeader header : headersList) {
            headers[count] = header;
            count++;
        }
        return headers;
    }

    private Header[] buildHeadersFromRequest(HttpServletRequest httpRequest, URI uri) {
        Enumeration<String> stringEnumeration = httpRequest.getHeaderNames();
        ArrayList<BasicHeader> headersList = new ArrayList();
        while (stringEnumeration.hasMoreElements()) {
            String headerName = stringEnumeration.nextElement();
            String headerValue = httpRequest.getHeader(headerName);
            if (headerName.equalsIgnoreCase("host")) {
                headersList.add(new BasicHeader("host", uri.getHost()));
            }
            else if (headerName.equalsIgnoreCase("origin")) {
                String origin = uri.getScheme() + "://" + uri.getHost();
                headersList.add(new BasicHeader("origin", origin));
            }
            else if (headerName.equalsIgnoreCase("content-length")) {//headers to ignore from original request
                continue;
            }
            else {
                headersList.add(new BasicHeader(headerName, headerValue));
            }
        }

        Header[] headers = new Header[headersList.size()];
        int count = 0;
        for (BasicHeader header : headersList) {
            headers[count] = header;
            count++;
        }
        return headers;
    }

    private MultiValueMap<String, String> buildResponseHeaderMap(Header[] headers) {
        MultiValueMap<String, String> multiValueMap = new HttpHeaders();
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                String name = header.getName();
                if (name.equalsIgnoreCase("content-type") || name.equalsIgnoreCase("content-language")) {
                    List<String> value = multiValueMap.getOrDefault(name, null);
                    if (value == null) {
                        value = new ArrayList();
                    }
                    value.add(header.getValue());
                    multiValueMap.put(name, value);
                }
            }
        }
        return multiValueMap;
    }

    private ResponseEntity proxyResponseHandler(CloseableHttpResponse response) {
        HttpEntity httpEntity = response.getEntity();
        String responseString = null;
        try {
            responseString = EntityUtils.toString(httpEntity);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        Header[] responseHeaders = response.getAllHeaders();
        MultiValueMap responseHeadersMap = buildResponseHeaderMap(responseHeaders);
        return new ResponseEntity(responseString, responseHeadersMap, org.springframework.http.HttpStatus.valueOf(statusCode));
    }
}
