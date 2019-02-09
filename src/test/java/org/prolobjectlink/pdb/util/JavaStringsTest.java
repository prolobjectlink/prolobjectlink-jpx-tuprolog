/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package org.prolobjectlink.pdb.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.prolobjectlink.db.util.JavaStrings;

public class JavaStringsTest {

	@Test
	public final void testRandomCharString32() {
		assertEquals(32, JavaStrings.randomCharString32().length());
	}

	@Test
	public final void testRandomCharString64() {
		assertEquals(64, JavaStrings.randomCharString64().length());
	}

	@Test
	public final void testRandomCharString() {
		assertEquals(32, JavaStrings.randomCharString(32).length());
		assertEquals(64, JavaStrings.randomCharString(64).length());
		assertEquals(128, JavaStrings.randomCharString(128).length());
	}

	@Test
	public final void testToUpperCase() {
		assertEquals("STRING", JavaStrings.toUpperCase("string"));
	}

	@Test
	public final void testToLowerCase() {
		assertEquals("string", JavaStrings.toLowerCase("STRING"));
	}

}
