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
package org.prolobjectlink.pdb.prolog.tuprolog;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.prolog.tuprolog.TuPrologPersistenceProvider;

public class TuPrologPersistenceProviderTest extends BaseTest {

	private TuPrologPersistenceProvider provider;

	@Before
	public void setUp() throws Exception {
		provider = new TuPrologPersistenceProvider();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testTuPrologPersistenceProvider() {
		assertNotNull(provider.createEntityManagerFactory("test", properties));
	}

}
