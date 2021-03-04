package com.sealll.util;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author sealll
 * @time 2021/2/17 22:35
 */
public class ResponseFormatter {
    public static String formatHtml(String html){
        return Jsoup.parse(html).toString();
    }
}
