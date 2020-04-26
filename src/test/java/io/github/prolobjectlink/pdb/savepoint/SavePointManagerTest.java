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
package io.github.prolobjectlink.pdb.savepoint;

import static io.github.prolobjectlink.db.OperationType.BEGIN;
import static io.github.prolobjectlink.db.OperationType.CLOSE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import io.github.prolobjectlink.BaseTest;
import io.github.prolobjectlink.db.OperationType;
import io.github.prolobjectlink.db.savepoint.SavePointRecord;
import io.github.prolobjectlink.domain.geometry.Point;

public class SavePointManagerTest extends BaseTest {

	private SavePointRecord r = new SavePointRecord(BEGIN, CLOSE, Point.class, a);

	@Test
	public final void testGetStorage() {
		assertNotNull(manager.getStorage());
	}

	@Test
	public final void testGetPersistentContainer() {
		assertNotNull(manager.getPersistentContainer());
	}

	@Test
	public final void testGetRecords() {
		assertTrue(manager.getRecords().isEmpty());
		manager.add(r);
		assertFalse(manager.getRecords().isEmpty());
	}

	@Test
	@Ignore
	public final void testSaveTransactionLogRecordTransactionLogRecord() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testSaveLongLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testSaveAll() {
		manager.add(r);
		manager.saveAll();
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAdd() {
		assertFalse(manager.contains(r));
		manager.add(r);
		assertTrue(manager.contains(r));
	}

	@Test
	public final void testRemove() {
		assertFalse(manager.contains(r));
		manager.add(r);
		assertTrue(manager.contains(r));
		manager.remove(r);
		assertFalse(manager.contains(r));
	}

	@Test
	public final void testContains() {
		assertFalse(manager.contains(r));
		manager.add(r);
		assertTrue(manager.contains(r));
	}

	@Test
	public final void testIterator() {
		assertNotNull(manager.iterator());
	}

	@Test
	public final void testClear() {

		assertTrue(manager.empty());
		manager.add(new SavePointRecord(OperationType.BEGIN, OperationType.CLOSE, Point.class, new Point("a", 1, 2)));
		assertFalse(manager.empty());
		manager.clear();
		assertTrue(manager.empty());

	}

	@Test
	public final void testEmpty() {

		assertTrue(manager.empty());
		manager.add(new SavePointRecord(OperationType.BEGIN, OperationType.CLOSE, Point.class, new Point("a", 1, 2)));
		assertFalse(manager.empty());

	}

	@Test
	public final void testSize() {

		assertEquals(0, manager.size());
		manager.add(new SavePointRecord(OperationType.BEGIN, OperationType.CLOSE, Point.class, new Point("a", 1, 2)));
		assertEquals(1, manager.size());

	}

}
