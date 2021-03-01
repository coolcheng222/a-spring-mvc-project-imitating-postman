package com.sealll.service;

import com.sealll.bean.Msg;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

/**
 * @author sealll
 * @time 2021/2/18 21:30
 */
public interface ResponseService {
    public Msg getResponse(CloseableHttpResponse response) throws IOException;
}
