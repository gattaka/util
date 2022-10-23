package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HumanBytesSizeFormatterTest {

	@Test
	public void test_SI() {
		assertEquals("123 B", HumanBytesSizeFormatter.format(123L));
		assertEquals("999 B", HumanBytesSizeFormatter.format(999L));
		assertEquals("1,0 kB", HumanBytesSizeFormatter.format(1000L));
		assertEquals("2,2 kB", HumanBytesSizeFormatter.format(2234L));
		assertEquals("3,8 MB", HumanBytesSizeFormatter.format(3834567L));
		assertEquals("4,1 GB", HumanBytesSizeFormatter.format(4134567890L));
		assertEquals("5,5 TB", HumanBytesSizeFormatter.format(5521234567890L));
		assertEquals("6,4 PB", HumanBytesSizeFormatter.format(6421234567890521L));
		assertEquals("7,3 EB", HumanBytesSizeFormatter.format(7321234567890521234L));
	}

	@Test
	public void test_NotSI() {
		assertEquals("123 B", HumanBytesSizeFormatter.format(123L, false));
		assertEquals("1023 B", HumanBytesSizeFormatter.format(1023L, false));
		assertEquals("1,0 KiB", HumanBytesSizeFormatter.format(1024L, false));
		assertEquals("1,1 KiB", HumanBytesSizeFormatter.format(1124L, false));
		assertEquals("1,0 MiB", HumanBytesSizeFormatter.format(1048576L, false));
		assertEquals("1,0 GiB", HumanBytesSizeFormatter.format(1073741824L, false));
		assertEquals("1,0 TiB", HumanBytesSizeFormatter.format(1099511627776L, false));
		assertEquals("1,0 PiB", HumanBytesSizeFormatter.format(1125899906842624L, false));
		assertEquals("1,0 EiB", HumanBytesSizeFormatter.format(1152921504606846976L, false));
	}

}
