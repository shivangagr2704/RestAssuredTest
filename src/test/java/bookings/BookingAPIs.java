package bookings;

import bookings.pojos.Booking;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.Map;

public class BookingAPIs {

    public Response createBooking(Map<String, Object> createBookingPayload, Map<String,String> headers){
        String endpoint = (String) BaseTest.dataFromJsonFile.get("createBookingEndpoint");
        return RestUtils.performPost(endpoint,createBookingPayload,headers);
    }

    public Response createBooking(Booking createBookingPayload, Map<String,String> headers){
        String endpoint = (String) BaseTest.dataFromJsonFile.get("createBookingEndpoint");
        return RestUtils.performPost(endpoint,createBookingPayload,headers);
    }
}
