package bookings.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingDates {
    private String checkin = RandomDataGenerator.getRandomFutureDate(1);
    private String checkout = RandomDataGenerator.getRandomFutureDate(10);
}
