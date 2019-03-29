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
package org.prolobjectlink.pdb.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.util.JavaLists;

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
