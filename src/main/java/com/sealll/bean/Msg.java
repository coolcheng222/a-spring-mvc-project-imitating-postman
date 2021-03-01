package com.sealll.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.http.Header;
import org.apache.http.StatusLine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sealll
 * @time 2021/1/28 18:42
 */
public class Msg {
    /**
     * 响应体
     */
    private String entity;
    /**
     * 格式化后的响应体
     */
    private String formatted;
    /**
     * 响应头
     */
    private Map<String,Object> header;

    /**
     * 状态信息
     * @return
     */
    private StatusLine statusLine;


    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }
    public void setHeader(Header[] header){
        HashMap<String, Object> map = new HashMap<>();
        for (Header header1 : header) {
            String name = header1.getName();
            String value = header1.getValue();
            map.put(name,value);
        }
        setHeader(map);
    }

    @Override
    public String toString() {
        return "Msg{" +
                "entity='" + entity + '\'' +
                ", formatted='" + formatted + '\'' +
                ", header=" + header +
                ", statusLine=" + statusLine +
                '}';
    }
}
