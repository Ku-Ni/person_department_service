/*
 * Copyright Telrock Communications Limited 2008 * 
 *
 * $Header:  $
 * $Revision:  $
 * $Date:  $ 
 * 
 */
package com.telrock;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.telrock.dao.PersonService;
import com.telrock.model.Person;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class PersonServiceTest
{
	@PersistenceContext
	private EntityManager em;

	@Autowired
	PersonService personService;

	@Test
	public void testSave()
	{
		final String name = "the name";

		Person p1 = new Person();
		p1.setName(name);

		Person p2 = personService.save(p1);

		assertNotNull("The returned object can't be null", p2);
		assertNotNull("The id can't be null", p2.getId());
		assertTrue("The id has to be greater than 0", p2.getId() > 0);
		assertEquals(name, p2.getName());
	}

	// --------------------------------------------------------------------------------------------------

	// Implement other tests
	
	@Test
	public final void testGetOrCreateDepartment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetDefaultDepartment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindDepartmentsInArea() {
		fail("Not yet implemented"); // TODO
	}
}
