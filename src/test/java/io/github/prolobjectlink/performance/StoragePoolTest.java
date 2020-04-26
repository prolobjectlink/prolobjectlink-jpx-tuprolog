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
package io.github.prolobjectlink.performance;

import java.util.List;

import io.github.prolobjectlink.db.ContainerFactory;
import io.github.prolobjectlink.db.StorageManager;
import io.github.prolobjectlink.db.StorageMode;
import io.github.prolobjectlink.db.etc.Settings;
import io.github.prolobjectlink.db.prolog.tuprolog.TuPrologContainerFactory;
import io.github.prolobjectlink.domain.geometry.Point;
import io.github.prolobjectlink.logging.LoggerUtils;

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
