package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringPreviewCreatorTest {

	@Test
	public void test_normal() {
		assertEquals("text", StringPreviewCreator.createPreview("text", 10));
	}

	@Test
	public void test_long() {
		assertEquals("lo...", StringPreviewCreator.createPreview("longtext", 5));
	}

	@Test
	public void test_short() {
		assertEquals("tex", StringPreviewCreator.createPreview("tex", 3));
	}

	@Test
	public void test_short2() {
		assertEquals("...", StringPreviewCreator.createPreview("text", 3));
	}

	@Test
	public void test_tooShort() {
		assertThrows(IllegalArgumentException.class, () -> StringPreviewCreator.createPreview("text", 2));
	}

}
