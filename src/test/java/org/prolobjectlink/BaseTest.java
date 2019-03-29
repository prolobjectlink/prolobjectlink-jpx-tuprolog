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
package org.prolobjectlink;

import static org.prolobjectlink.db.XmlParser.XML;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Expression;

import org.junit.After;
import org.junit.Before;
import org.prolobjectlink.db.ContainerFactory;
import org.prolobjectlink.db.DatabaseClass;
import org.prolobjectlink.db.DatabaseUser;
import org.prolobjectlink.db.HierarchicalCache;
import org.prolobjectlink.db.HierarchicalDatabase;
import org.prolobjectlink.db.Protocol;
import org.prolobjectlink.db.RelationalDatabase;
import org.prolobjectlink.db.Schema;
import org.prolobjectlink.db.Storage;
import org.prolobjectlink.db.StorageManager;
import org.prolobjectlink.db.StorageMode;
import org.prolobjectlink.db.StoragePool;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.db.jpa.criteria.JpaObject;
import org.prolobjectlink.db.jpa.spi.JPAPersistenceSchemaVersion;
import org.prolobjectlink.db.jpa.spi.JPAPersistenceVersion;
import org.prolobjectlink.db.prolog.tuprolog.TuPrologContainerFactory;
import org.prolobjectlink.db.savepoint.SavePointManager;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Polygon;
import org.prolobjectlink.domain.geometry.Segment;
import org.prolobjectlink.domain.geometry.Tetragon;
import org.prolobjectlink.domain.geometry.view.SamePoint;
import org.prolobjectlink.domain.model.Address;
import org.prolobjectlink.domain.model.Department;
import org.prolobjectlink.domain.model.Employee;
import org.prolobjectlink.domain.model.Person;
import org.prolobjectlink.domain.model.view.AnEmployeeView;
import org.prolobjectlink.graph.DirectedGraph;
import org.prolobjectlink.prolog.Prolog;
import org.prolobjectlink.prolog.PrologInteger;
import org.prolobjectlink.prolog.PrologProvider;
import org.prolobjectlink.prolog.tuprolog.TuProlog;

/**
 * 
 * @author Jose Zalacain
 * @since 1.0
 */
public abstract class BaseTest {

	protected Settings settings;

	protected Storage storage;
	protected StoragePool storagePool;
	protected HierarchicalCache cache;
	protected StorageManager storageManager;

	protected SavePointManager manager;

	protected DatabaseUser user;

	protected RelationalDatabase rdb;
	protected HierarchicalDatabase hdb;

	protected Schema rschema;
	protected Schema hschema;

	protected EntityManager JPA_EM;
	protected EntityManagerFactory JPA_EMF;

	// file system separator
//	protected final static char SEPARATOR = File.separatorChar;
	protected final static char SEPARATOR = '/';

	protected static final String LOCATION = "data-test";
	protected static final String POOL_ROOT = "pool-test";
	protected static final String POOL_NAME = "pool-name";
	protected static final String ROOT = "data" + SEPARATOR + "test";
	protected static final String BASE_LOCATION = "data" + SEPARATOR + "test" + SEPARATOR + "org" + SEPARATOR
			+ "prolobjectlink" + SEPARATOR + "domain" + SEPARATOR + "geometry";

	// File Backup Names Constants
	protected static final String BACKUP_ZIP_FILE_NAME_1 = "data.zip";
	protected static final String BACKUP_ZIP_FILE_NAME_2 = "data-test.zip";
	protected static final String BACKUP_ZIP_FILE_NAME_3 = "pool-test.zip";
	protected static final String BACKUP_ZIP_FILE_NAME_4 = "hierarchy-test.zip";
	protected static final String BACKUP_ZIP_FILE_NAME_5 = "remote-hierarchical-test.zip";
	protected static final String BACKUP_DIRECTORY = "backup" + SEPARATOR;
	protected static final String BACKUP_ZIP_FILE_PATH_1 = BACKUP_DIRECTORY + BACKUP_ZIP_FILE_NAME_1;
	protected static final String BACKUP_ZIP_FILE_PATH_2 = BACKUP_DIRECTORY + BACKUP_ZIP_FILE_NAME_2;
	protected static final String BACKUP_ZIP_FILE_PATH_3 = BACKUP_DIRECTORY + BACKUP_ZIP_FILE_NAME_3;
	protected static final String BACKUP_ZIP_FILE_PATH_4 = BACKUP_DIRECTORY + BACKUP_ZIP_FILE_NAME_4;
	protected static final String BACKUP_ZIP_FILE_PATH_5 = BACKUP_DIRECTORY + BACKUP_ZIP_FILE_NAME_5;

	protected final Map<String, Object> properties = new HashMap<String, Object>(5);

	protected static final Class<? extends ContainerFactory> driver = TuPrologContainerFactory.class;
	protected static final PrologProvider provider = Prolog.getProvider(TuProlog.class);

