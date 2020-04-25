/*
 * #%L
 * prolobjectlink-jpx-tuprolog
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
package org.prolobjectlink.pdb.predicate;

import org.junit.Test;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Polygon;
import org.prolobjectlink.domain.geometry.Segment;

import io.github.prolobjectlink.db.predicate.InstanceOfPredicate;

public class InstanceOfPredicateTest extends BasePredicateTest {

	@Test
	public final void testEvaluate() {

		assertTrue(new InstanceOfPredicate<Point>(Point.class), a);
		assertTrue(new InstanceOfPredicate<Segment>(Segment.class), ab);
		assertTrue(new InstanceOfPredicate<Polygon>(Polygon.class), triangle);

	}

}
