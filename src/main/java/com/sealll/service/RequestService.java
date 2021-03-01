package com.sealll.service;

import com.sealll.bean.Info;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

/**
 * @author sealll
 * @time 2021/2/18 21:14
 */
public interface RequestService {
    public CloseableHttpResponse getResponse(Info info) throws IllegalAccessException, IOException, InvocationTargetException, URISyntaxException;
}