	protected static final PrologInteger zero = provider.newInteger(0);
	protected static final PrologInteger one = provider.newInteger(1);
	protected static final PrologInteger two = provider.newInteger(2);
	protected static final PrologInteger three = provider.newInteger(3);
	protected static final PrologInteger four = provider.newInteger(4);
	protected static final PrologInteger five = provider.newInteger(5);
	protected static final PrologInteger six = provider.newInteger(6);
	protected static final PrologInteger seven = provider.newInteger(7);
	protected static final PrologInteger eight = provider.newInteger(8);
	protected static final PrologInteger nine = provider.newInteger(9);
	protected static final PrologInteger ten = provider.newInteger(10);

	protected static final Point a = new Point("a", 3, 14);
	protected static final Point b = new Point("b", 3, 14);
	protected static final Point c = new Point("c", 3, 14);
	protected static final Point d = new Point("d", 3, 14);

	protected static final Segment ab = new Segment("ab", a, b);
	protected static final Segment bc = new Segment("bc", b, c);
	protected static final Segment ca = new Segment("ca", c, a);
	protected static final Segment cd = new Segment("cd", c, d);
	protected static final Segment da = new Segment("da", d, a);

	protected static final Polygon triangle = new Polygon(new String("triangle"), ab, bc, ca);
	protected static final Polygon tetragon = new Tetragon(new String("tetragon"), ab, bc, cd, da);

	protected final DirectedGraph<String, String> g = new DirectedGraph<String, String>();

	protected final GraphVertex<String> v1 = g.addVertex("V1");
	protected final GraphVertex<String> v2 = g.addVertex("V2");
	protected final GraphVertex<String> v3 = g.addVertex("V3");
	protected final GraphVertex<String> v4 = g.addVertex("V4");
	protected final GraphVertex<String> v5 = g.addVertex("V5");

	protected final GraphEdge<String> e1 = g.addEdge(v1, v2, "E1");
	protected final GraphEdge<String> e2 = g.addEdge(v1, v3, "E2");
	protected final GraphEdge<String> e3 = g.addEdge(v1, v5, "E3");
	protected final GraphEdge<String> e4 = g.addEdge(v2, v3, "E4");
	protected final GraphEdge<String> e5 = g.addEdge(v2, v4, "E5");
	protected final GraphEdge<String> e6 = g.addEdge(v2, v5, "E6");

	protected JPAPersistenceSchemaVersion schemaVersion = new JPAPersistenceSchemaVersion("1.0", "UTF-8");
	protected JPAPersistenceVersion persistenceVersion = new JPAPersistenceVersion(

			"2.0",

			"http://java.sun.com/xml/ns/persistence",

			"http://www.w3.org/2001/XMLSchema-instance",

			"http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"

	);

	protected URL memoryURL = null;
	protected URL remoteURL = null;

	protected URL persistenceXml = Thread.currentThread().getContextClassLoader().getResource(XML);

