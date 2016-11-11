package com.raymond.web;

import com.raymond.proxy.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Raymond Kwong on 11/10/2016.
 */
@Controller
public class WebController {
    @Autowired
    private WebService webService;

    @ResponseBody
    @RequestMapping(value = "/proxyGet", method = RequestMethod.GET)
    public ResponseEntity<String> proxyGet(@RequestParam String target, HttpServletRequest httpRequest) {
        URI uri = null;
        try {
            uri = new URI(target);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity responseEntity = webService.proxyGet(httpRequest, uri);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/proxyPost", method = RequestMethod.POST)
    public ResponseEntity<String> proxyPost(@RequestParam String target, HttpServletRequest httpRequest) {
        ResponseEntity responseEntity = webService.proxyPost(httpRequest, target);
        return responseEntity;
    }
}
