package bookings.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.Arrays;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {
    private String firstname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String lastname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME);
    private int totalprice = RandomDataGenerator.getRandomNumber(5000,7000);
    //private String depositpaid = Stream.of("true","false").findAny().get();
    //private String depositpaid = Arrays.asList("true","false").get(RandomDataGenerator.getRandomNumber(0,2));
    private boolean depositpaid = RandomDataGenerator.getRandomBoolean();
    private BookingDates bookingdates = new BookingDates();
    private String additionalneeds = RandomDataGenerator.getRandomAlphabets(25);
}
