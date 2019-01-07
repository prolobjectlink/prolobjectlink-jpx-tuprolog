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

import static org.logicware.db.XmlParser.XML;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import org.logicware.db.DatabaseEngine;
import org.logicware.db.DatabaseSchema;
import org.logicware.db.DatabaseUser;
import org.logicware.db.HierarchicalCache;
import org.logicware.db.Protocol;
import org.logicware.db.Schema;
import org.logicware.db.etc.Settings;
import org.logicware.db.jpa.JpaAbstractProvider;
import org.logicware.db.jpa.JpaEntityManagerFactory;
import org.logicware.db.jpa.JpaProperties;
import org.logicware.db.jpa.spi.JPAPersistenceXmlParser;
import org.logicware.db.memory.MemoryHierarchical;
import org.logicware.db.util.JavaReflect;
import org.logicware.logging.LoggerConstants;
import org.logicware.logging.LoggerUtils;

public class TuPrologPersistenceProvider extends JpaAbstractProvider implements PersistenceProvider {

	public TuPrologPersistenceProvider() {
//		JPAPersistenceXmlParser p = new JPAPersistenceXmlParser();
//		URL persistenceXml = Thread.currentThread().getContextClassLoader().getResource(XML);
//		Map<String, PersistenceUnitInfo> m = p.parsePersistenceXml(persistenceXml);
//		// TODO factory by create database by protocol
//		DatabaseEngine database = MemoryHierarchical.newInstance(m);
//		entityManagerFactory = new JpaEntityManagerFactory(database);
	}
}
