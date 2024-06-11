package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames){
        switch (dataTypeNames){
            case FIRSTNAME :
                return faker.name().firstName();
            case LASTNAME :
                return faker.name().lastName();
            case FULLNAME :
                return faker.name().fullName();
            case COUNTRY :
                return faker.address().country();
            case CITYNAME :
                return faker.address().cityName();
            default :
                return "Data Type Name not available";
        }
    }

    public static String getRandomFutureDate(int atMostDays){
        return faker.date().future(atMostDays, TimeUnit.DAYS,"YYYY-MM-dd");
    }

    public static String getRandomNumber(int size){
        return faker.number().digits(size);
    }

    public static int getRandomNumber(int lowerLimit, int upperLimit){
        return faker.number().numberBetween(lowerLimit,upperLimit);
    }

    public static String getRandomAlphabets(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }
}
