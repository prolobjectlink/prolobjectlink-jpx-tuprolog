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
package org.prolobjectlink.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.generator.IncrementGenerator;
import org.prolobjectlink.db.generator.TimestampGenerator;
import org.prolobjectlink.db.generator.UUIDGenerator;
import org.prolobjectlink.domain.geometry.Point;

public class IdGeneratorPersistenceTest extends BaseTest {

	private IncrementGenerator incGenerator = new IncrementGenerator(Point.class);
	private TimestampGenerator timeGenerator = new TimestampGenerator(Point.class);
	private UUIDGenerator uuidGenerator = new UUIDGenerator(Point.class);

	@Test
	public final void testIncrement() {

		storage.getTransaction().begin();
		storage.insert(incGenerator);
		assertTrue(storage.contains(incGenerator));
		assertEquals(incGenerator, storage.find(incGenerator));
		storage.delete(incGenerator);
		assertFalse(storage.contains(new IncrementGenerator(Point.class)));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

	@Test
	public final void testTimestamp() {

		storage.getTransaction().begin();
		storage.insert(timeGenerator);
		assertTrue(storage.contains(timeGenerator));
		assertEquals(timeGenerator, storage.find(timeGenerator));
		storage.delete(timeGenerator);
		assertFalse(storage.contains(new TimestampGenerator(Point.class)));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

	@Test
	public final void testUUID() {

		storage.getTransaction().begin();
		storage.insert(uuidGenerator);
		assertTrue(storage.contains(uuidGenerator));
		assertEquals(uuidGenerator, storage.find(uuidGenerator));
		storage.delete(uuidGenerator);
		assertFalse(storage.contains(uuidGenerator));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

}
