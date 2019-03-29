/*
 * #%L
 * prolobjectlink-jpx-tuprolog
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
