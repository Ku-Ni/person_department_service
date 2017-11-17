package com.telrock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.telrock.model.Person;

/**
 * DAO implementation for Person entity
 * 
 * @author telrock.com
 */
public class PersonServiceImpl implements PersonService
{
	@PersistenceContext
	private EntityManager em;

	public Person save(Person person)
	{
		return null;
	}

	public void setDefaultDepartment(Person person)
	{
	}
}
