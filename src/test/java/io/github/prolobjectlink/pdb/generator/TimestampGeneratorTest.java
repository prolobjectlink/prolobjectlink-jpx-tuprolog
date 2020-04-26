/*
 * #%L
 * prolobjectlink-jpx-tuprolog
 * %%
 * Copyright (C) 2012 - 2019 Prolobjectlink Project
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
package io.github.prolobjectlink.pdb.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.prolobjectlink.BaseTest;
import io.github.prolobjectlink.db.generator.TimestampGenerator;
import io.github.prolobjectlink.domain.geometry.Point;

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
