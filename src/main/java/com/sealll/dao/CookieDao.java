package com.sealll.dao;

import com.sealll.bean.Info;
import org.apache.http.client.protocol.HttpClientContext;

import java.net.URISyntaxException;

/**
 * @author sealll
 * @time 2021/2/18 21:17
 */
public interface CookieDao {
    public HttpClientContext getContext(Info info) throws URISyntaxException;
}
