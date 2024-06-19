package bookings.javersUsage;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.ListCompareAlgorithm;

import java.util.Arrays;

public class JaversTest {

    public static void main(String[] args) {

        Address a1 = new Address();
        a1.setId(123);
        a1.setAddressLine("Address Line 1");

        Address a2 = new Address();
        a2.setId(234);
        a2.setAddressLine("Address Line 2");

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shivang");
        s1.setAddress(Arrays.asList(a1,a2));

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Agrawal");
        s2.setAddress(Arrays.asList(a2,a1));

        Javers javers = JaversBuilder.javers().withListCompareAlgorithm(ListCompareAlgorithm.AS_SET).build();
        Diff diff = javers.compare(s2,s1);
        System.out.println(diff.prettyPrint());
        System.out.println(diff.getChanges());
    }
}
