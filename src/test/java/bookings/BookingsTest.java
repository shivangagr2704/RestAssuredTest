package bookings;

import bookings.pojos.Booking;
import bookings.pojos.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookingsTest extends BookingAPIs{

    /*@Test
    public void createBooking(){
        String endpoint = "https://restful-booker.herokuapp.com/booking";
        String payload = Payloads.getCreateBookingPayloadAsString("Test","Name","1234","true","2024-01-01","2025-01-01","breakfast");
        Map<String,String> headers = new LinkedHashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Accept","application/json");

        Response response = RestUtils.performPost(endpoint,payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking2(){
        String endpoint = "https://restful-booker.herokuapp.com/booking";
        Map<String,Object> payload = Payloads.getCreateBookingPayloadAsMap("Test","Name","1234","true","2024-01-01","2025-01-01","breakfast");
        Map<String,String> headers = new LinkedHashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Accept","application/json");

        Response response = RestUtils.performPost(endpoint,payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking3() throws IOException {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String,Object> data = JsonUtils.getJsonDataAsMap("bookings/"+env+"/bookingsApiData.json");
        String endpoint = (String) data.get("createBookingEndpoint");
        Map<String,Object> payload = Payloads.getCreateBookingPayloadAsMap("Test","Name","1234","true","2024-01-01","2025-01-01","breakfast");
        Map<String,String> headers = new LinkedHashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Accept","application/json");

        Response response = RestUtils.performPost(endpoint,payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking4(){
        Map<String,Object> payload = Payloads.getCreateBookingPayloadAsMap("Test","Name","1234","true","2024-20-29","2025-20-30","breakfast");
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking5WithRandomData(){
        Map<String,Object> payload = Payloads.getCreateBookingPayloadAsMap();
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking6WithPojo(){
        Booking payload = Payloads.getCreateBookingPayloadFromPojo();
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking7WithDefaultValuesInPojo(){
        Booking payload = new Booking();
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooking8WithPassingPartialVales(){
        BookingDates dates = new BookingDates().toBuilder().checkin("2024-01-01").checkout("2024-01-05").build();
        Booking payload = new Booking().toBuilder().bookingdates(dates).depositpaid(true).build();
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);
        Assert.assertEquals(response.statusCode(),200);
    }*/

    @Test
    public void createBookingAndVerifyResponse() throws JsonProcessingException {
        Booking payload = new Booking();
        Map<String,String> headers = Headers.getCreateBookingHeaders();
        Response response = createBooking(payload,headers);

        // Way 1 - Comparing each field individually
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"),payload.getFirstname());

        // Way 2 - Map response part as POJO class and compare

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJsonTree = objectMapper.readTree(response.getBody().asString());
        String bookingDetails = responseJsonTree.get("booking").toString();
        Booking createBookingResponse = objectMapper.readValue(bookingDetails, Booking.class);

        Assert.assertEquals(createBookingResponse,payload);

    }


}
