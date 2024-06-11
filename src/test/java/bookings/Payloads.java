package bookings;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    public static Map<String, Object> getCreateBookingPayloadAsMap(){
        Map<String,Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("firstname",faker.name().firstName());
        payload.put("lastname",faker.name().lastName());
        payload.put("totalprice",faker.number().numberBetween(5000,7000));
        payload.put("depositpaid","true");
        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin",faker.date().future(1, TimeUnit.DAYS,"YYYY-MM-dd"));
        bookingDates.put("checkout",faker.date().future(10, TimeUnit.DAYS,"YYYY-MM-dd"));
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds", RandomStringUtils.randomAlphabetic(25));
        return payload;
    }
}
