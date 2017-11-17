package com.telrock.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telrock.model.Person;

/**
 * DAO implementation for Person entity
 * 
 * @author telrock.com
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService
{
	Logger log = LogManager.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;

	public Person save(Person person)
	{
		log.info("Persisting person: {}", person);
		em.persist(person);
		em.flush();
		return person;
	}

	public void setDefaultDepartment(Person person)
	{
	}
}
