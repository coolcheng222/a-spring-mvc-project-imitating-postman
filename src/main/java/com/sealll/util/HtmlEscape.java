package com.sealll.util;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;

/**
 * @author sealll
 * @time 2021/2/17 23:57
 */
public class HtmlEscape {
    public static String escape(String html){
//        System.out.println(html);
        String s = HtmlUtils.htmlEscape(html);
        s = s.replace("\t","    ");
        s = s.replace(" ", "&nbsp;");
        s = s.replace("\n", "<br>");
        return s;
    }
}
