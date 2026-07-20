package utils.request;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtils {

    public static Map<String, String> getDefaultGetHeaders(){
        // Set default GET headers
        Map<String, String> headersGet = new HashMap<>();
        headersGet.put("Content-Type","application/json");
        headersGet.put("Accept","application/json");
        headersGet.put("User-Agent", "insomnia/11.6.1");
        headersGet.put("Accept-Encoding","gzip");
        headersGet.put("x-api-key","reqres_7aa489a96f0d404d95aac49aff402cdb");
        return headersGet;
    }
    // Set default POST headers
    public static Map<String, String> getDefaultPostHeaders(){
        Map<String, String> headersPost = new HashMap<>();
        headersPost.put("Content-Type","application/json");
        headersPost.put("Accept","application/json");
        headersPost.put("User-Agent", "insomnia/11.6.1");
        headersPost.put("Accept-Encoding","gzip");
        return headersPost;
    }

}
