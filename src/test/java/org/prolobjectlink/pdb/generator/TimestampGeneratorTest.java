/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2012 - 2019 Prolobjectlink Project
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
package org.prolobjectlink.pdb.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.generator.TimestampGenerator;
import org.prolobjectlink.domain.geometry.Point;

public class TimestampGeneratorTest extends BaseTest {

	private TimestampGenerator generator = new TimestampGenerator(Point.class);

	@Test
	public final void testGenerateId() {
		assertNotSame(generator.generateId(), generator.generateId());
	}

	@Test
	public final void testGetValue() {
		assertNotNull(generator.getValue());
	}

	@Test
	public final void testGetType() {
		assertEquals(Point.class, generator.getType());
	}

}
