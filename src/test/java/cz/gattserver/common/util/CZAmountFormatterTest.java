package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CZAmountFormatterTest {

	@Test
	public void testFormat() {
		CZAmountFormatter formatter = new CZAmountFormatter("%d kostka", "%d kostky", "%d kostek");
		assertEquals("-", formatter.format(null));
		assertEquals("-", formatter.format(0));
		assertEquals("1 kostka", formatter.format(1));
		assertEquals("2 kostky", formatter.format(2));
		assertEquals("5 kostek", formatter.format(5));

		formatter = new CZAmountFormatter("%d kostka", "%d kostky", "%d kostek", "nic");
		assertEquals("nic", formatter.format(null));
		assertEquals("nic", formatter.format(0));
	}

}
