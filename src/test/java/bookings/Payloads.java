package bookings;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateBookingPayloadAsString(String firstName, String lastName, String totalPrice, String depositPaid, String checkInDate, String checkOutDate, String additionalNeeds){
        String payload = "{\n" +
                "    \"firstname\": \""+firstName+"\",\n" +
                "    \"lastname\": \""+lastName+"\",\n" +
                "    \"totalprice\": "+totalPrice+",\n" +
                "    \"depositpaid\": "+depositPaid+",\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \""+checkInDate+"\",\n" +
                "        \"checkout\": \""+checkOutDate+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \""+additionalNeeds+"\"\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getCreateBookingPayloadAsMap(String firstName, String lastName, String totalPrice, String depositPaid, String checkInDate, String checkOutDate, String additionalNeeds){
        Map<String,Object> payload = new HashMap<>();
        payload.put("firstname",firstName);
        payload.put("lastname",lastName);
        payload.put("totalprice",totalPrice);
        payload.put("depositpaid",depositPaid);
        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin",checkInDate);
        bookingDates.put("checkout",checkOutDate);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds",additionalNeeds);
        return payload;
    }
}
