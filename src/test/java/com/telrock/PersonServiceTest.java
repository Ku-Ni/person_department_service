/*
 * Copyright Telrock Communications Limited 2008 * 
 *
 * $Header:  $
 * $Revision:  $
 * $Date:  $ 
 * 
 */
package com.telrock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
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

		Assert.assertNotNull("The returned object can't be null", p2);
		Assert.assertNotNull("The id can't be null", p2.getId());
		Assert.assertTrue("The id has to be greater than 0", p2.getId() > 0);
		Assert.assertEquals(name, p2.getName());
	}

	// --------------------------------------------------------------------------------------------------

	// Implement other tests
}
