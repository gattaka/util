package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MoneyFormatterTest {

    @Test
    public void testMoney() {
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(200.0));
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(200));
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(200.005));
        assertEquals("200,90\u00a0Kč", MoneyFormatter.format(200.9));
    }

    @Test
    public void testMoney2() {
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(new BigDecimal(200.0)));
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(new BigDecimal(200)));
        assertEquals("200,00\u00a0Kč", MoneyFormatter.format(new BigDecimal(200.005)));
        assertEquals("200,90\u00a0Kč", MoneyFormatter.format(new BigDecimal(200.9)));
    }

}