	@Before
	public void setUp() throws Exception {

		System.setProperty("java.protocol.handler.pkgs", Protocol.class.getPackage().getName());

		memoryURL = new URL("mempdb:~/test");
		remoteURL = new URL("rempdb://localhost:5370/test");

		properties.put("javax.persistence.jdbc.driver", TuPrologContainerFactory.class.getName());
		properties.put("javax.persistence.jdbc.url", "jdbc:prolobjectlink:mempdb:~/test");
		properties.put("javax.persistence.jdbc.user", "sa");
		properties.put("javax.persistence.jdbc.password", "");

		JPA_EMF = Persistence.createEntityManagerFactory("test");
		JPA_EM = JPA_EMF.createEntityManager();

//		JDO_PMF = JDOHelper.getPersistenceManagerFactory("test");
//		JDO_PM = JDO_PMF.getPersistenceManager();

		settings = new Settings(driver);
		cache = settings.createHierarchicalCache();
		storage = settings.createStorage(LOCATION);
		storageManager = settings.createStorageManager(ROOT, StorageMode.STORAGE_POOL);
		storagePool = settings.createStoragePool(POOL_ROOT, POOL_NAME);

		manager = new SavePointManager(storageManager);

		user = new DatabaseUser("sa", "");

		rdb = settings.createRelationalDatabase(StorageMode.STORAGE_POOL, "test", user);
		hdb = settings.createHierarchicalDatabase(StorageMode.STORAGE_POOL, "test", user);

		// Relational
		rschema = settings.createRelationalDatabase(StorageMode.STORAGE_POOL, "test", user).getSchema();

		DatabaseClass address = rschema.addClass("Address", "");
		address.addField("street", "", 0, String.class);
		address.addField("city", "", 1, String.class);
		address.addField("state", "", 2, String.class);
		address.addField("zip", "", 3, String.class);
		address.addField("country", "", 4, String.class);
		rschema.addSequence("adddress_sequence", "", Address.class, 1);

		DatabaseClass person = rschema.addClass("Person", "");
		person.addField("id", "", 0, Integer.class, true);
		person.addField("firstName", "", 1, String.class);
		person.addField("middleName", "", 2, String.class);
		person.addField("lastName", "", 3, String.class);
		person.addField("address", "", 4, Address.class);
		person.addField("phones", "", 5, List.class, String.class);
		person.addField("emails", "", 6, Collection.class, String.class);
		person.addField("nickNames", "", 7, Set.class, String.class);
		person.addField("birthDate", "", 8, Date.class);
		person.addField("joinDate", "", 9, Date.class);
		person.addField("lastLoginDate", "", 10, Date.class);
		person.addField("loginCount", "", 11, Integer.class);
		rschema.addSequence("person_sequence", "", Person.class, 1);

		DatabaseClass employee = rschema.addClass("Employee", "", person);
		employee.addField("salary", "", 0, Long.class);
		employee.addField("department", "", 1, Department.class);
		rschema.addSequence("employee_sequence", "", Employee.class, 1);

		DatabaseClass department = rschema.addClass("Department", "");
		department.addField("id", "", 0, Integer.class, true);
		department.addField("name", "", 1, String.class);
		department.addField("employeesByCubicle", "", 2, Map.class, Employee.class);
		rschema.addSequence("department_sequence", "", Department.class, 1);

		rschema.addFunction("fn", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		rschema.addFunction("fni", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		rschema.addFunction("fnj", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		rschema.addFunction("fnk", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");

		rschema.addView(AnEmployeeView.class, "")
				.addInstructions("findall(Id/X/Y,'" + Employee.class.getName() + "'(Id,X,Y),L)");

		// Hierarchical
		hschema = settings.createHierarchicalDatabase(StorageMode.STORAGE_POOL, "test", user).getSchema();

		DatabaseClass point = hschema.addClass("Point", "");
		point.addField("id", "", 0, Integer.class, true);
		point.addField("x", "", 1, String.class);
		point.addField("y", "", 2, String.class);
		hschema.addSequence("point_sequence", "", Point.class, 1);

		DatabaseClass segment = hschema.addClass("Segment", "");
		segment.addField("id", "", 0, Integer.class, true);
		segment.addField("poin0", "", 1, Point.class);
		segment.addField("poin1", "", 2, Point.class);
		hschema.addSequence("segment_sequence", "", Segment.class, 1);

		DatabaseClass polygon = hschema.addClass("Polygon", "");
		polygon.addField("id", "", 0, Integer.class, true);
		polygon.addField("segment0", "", 1, Segment.class);
		polygon.addField("segment1", "", 2, Segment.class);
		polygon.addField("segment2", "", 3, Segment.class);
		hschema.addSequence("polygon_sequence", "", Polygon.class, 1);

		DatabaseClass tetragon = hschema.addClass("Tetragon", "", polygon);
		tetragon.addField("segment3", "", 0, Segment.class);
		hschema.addSequence("tetragon_sequence", "", Tetragon.class, 1);

		hschema.addFunction("fn", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		hschema.addFunction("fni", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		hschema.addFunction("fnj", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");
		hschema.addFunction("fnk", "").addParameter("X").addParameter("Y").addParameter("Z").addParameter("R")
				.addInstructions("R is X*Y*Z");

		hschema.addView(SamePoint.class, "")
				.addInstructions("findall(Id/X/Y,'" + Point.class.getName() + "'(Id,X,Y),L)");

	}

	@After
	public void tearDown() throws Exception {

	}

	protected <S> List<S> createList(List<Object> solutions) {
		List<S> list = new ArrayList<S>();
		for (Object solution : solutions) {
			if (solution instanceof Object[]) {
				Object[] objects = (Object[]) solution;
				if (objects.length > 0) {
					Object object = objects[0];
					S s = (S) object;
					list.add(s);
				}
			}
		}
		return list;
	}

	protected List<Expression<?>> newList(Object... values) {
		ArrayList<Expression<?>> list = new ArrayList<Expression<?>>(values.length);
		for (Object object : values) {
			list.add(new JpaObject<Object>(object, Object.class));
		}
		return list;
	}

	protected List<Expression<?>> newList(Collection<?> values) {
		ArrayList<Expression<?>> list = new ArrayList<Expression<?>>(values.size());
		for (Object object : values) {
			list.add(new JpaObject<Object>(object, Object.class));
		}
		return list;
	}

	protected List<Expression<?>> newList(Expression<?>... expressions) {
		ArrayList<Expression<?>> list = new ArrayList<Expression<?>>(expressions.length);
		for (Expression<?> exp : expressions) {
			list.add(exp);
		}
		return list;
	}

}
