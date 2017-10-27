package com.learn.netty.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author : mastXu
 * Description : saying something
 * Date : 2017/10/19.
 * Modify :
 */
public class OkHttpService {

    private OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();

    public String httpPost(String url) {
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ClientHttpRequest clientHttpRequest = okHttp3ClientHttpRequestFactory.createRequest(uri, HttpMethod.POST);
        ClientHttpResponse response = null;
        String responseStr = new String();
        try {
            response = clientHttpRequest.execute();
            responseStr = response.getBody().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStr;
    }
}
