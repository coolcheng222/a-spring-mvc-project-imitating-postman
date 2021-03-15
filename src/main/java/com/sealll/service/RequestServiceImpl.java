package com.sealll.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sealll.bean.Info;
import com.sealll.dao.CookieDao;
import com.sealll.http.HttpRequester;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author sealll
 * @time 2021/2/18 21:15
 */
@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    CookieDao cookieDao;
    @Autowired
    private HttpClient client;
    @Autowired
    private HttpRequester requester;
    @Autowired
    private Gson gson;

    @Override
    public CloseableHttpResponse getResponse(Info info) throws IllegalAccessException, IOException, InvocationTargetException, URISyntaxException {
        Map<String, Object> map = null;
        if (info.isJson()) {
            map = gson.fromJson(info.getJson(), new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        HttpClientContext context = cookieDao.getContext(info);

        CloseableHttpResponse response;
        if(info.isJson()){
            response = requester.sendJsonForResponse(context, info.getUrl(), info.getMethod(),
                info.getHeaders(),map);
        }else{
            response = requester.sendFormForResponse(context, info.getUrl(), info.getMethod(),
                info.getHeaders(), info.getParams());

        }

        return response;
    }
}
