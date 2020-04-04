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
package io.github.prolobjectlink.db.rempdb;

import java.io.IOException;

import org.junit.Test;
import org.prolobjectlink.BaseTest;

import io.github.prolobjectlink.db.rempdb.RemoteURLConnection;

public class RemoteURLConnectionTest extends BaseTest {

	RemoteURLConnection remote = new RemoteURLConnection(remoteURL);

	@Test
	public final void testConnect() throws IOException {
		remote.connect();
	}

}
