import org.junit.Test;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by karlkristjansson on 10/10/16.
 */

public class StringCalculator {

    @Test
    public final void TestStringWithTwoIntegersReturnsSum() {
        int sum = StringCalculator.add("1,2");
        log.println("Sum: " + sum);
    }
    @Test
    public final void TestStringWithOneIntegerReturnsSum() {
        int sum = StringCalculator.add("1");
        log.println("Sum: " + sum);
    }
    @Test
    public final void TestEmptyStringThenReturnValueIs0() {
        int sum = StringCalculator.add("");
        log.println(sum);
    }

    public static int add(String numbers)
    {
        int sum = 0;
        String[] numberInArray = numbers.split(",");
        if(numberInArray.length <= 2)
        {
            for (String n : numberInArray)
            {
                if(n.isEmpty())return 0;
                sum += Integer.parseInt(n);
            }
        }
        return sum;
    }
}
