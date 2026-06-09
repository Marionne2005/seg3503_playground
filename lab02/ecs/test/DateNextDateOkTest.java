import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {

    private int inYear, inMonth, inDay;
    private int expYear, expMonth, expDay;

    public DateNextDateOkTest(int inYear, int inMonth, int inDay,
                              int expYear, int expMonth, int expDay) {
        this.inYear  = inYear;  this.inMonth  = inMonth;  this.inDay  = inDay;
        this.expYear = expYear; this.expMonth = expMonth; this.expDay = expDay;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // TC  inY    inM  inD   expY   expM expD
            /* 1  */ { 1700,  6, 20,  1700,  6, 21 },
            /* 2  */ { 2005,  4, 15,  2005,  4, 16 },
            /* 3  */ { 1901,  7, 20,  1901,  7, 21 },
            /* 4  */ { 3456,  3, 27,  3456,  3, 28 },
            /* 5  */ { 1500,  2, 17,  1500,  2, 18 },
            /* 6  */ { 1700,  6, 29,  1700,  6, 30 },
            /* 7  */ { 1800, 11, 29,  1800, 11, 30 },
            /* 8  */ { 3453,  1, 29,  3453,  1, 30 },
            /* 9  */ {  444,  2, 29,   444,  3,  1 },
            /* 10 */ { 2005,  4, 30,  2005,  5,  1 },
            /* 11 */ { 3453,  1, 30,  3453,  1, 31 },
            /* 12 */ { 3456,  3, 30,  3456,  3, 31 },
            /* 13 */ { 1901,  7, 31,  1901,  8,  1 },
            /* 14 */ { 3453,  1, 31,  3453,  2,  1 },
            /* 15 */ { 3456, 12, 31,  3457,  1,  1 },
        });
    }

    @Test
    public void testNextDate() {
        Date input    = new Date(inYear, inMonth, inDay);
        Date expected = new Date(expYear, expMonth, expDay);
        assertEquals(expected, input.nextDate());
    }
}
