package com.sealll.dao;

import com.sealll.bean.Info;
import com.sealll.service.InfoParseService;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

/**
 * @author sealll
 * @time 2021/2/18 21:17
 */
@Service
public class CookieDaoImpl implements CookieDao{
    @Autowired
    private InfoParseService parseService;
    public HttpClientContext getContext(Info info) throws URISyntaxException {
        CookieStore cookies = parseService.getCookies(info);
        HttpClientContext context = new HttpClientContext();
        context.setCookieStore(cookies);
        return context;
    }
}
