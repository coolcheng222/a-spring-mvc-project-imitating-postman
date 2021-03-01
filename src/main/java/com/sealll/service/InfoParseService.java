package com.sealll.service;

import com.sealll.bean.Info;
import com.sealll.beanutils.BeanParamUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author sealll
 * @time 2021/1/26 23:01
 */
@Service
public class InfoParseService {
    /**
     * 从info中获取cookie
     *
     * @param info 对应cookie
     * @return cookiestore
     * @throws URISyntaxException uri错误警告
     */
    public CookieStore getCookies(Info info) throws URISyntaxException {
        return BeanParamUtils.getCookies(info.getCookies(),new URI(info.getUrl()).getHost());
    }

    public HttpUriRequest wrap(HttpUriRequest method, StringEntity entity) throws IOException {
        if (method instanceof HttpEntityEnclosingRequestBase) {
            ((HttpEntityEnclosingRequestBase) method).setEntity(entity);
            return method;
        }else{
            URI uri = method.getURI();
            String url = uri.toString();
            String query = uri.getQuery();
            if (!query.equals("")) {

                url += "?";
            }
            String s = IOUtils.toString(entity.getContent(), "UTF-8");
            return new HttpGet(url);
        }
    }
}
