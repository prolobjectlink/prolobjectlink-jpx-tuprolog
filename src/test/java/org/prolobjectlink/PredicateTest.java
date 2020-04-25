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
package org.prolobjectlink;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Segment;

import io.github.prolobjectlink.db.Predicate;

public class PredicateTest extends BaseTest {

	@Test
	public final void testEvaluate() {

		storage.getTransaction().begin();

		Point point = storage.find(new Predicate<Point>() {

			private static final long serialVersionUID = -2576020513680990743L;

			public boolean evaluate(Point point) {
				return point.getIdp() != null && point.getIdp().equals("a");
			}
		});

		assertEquals(a, point);

		List<Point> points = storage.findAll(new Predicate<Point>() {

			private static final long serialVersionUID = 1688234976465113447L;

			public boolean evaluate(Point point) {
				return (point.getX() == 3) && (point.getY() == 14);
			}
		});

		assertEquals(Arrays.asList(a, b, c, d), points);

		Segment segment = storage.find(new Predicate<Segment>() {

			private static final long serialVersionUID = -7999515340519553207L;

			public boolean evaluate(Segment s) {
				return s.getIds() != null && s.getIds().equals("bc");
			}
		});

		assertEquals(bc, segment);

		segment = storage.find(new Predicate<Segment>() {

			private static final long serialVersionUID = 763470329467668657L;

			public boolean evaluate(Segment s) {

				return (s.getPoint0() != null) && (s.getPoint1() != null) && (s.getPoint0().equals(a))
						&& (s.getPoint1().equals(b));
			}
		});

		assertEquals(ab, segment);

		List<Segment> segments = storage.findAll(new Predicate<Segment>() {

			private static final long serialVersionUID = -6373871482433417976L;

			public boolean evaluate(Segment s) {

				return true;

			}
		});

		assertEquals(Arrays.asList(ab, bc, ca, cd, da), segments);

		// query

		points = storage.createQuery(new Predicate<Point>() {

			private static final long serialVersionUID = 2134840374720572436L;

			public boolean evaluate(Point point) {
				return (point.getX() == 3) && (point.getY() == 14);
			}
		})

				.getSolutions();

		assertEquals(Arrays.asList(a, b, c, d), points);

		segments = storage.createQuery(new Predicate<Segment>() {

			private static final long serialVersionUID = -3157463362310556224L;

			public boolean evaluate(Segment s) {

				return true;

			}
		})

				.getSolutions();

		assertEquals(Arrays.asList(ab, bc, ca, cd, da), segments);

		segments = storage.findAll(new Predicate<Segment>() {

			private static final long serialVersionUID = 4229130373863454783L;

			public boolean evaluate(Segment s) {

				return s.getPoint0().equals(new Point("a", 3, 14))

						&&

						s.getPoint1().equals(new Point("b", 3, 14));

			}
		});

		assertEquals(Arrays.asList(ab), segments);
		// assertEquals(Arrays.asList(ab, bc, ca, cd, da), segments);

		storage.getTransaction().close();

	}

}
