package bookings.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Booking {
    private String firstname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String lastname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME);
    private int totalprice = RandomDataGenerator.getRandomNumber(5000,7000);
    private String depositpaid = "true";
    private BookingDates bookingdates = new BookingDates();
    private String additionalneeds = RandomDataGenerator.getRandomAlphabets(25);
}
