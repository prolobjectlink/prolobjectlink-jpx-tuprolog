/*
 * #%L
 * prolobjectlink-jpx-tuprolog
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.prolobjectlink.db.OperationType.BEGIN;
import static org.prolobjectlink.db.OperationType.CLOSE;

import org.junit.Ignore;
import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.OperationType;
import org.prolobjectlink.db.savepoint.SavePointRecord;
import org.prolobjectlink.domain.geometry.Point;

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
