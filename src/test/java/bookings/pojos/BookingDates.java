package bookings.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.RandomDataGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDates {
    private String checkin = RandomDataGenerator.getRandomFutureDate(1);
    private String checkout = RandomDataGenerator.getRandomFutureDate(10);
}
