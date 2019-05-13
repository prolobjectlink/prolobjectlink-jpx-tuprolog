package org.prolobjectlink.db.modelgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.prolobjectlink.BaseTest;

public class ModelGeneratorTest extends BaseTest {

	@Test
	@Ignore
	public void testCreateSchema() {
		ModelGenerator rg = new ModelGenerator(rdb);
		assertEquals(4, rg.createSchema().countClasses());
		assertEquals(rschema, rg.createSchema());
	}

	@Test
	@Ignore
	public void testGenerateSchema() {
		fail("Not Implemented yet"); // TODO
	}

	@Test
	@Ignore
	public void testCompileSchema() {
		fail("Not Implemented yet"); // TODO
	}

	@Test
	@Ignore
	public void testWritePersistence() {
		fail("Not Implemented yet"); // TODO
	}

}
