package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class CZComparatorTest {

	@Test
	public void testResetTime() throws ParseException {
		CZComparator comparator = new CZComparator();

		// http://prirucka.ujc.cas.cz/?id=900
		assertEquals(-1, comparator.compare("Ámos", "Rek"));
		assertEquals(-1, comparator.compare("Ámos", "Anna"));
		assertEquals(-1, comparator.compare("kanon", "kanón"));
		assertEquals(-1, comparator.compare("kanón", "kaňon"));
		assertEquals(-1, comparator.compare("kaňon", "kánon"));

		assertEquals(-1, comparator.compare("shoda", "schody"));
		assertEquals(-1, comparator.compare("schody", "sídliště"));

		assertEquals(-1, comparator.compare("motýl noční ", "motýlek"));

		// tohle je obráceně
		assertEquals(-1, comparator.compare("Damašek", "damašek"));

		assertEquals(-1, comparator.compare("da capo", "ďábel"));
		assertEquals(-1, comparator.compare("ďábel", "dabing"));

		assertEquals(-1, comparator.compare("ucho", "úchop"));
		assertEquals(-1, comparator.compare("úchop", "uchopit"));

		assertEquals(-1, comparator.compare("ZZ", "Z-2"));
		assertEquals(-1, comparator.compare("Z-2", "Ž"));
		assertEquals(-1, comparator.compare("Ž", "3"));
		assertEquals(-1, comparator.compare("3", "3N"));
		assertEquals(-1, comparator.compare("3N", "3no"));
		assertEquals(-1, comparator.compare("3no", "5A"));
		assertEquals(-1, comparator.compare("5A", "8"));
	}

}
