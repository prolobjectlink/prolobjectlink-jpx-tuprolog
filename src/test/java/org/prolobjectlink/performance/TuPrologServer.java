/*
 * #%L
 * prolobjectlink-jpx-tuprolog
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
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
package org.prolobjectlink.performance;

import org.prolobjectlink.db.DatabaseServer;
import org.prolobjectlink.db.DatabaseUser;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.db.persistent.RemoteDatabaseServer;
import org.prolobjectlink.pdb.prolog.tuprolog.TuPrologContainerFactory;

public class TuPrologServer {

	public static void main(String[] args) throws Exception {
		DatabaseUser sysAdmin = new DatabaseUser("sa", "");
		Settings settings = new Settings(TuPrologContainerFactory.class);
		DatabaseServer server = RemoteDatabaseServer.getInstance(settings, sysAdmin);
		if (args[0].equals("stop") && server.isRunning()) {
			server.shutdown();
		} else if (args[0].equals("start") /* && !server.isRunning() */) {
			server.startup();
		}
	}

}
