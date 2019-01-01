/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2012 - 2018 WorkLogic Project
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
package org.logicware.pdb.prolog.tuprolog;

import org.logicware.database.ContainerFactory;
import org.logicware.database.HierarchicalCache;
import org.logicware.database.etc.Settings;
import org.logicware.database.prolog.PrologHierarchicalCache;
import org.logicware.prolog.PrologProvider;

public class TuPrologHierarchicalCache extends PrologHierarchicalCache implements HierarchicalCache {

	public TuPrologHierarchicalCache(PrologProvider provider, Settings settings, ContainerFactory containerFactory) {
		super(provider, settings, new TuPrologContainerFactory(settings));
	}

}
