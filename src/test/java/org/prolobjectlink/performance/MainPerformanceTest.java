/*
 * #%L
 * prolobjectlink-tuprolog
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
package org.prolobjectlink.performance;

import org.prolobjectlink.db.ContainerFactory;
import org.prolobjectlink.db.Storage;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.pdb.prolog.tuprolog.TuPrologContainerFactory;
import org.prolobjectlink.prolog.Prolog;
import org.prolobjectlink.prolog.PrologProvider;
import org.prolobjectlink.prolog.tuprolog.TuProlog;

public class MainPerformanceTest {

	// private static ObjectCache cache;
	private static Storage store;

	private static final int instanceNumber = 5000;

	private static final String LOCATION = "performance";
	// private static final String ROOT = "data" + File.separator + "test";

	protected static final Class<? extends ContainerFactory> driver = TuPrologContainerFactory.class;
	protected static final PrologProvider provider = Prolog.newProvider(TuProlog.class);

	public MainPerformanceTest() {
	}

	public static void main(String[] args) {

		// cache = Prolobjectlink.create(ENGINE).createCache();
		store = new Settings(driver).createStorage(LOCATION);

		Point[] array = new Point[instanceNumber];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Point("" + i + "", i, i);
		}

		// bulk addition
		long startTimeMillis = System.currentTimeMillis();

		// cache.insert(array);
		store.insert(array);
		store.flush();

		long endTimeMillis = System.currentTimeMillis();
		float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Bulk Add Duration: " + durationSeconds + " seconds");
		System.out.println();

		// contains
		startTimeMillis = System.currentTimeMillis();

		int last = instanceNumber - 1;
		// cache.contains(new Point("" + last + "", last, last));
		// store.contains(new Point("" + last + "", last, last));
		System.out.println(store.contains(new Point("" + last + "", last, last)));

		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Contains Duration: " + durationSeconds + " seconds");
		System.out.println();

		// find all
		startTimeMillis = System.currentTimeMillis();

		// cache.findAll(Point.class);
		// store.findAll(Point.class);
		// System.out.println(cache.findAll(Point.class).size());
		System.out.println(store.findAll(Point.class).size());

		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Find All Duration: " + durationSeconds + " seconds");
		System.out.println();

	}

}
