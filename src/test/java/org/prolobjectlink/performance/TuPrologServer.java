/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
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
