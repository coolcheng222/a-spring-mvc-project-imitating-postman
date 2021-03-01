package com.sealll.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
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
