import org.junit.Test;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by karlkristjansson on 10/10/16.
 */

public class StringCalculator {
    @Test
    public final void TestEmptyStringThenReturnValueIs0() {
        int sum = StringCalculator.add("");
        log.println(sum);
    }
    @Test
    public final void TestStringWithOneIntegerReturnsSum() {
        int sum = StringCalculator.add("1");
        log.println("Sum: " + sum);
    }
    @Test
    public final void TestTenNumbersThenReturnSum() {
        int sum = StringCalculator.add("1,2,3,4,5,6,7,8,9,10");
        log.println("Sum: "+sum);
    }

    public static int add(String numbers)
    {
        int sum = 0;
        String[] numberInArray = numbers.split(",");
            for (String n : numberInArray)
            {
                if(n.isEmpty())return 0;
                sum += Integer.parseInt(n);
            }
        return sum;
    }
}
