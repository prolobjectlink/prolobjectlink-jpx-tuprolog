/*-
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
package io.github.prolobjectlink.db.prolog.tuprolog;

import alice.tuprolog.Prolog;
import io.github.prolobjectlink.db.prolog.PrologDatabaseEngine;
import io.github.prolobjectlink.db.prolog.PrologDatabaseProvider;
import io.github.prolobjectlink.prolog.tuprolog.TuProlog;

public class TuPrologDatabaseProvider extends TuProlog implements PrologDatabaseProvider {

	public PrologDatabaseEngine newEngine() {
		Prolog prolog = new Prolog();
		return new TuPrologDatabaseEngine(this, prolog);
	}

	public PrologDatabaseEngine newEngine(String path) {
		PrologDatabaseEngine engine = newEngine();
		engine.consult(path);
		return engine;
	}

}
