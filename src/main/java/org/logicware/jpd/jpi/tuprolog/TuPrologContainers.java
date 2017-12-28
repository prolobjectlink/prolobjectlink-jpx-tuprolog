/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2012 - 2017 Logicware Project
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
package org.logicware.jpd.jpi.tuprolog;

import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Containers;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.PrologContainers;
import org.logicware.jpi.tuprolog.TuPrologProvider;

public final class TuPrologContainers extends PrologContainers {

	static final Containers instance = new TuPrologContainers();

	protected TuPrologContainers() {
		super(new Properties(), new TuPrologProvider());
	}

	public Containers getInstance() {
		return instance;
	}

	public ContainerFactory createContainerFactory() {
		return new TuPrologContainerFactory(getProvider(), getProperties());
	}

}