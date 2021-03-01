package com.sealll.config;

import com.google.gson.Gson;
import com.sealll.http.HttpRequestUtils;
import com.sealll.http.HttpRequester;
import com.sealll.http.SimpleHttpRequester;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author com.sealll
 * @time 2021/1/25 14:16
 */
@ComponentScan(value = "com.sealll",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value={Controller.class})
})
@Configuration
public class ApplicationConfig {
    @Bean
    public HttpClient httpClient(){
        return HttpClientBuilder.create().build();
    }
    @Bean
    public Gson gson(){
        return new Gson();
    }
    @Bean
    public Logger logger(){
        return LoggerFactory.getLogger(getClass());
    }
    @Scope(value="prototype")
    @Bean
    public HttpGet get(){
        return new HttpGet();
    }
    @Scope(value="prototype")
    @Bean
    public HttpPost post(){
        return new HttpPost();
    }
    @Scope(value="prototype")
    @Bean
    public HttpDelete delete(){
        return new HttpDelete();
    }
    @Scope(value="prototype")
    @Bean
    public HttpPut PUT(){
        return new HttpPut();
    }
    @Bean
    public HttpRequester requester(){
        return new SimpleHttpRequester();
    }
}
