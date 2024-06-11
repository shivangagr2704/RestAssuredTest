package bookings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Headers {

    public static Map<String, String> getCreateBookingHeaders(){
        Map<String,String> headers = new LinkedHashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Accept","application/json");
        return headers;
    }
}
