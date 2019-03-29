/*
 * #%L
 * prolobjectlink-jpx-tuprolog
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

import java.io.IOException;

import org.prolobjectlink.db.Predicate;
import org.prolobjectlink.db.Query;
import org.prolobjectlink.db.RemoteDatabase;
import org.prolobjectlink.db.TypedQuery;
import org.prolobjectlink.db.persistent.RemoteHierarchical;
import org.prolobjectlink.domain.geometry.Point;

public class TuPrologClient {

	public static void main(String[] args) throws IOException {

		RemoteDatabase db = RemoteHierarchical.newInstance("test");
		db.getTransaction().begin();
		db.insert(new Point("e", 0, 0));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

		db.getTransaction().begin();
		db.insert(new Point("f", 0, 0));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

		db.getTransaction().begin();
		db.insert(new Point("g", 0, 0));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

		//
		// Query
		//

		db.getTransaction().begin();
		Query o = db.createQuery("'" + Point.class.getName() + "'(Id,X,Y)");
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(o.count());

		db.getTransaction().begin();
		TypedQuery<Point> t = db.createQuery(new Point("b", 3, 14));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(t.count());

		db.getTransaction().begin();
		TypedQuery<Point> q = db.createQuery(Point.class);
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(q.count());

		db.getTransaction().begin();
		q = db.createQuery(new Predicate<Point>() {
			private static final long serialVersionUID = -8786146290478243973L;

			public boolean evaluate(Point o) {
				return o.getX() == 3.5;
			}
		});
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(q.count());

		//
		// Contains
		//

		db.getTransaction().begin();
		boolean b = db.contains("'" + Point.class.getName() + "'(Id,X,Y)");
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(b);

		db.getTransaction().begin();
		b = db.contains(new Point("b", 3, 14));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(b);

		db.getTransaction().begin();
		b = db.contains(Point.class);
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(b);

		db.getTransaction().begin();
		b = db.contains(new Predicate<Point>() {
			private static final long serialVersionUID = -8786146290478243973L;

			public boolean evaluate(Point o) {
				return o.getX() == 3.5;
			}
		});
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();
		System.out.println(b);

//		db.getTransaction().begin();
//		db.clear();
//		db.getTransaction().commit();
//		db.getTransaction().close();
//		db.close();

		//
		// Update
		//

		db.getTransaction().begin();
		db.update(new Point("j", 0, 0), new Point("k", 0, 0));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

		//
		// Delete
		//

		db.getTransaction().begin();
		db.delete(new Point("a", 3, 14));
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

//		db.getTransaction().begin();
//		db.delete(Point.class);
//		db.getTransaction().commit();
//		db.getTransaction().close();
//		db.close();

		//
		// Backup & Restore
		//

		db.getTransaction().begin();
		db.backup("backup/", "remote-hierarchical-test.zip");
		db.getTransaction().commit();
		db.getTransaction().close();
		db.close();

//		db.getTransaction().begin();
//		db.restore("bkp/", "remote-test.zip");
//		db.getTransaction().commit();
//		db.getTransaction().close();
//		db.close();

//		Thread thread1 = new Thread(new Runnable() {
//
//			public void run() {
//				RemoteDatabase db = RemoteHierarchical.newInstance("test");
//				db.getTransaction().begin();
//				db.insert(new Date());
//				db.getTransaction().commit();
//				db.getTransaction().close();
//				db.close();
//			}
//		});
//
//		Thread thread2 = new Thread(new Runnable() {
//
//			public void run() {
//				RemoteDatabase db = RemoteHierarchical.newInstance("test");
//				db.getTransaction().begin();
//				db.insert(new Date());
//				db.getTransaction().commit();
//				db.getTransaction().close();
//				db.close();
//			}
//		});
//
//		Thread thread3 = new Thread(new Runnable() {
//
//			public void run() {
//				RemoteDatabase db = RemoteHierarchical.newInstance("test");
//				db.getTransaction().begin();
//				db.insert(new Date());
//				db.getTransaction().commit();
//				db.getTransaction().close();
//				db.close();
//			}
//		});
//		
//		thread1.start();thread2.start();thread3.start();
//
	}

}
