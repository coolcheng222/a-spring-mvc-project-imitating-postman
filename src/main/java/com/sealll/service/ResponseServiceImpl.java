package com.sealll.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.sealll.bean.Msg;
import com.sealll.util.HtmlEscape;
import com.sealll.util.ResponseFormatter;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author sealll
 * @time 2021/2/18 21:31
 */
@Service
public class ResponseServiceImpl implements ResponseService{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Msg getResponse(CloseableHttpResponse response) throws IOException {
        Msg msg = new Msg();
        StatusLine statusLine = response.getStatusLine();
        msg.setStatusLine(response.getStatusLine());

        String en = EntityUtils.toString(response.getEntity(), "utf-8");
        String s1 = en;
        Header[] headers = response.getHeaders("content-type");
        if(headers != null && headers.length != 0){
            String value = headers[0].getValue();
            if(value.contains("text/html")) {
                s1 = HtmlEscape.escape(ResponseFormatter.formatHtml(en));
            }else if(value.contains("json")){
                s1 = HtmlEscape.escape(gson.toJson(new JsonParser().parse(s1).getAsJsonObject()));
            }
        }
        String s = HtmlEscape.escape(en);
        msg.setEntity(s);
        msg.setHeader(response.getAllHeaders());
        msg.setFormatted(s1);
        return msg;
    }
}
