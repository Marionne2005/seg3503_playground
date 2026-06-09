import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {

    private int year, month, day;

    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // TC   year   month  day
            /* 16 */ { 1500,  2, 31 },
            /* 17 */ { 1500,  2, 29 },
            /* 18 */ {   -1,  10, 20 },   
            /* 19 */ { 1458, 15, 12 },
            /* 20 */ { 1975,  6, -50 },
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextDateThrowsException() {
        new Date(year, month, day);
    }
}
