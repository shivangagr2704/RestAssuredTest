package bookings;

import bookings.pojos.Booking;
import bookings.pojos.BookingDates;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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
        payload.put("firstname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("lastname",RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME));
        payload.put("totalprice",RandomDataGenerator.getRandomNumber(5000,7000));
        payload.put("depositpaid","true");
        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin",RandomDataGenerator.getRandomFutureDate(1));
        bookingDates.put("checkout",RandomDataGenerator.getRandomFutureDate(10));
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds", RandomDataGenerator.getRandomAlphabets(25));
        return payload;
    }

    public static Booking getCreateBookingPayloadFromPojo(){
        BookingDates bookingDates = BookingDates.builder()
                .checkin(RandomDataGenerator.getRandomFutureDate(1))
                .checkout(RandomDataGenerator.getRandomFutureDate(10))
                .build();

        return Booking.builder()
                .firstname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
                .lastname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME))
                .totalprice(RandomDataGenerator.getRandomNumber(5000,7000))
                .depositpaid("true")
                .bookingdates(bookingDates)
                .additionalneeds(RandomDataGenerator.getRandomAlphabets(25))
                .build();
    }
}
