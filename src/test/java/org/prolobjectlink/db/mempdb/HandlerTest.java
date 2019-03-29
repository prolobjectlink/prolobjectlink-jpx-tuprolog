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
package org.prolobjectlink.db.mempdb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.mempdb.Handler;
import org.prolobjectlink.db.mempdb.MemoryURLConnection;

public class HandlerTest extends BaseTest {

	private Handler handler = new Handler();

	@Test
	public final void testOpenConnectionURL() throws IOException {
		assertEquals(new MemoryURLConnection(memoryURL).getURL(), handler.openConnection(memoryURL).getURL());
	}

	@Test(expected = MalformedURLException.class)
	public final void testMalformedURLException() throws IOException {
		assertEquals(new MemoryURLConnection(new URL("")).getURL(), handler.openConnection(new URL("")).getURL());
	}

}
