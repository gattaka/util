package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void testResetTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 6, 9, 12, 34, 56);
        cal.set(Calendar.MILLISECOND, 951);
        Date date = cal.getTime();
        Date resetDate = DateUtils.resetTime(date);
        cal.setTime(resetDate);
        assertEquals(2019, cal.get(Calendar.YEAR));
        assertEquals(6, cal.get(Calendar.MONTH));
        assertEquals(9, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, cal.get(Calendar.MINUTE));
        assertEquals(0, cal.get(Calendar.SECOND));
        assertEquals(0, cal.get(Calendar.MILLISECOND));
    }

    @Test
    public void testResetTimeToMidnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 6, 9, 12, 34, 56);
        cal.set(Calendar.MILLISECOND, 951);
        Date date = cal.getTime();
        Date resetDate = DateUtils.resetTimeToMidnight(date);
        cal.setTime(resetDate);
        assertEquals(2019, cal.get(Calendar.YEAR));
        assertEquals(6, cal.get(Calendar.MONTH));
        assertEquals(9, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(23, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(59, cal.get(Calendar.MINUTE));
        assertEquals(59, cal.get(Calendar.SECOND));
        assertEquals(0, cal.get(Calendar.MILLISECOND));
    }

    @Test
    public void testToLocalDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 6, 9, 12, 34, 56);
        cal.set(Calendar.MILLISECOND, 951);
        Date date = cal.getTime();
        LocalDate localDate = DateUtils.toLocalDate(date);
        assertEquals(2019, localDate.getYear());
        // Ve starém Date byly měsíce číslovány od 0, v novém LocalDate je to už
        // od 1, takže je vše o 1 posunuté
        assertEquals(Month.JULY, localDate.getMonth());
        assertEquals(7, localDate.getMonthValue());
        assertEquals(9, localDate.getDayOfMonth());
    }

    @Test
    public void testToLocalDateNull() {
        assertNull(DateUtils.toLocalDate(null));
    }

    @Test
    public void testToDate() {
        LocalDate localDate = LocalDate.of(2019, 7, 9);
        Date date = DateUtils.toDate(localDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        assertEquals(2019, cal.get(Calendar.YEAR));
        assertEquals(6, cal.get(Calendar.MONTH));
        assertEquals(9, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, cal.get(Calendar.MINUTE));
        assertEquals(0, cal.get(Calendar.SECOND));
        assertEquals(0, cal.get(Calendar.MILLISECOND));
    }

    @Test
    public void testToDateNull() {
        assertNull(DateUtils.toDate(null));
    }
}
