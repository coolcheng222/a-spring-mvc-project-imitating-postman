import com.sealll.http.HttpRequester;
import com.sealll.http.SimpleHttpRequester;
import com.sealll.util.ResponseFormatter;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.RequestUserAgent;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sealll
 * @time 2021/2/6 12:16
 */
public class RequestTest {
    @Test
    public void test1() throws IllegalAccessException, IOException, InvocationTargetException {
//        SimpleHttpRequester requester = new SimpleHttpRequester();
//        HttpClientContext httpClientContext = new HttpClientContext();
//        requester.sendFormForText(httpClientContext, "https://vpns.jlu.edu.cn/", "POST",
//                null, null);
//        System.out.println(httpClientContext.getCookieStore().getCookies());
//        String post = requester.sendFormForText(httpClientContext, "https://vpns.jlu.edu.cn/login", "GET",
//                null, null);
//        System.out.println("=========");
//        System.out.println(post);
//        System.out.println("======");
    }
    @Test
    public void test2(){
        boolean valid = Jsoup.isValid("lll", Whitelist.none());
        System.out.println(valid);

    }
}
