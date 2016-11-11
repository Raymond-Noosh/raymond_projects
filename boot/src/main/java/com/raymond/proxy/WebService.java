package com.raymond.proxy;


import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

/**
 * Created by Raymond Kwong on 11/10/2016.
 */
public interface WebService {
    public ResponseEntity proxyGet(HttpServletRequest httpRequest, URI uri);
    public ResponseEntity proxyPost(HttpServletRequest httpRequest, URI uri);
}
