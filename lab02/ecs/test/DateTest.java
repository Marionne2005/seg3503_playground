import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    // ── Cas sans exception (TC 1–15) ──────────────────────────────────────

    @Test
    public void tc01_middleOfMonth() {
        Date d = new Date(1700, 6, 20);
        assertEquals(new Date(1700, 6, 21), d.nextDate());
    }

    @Test
    public void tc02_middleOfMonth2() {
        Date d = new Date(2005, 4, 15);
        assertEquals(new Date(2005, 4, 16), d.nextDate());
    }

    @Test
    public void tc03_middleOfMonth3() {
        Date d = new Date(1901, 7, 20);
        assertEquals(new Date(1901, 7, 21), d.nextDate());
    }

    @Test
    public void tc04_middleOfMonth4() {
        Date d = new Date(3456, 3, 27);
        assertEquals(new Date(3456, 3, 28), d.nextDate());
    }

    @Test
    public void tc05_februaryMiddle() {
        Date d = new Date(1500, 2, 17);
        assertEquals(new Date(1500, 2, 18), d.nextDate());
    }

    @Test
    public void tc06_endOf30DayMonth() {
        Date d = new Date(1700, 6, 29);
        assertEquals(new Date(1700, 6, 30), d.nextDate());
    }

    @Test
    public void tc07_endOf30DayMonth2() {
        Date d = new Date(1800, 11, 29);
        assertEquals(new Date(1800, 11, 30), d.nextDate());
    }

    @Test
    public void tc08_endOf31DayMonth() {
        Date d = new Date(3453, 1, 29);
        assertEquals(new Date(3453, 1, 30), d.nextDate());
    }

    @Test
    public void tc09_leapYearFeb29() {
        Date d = new Date(444, 2, 29);
        assertEquals(new Date(444, 3, 1), d.nextDate());
    }

    @Test
    public void tc10_endOf30DayMonthRollover() {
        Date d = new Date(2005, 4, 30);
        assertEquals(new Date(2005, 5, 1), d.nextDate());
    }

    @Test
    public void tc11_day30Of31DayMonth() {
        Date d = new Date(3453, 1, 30);
        assertEquals(new Date(3453, 1, 31), d.nextDate());
    }

    @Test
    public void tc12_day30Of31DayMonth2() {
        Date d = new Date(3456, 3, 30);
        assertEquals(new Date(3456, 3, 31), d.nextDate());
    }

    @Test
    public void tc13_day31RolloverMonth() {
        Date d = new Date(1901, 7, 31);
        assertEquals(new Date(1901, 8, 1), d.nextDate());
    }

    @Test
    public void tc14_day31RolloverMonth2() {
        Date d = new Date(3453, 1, 31);
        assertEquals(new Date(3453, 2, 1), d.nextDate());
    }

    @Test
    public void tc15_lastDayOfYear() {
        Date d = new Date(3456, 12, 31);
        assertEquals(new Date(3457, 1, 1), d.nextDate());
    }

    // ── Cas avec exception (TC 16–20) ─────────────────────────────────────

    @Test
    public void tc16_feb31Invalid() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1500, 2, 31));
    }

    @Test
    public void tc17_feb29NonLeapInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1500, 2, 29));
    }

    @Test
    public void tc18_yearZeroMonthInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Date(-1, 10, 20));
    }

    @Test
    public void tc19_monthInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1458, 15, 12));
    }

    @Test
    public void tc20_negativeDayInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1975, 6, -50));
    }
}
