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
package org.prolobjectlink.pdb.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.prolobjectlink.BaseTest;

import io.github.prolobjectlink.db.util.JavaLists;

public class JavaListsTest extends BaseTest {

	@Test
	public void testArrayList() {
		assertEquals(new ArrayList<Object>(), JavaLists.arrayList());
	}

	@Test
	public void testArrayListInt() {
		assertEquals(new ArrayList<Object>(10), JavaLists.arrayList(10));
	}

	@Test
	public void testArrayListCollectionOfT() {
		assertEquals(new ArrayList<Object>(Arrays.asList(1, 2, 3, 4, 5)),
				JavaLists.arrayList(Arrays.asList(1, 2, 3, 4, 5)));
	}

}
