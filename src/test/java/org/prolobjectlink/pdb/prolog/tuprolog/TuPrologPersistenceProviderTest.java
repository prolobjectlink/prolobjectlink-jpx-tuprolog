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
package org.prolobjectlink.pdb.prolog.tuprolog;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.pdb.prolog.tuprolog.TuPrologPersistenceProvider;

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
