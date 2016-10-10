import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by karlkristjansson on 10/10/16.
 */

public class StringCalculator {
    @Test
    public final void TestEmptyStringThenReturnValueIs0() throws Exception
    {
        int sum = StringCalculator.add("");
        log.println(sum);
    }
    @Test
    public final void TestStringWithOneIntegerReturnsSum() throws Exception
    {
        int sum = StringCalculator.add("1");
        log.println("Sum: " + sum);
    }
    @Test
    public final void TestTenNumbersThenReturnSum() throws Exception
    {
        int sum = StringCalculator.add("1,2,3,4,5,6,7,8,9,10");
        log.println("Sum: "+sum);
    }
    @Test
    public final void TestStringWithNewLineInString() throws Exception
    {
        int sum = StringCalculator.add("1,2,3,4,5\n6,7,8,9,10");
        log.println("Sum: "+sum);
    }
    @Test
    public final void TestStringWithOneNegativeNumberInString()
    {
        try
        {
            int sum = StringCalculator.add("-1,2");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public final void TestStringWithMultibleNegativeNumberInString()
    {
        try
        {
            int sum = StringCalculator.add("2,-4,3,-5");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int add(String numbers) throws Exception
    {
        int sum = 0;
        String[] numberInArray = numbers.split(",|\n");
        List<String> listNegNumbers = new ArrayList();
            for (String n : numberInArray)
            {
                String nNegative = n;
                if(n.isEmpty())
                {
                    return 0;
                }
                if(Integer.parseInt(nNegative) < 0)
                {
                    listNegNumbers.add(nNegative);
                }
                else
                {
                    sum += Integer.parseInt(n);
                }
            }
            if(!listNegNumbers.isEmpty())
            {
                String negativeNumbers = "";
                for(String nNegative: listNegNumbers )
                {
                    negativeNumbers += nNegative+",";
                }
                throw new Exception("Negatives not allowed: "+ negativeNumbers);
            }
        return sum;
    }
}
