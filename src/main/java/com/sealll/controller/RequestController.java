package com.sealll.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sealll.bean.Msg;
import com.sealll.http.HttpRequester;
import com.sealll.service.InfoParseService;
import com.sealll.bean.Info;
import com.sealll.service.RequestService;
import com.sealll.service.ResponseService;
import com.sealll.util.HtmlEscape;
import com.sealll.util.ResponseFormatter;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;


/**
 * @author com.sealll
 * @time 2021/1/25 14:15
 */
@Controller
public class RequestController {

    @Autowired
    private Logger logger;
    @Autowired
    private RequestService requestService;
    @Autowired
    private ResponseService responseService;



    @ResponseBody
    @RequestMapping(value="/post",method = RequestMethod.POST,headers = {
        "content-type=application/json"
    })
    public Msg getMappingForm(@RequestBody Info info, HttpServletRequest req){
        logger.info(req.getRemoteAddr());
        return parseInfoAndRequest(info);
    }

    private Msg parseInfoAndRequest(Info info) {
        try {
            logger.info(info.toString());

            CloseableHttpResponse response = requestService.getResponse(info);
            Msg msg = responseService.getResponse(response);
            return msg;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
