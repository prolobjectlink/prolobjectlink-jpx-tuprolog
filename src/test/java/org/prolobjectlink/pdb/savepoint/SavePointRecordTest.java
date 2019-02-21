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
package org.prolobjectlink.pdb.savepoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.prolobjectlink.db.OperationType.BEGIN;
import static org.prolobjectlink.db.OperationType.CLOSE;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.savepoint.SavePointRecord;
import org.prolobjectlink.domain.geometry.Point;

public class SavePointRecordTest extends BaseTest {

	private SavePointRecord r = new SavePointRecord(BEGIN, CLOSE, Point.class, a);

	@Test
	public final void testHashCode() {
		assertEquals(r.hashCode(), r.hashCode());
	}

	@Test
	public final void testCommitType() {
		assertEquals(BEGIN, r.getCommitType());
	}

	@Test
	public final void testRollbackType() {
		assertEquals(CLOSE, r.getRollbackType());
	}

	@Test
	public final void testGetRecord() {
		assertEquals(a, r.getRecord());
	}

	@Test
	public final void testRecordClass() {
		assertEquals(Point.class, r.getRecordClass());
	}

	@Test
	public final void testGetTime() {
		assertTrue(r.getTime() > 0);
		assertTrue(r.getTime() < System.currentTimeMillis());
	}

	@Test
	public final void testToString() {
		assertEquals("SavePointRecord [record=Point [idp=a, x=3, y=14]]", "" + r + "");
	}

	@Test
	public final void testEqualsObject() {
		assertEquals(r, r);
	}

	@Test
	public final void testCompareTo() {
		assertTrue(new SavePointRecord(BEGIN, CLOSE, Point.class, a).compareTo(r) > 0);
		assertTrue(r.compareTo(new SavePointRecord(BEGIN, CLOSE, Point.class, a)) < 0);
		assertTrue(r.compareTo(r) == 0);
	}

}
