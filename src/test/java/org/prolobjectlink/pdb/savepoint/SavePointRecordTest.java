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
