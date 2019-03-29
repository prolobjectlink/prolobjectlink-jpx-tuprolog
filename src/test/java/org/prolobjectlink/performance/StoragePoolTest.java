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
package org.prolobjectlink.performance;

import java.util.List;

import org.prolobjectlink.db.ContainerFactory;
import org.prolobjectlink.db.StorageManager;
import org.prolobjectlink.db.StorageMode;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.db.prolog.tuprolog.TuPrologContainerFactory;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.logging.LoggerUtils;

public class StoragePoolTest {

	private static final int instanceNumber = 1200;

	public static void main(String[] args) {

		LoggerUtils.debug(StoragePoolTest.class, "Creating Array");
		ContainerFactory factory = new Settings(TuPrologContainerFactory.class).getContainerFactory();
		StorageManager manager = factory.createStorageManager("manager-test", StorageMode.STORAGE_POOL);
		Point[] points = new Point[instanceNumber];
		for (int i = 0; i < instanceNumber; i++) {
			Point point = new Point("" + i + "", i, i);
			points[i] = point;
		}
		LoggerUtils.debug(StoragePoolTest.class, "Array Created");

		LoggerUtils.debug(StoragePoolTest.class, "Inserting Points");
		manager.insert(points);
		LoggerUtils.debug(StoragePoolTest.class, "Points Inserted");
		// try {
		// Point p=manager.createQuery(new Point(""+(instanceNumber-1)+"",
		// instanceNumber-1, instanceNumber-1)).getSolution();
		// System.out.println(p);
		// } catch (NonSolutionError ex) {
		// Logger.getLogger(ProlobjectlinkTest.class.getName()).log(Level.SEVERE,
		// null, ex);
		// }

		List<Point> ps = manager.createQuery(Point.class).getSolutions();
		for (Point p : ps) {
			System.out.println(p);
		}
	}

}
