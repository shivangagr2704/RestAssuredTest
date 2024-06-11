package bookings.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private String depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
