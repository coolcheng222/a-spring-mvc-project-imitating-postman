package com.sealll.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @author sealll
 * @time 2021/1/26 18:49
 */
public class Info {
    private String url;
    private String method;
    private Map<String,Object> params;
    private Map<String,Object> cookies;
    private Map<String,String> headers;

    private String json;
    private boolean isJson;

    public boolean isJson() {
        return isJson;
    }

    public void setJson(boolean json) {
        isJson = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, Object> cookies) {
        this.cookies = cookies;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params =     params;
    }

    @Override
    public String toString() {
        return "Info{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                ", cookies=" + cookies +
                ", headers=" + headers +
                ", json='" + json + '\'' +
                ", isJson=" + isJson +
                '}';
    }
}
