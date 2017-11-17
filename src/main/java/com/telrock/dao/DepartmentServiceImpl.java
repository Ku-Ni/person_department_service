/*
 * Copyright Telrock Communications Limited 2008 * 
 *
 * $Header:  $
 * $Revision:  $
 * $Date:  $ 
 * 
 */
package com.telrock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.telrock.model.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	Logger log = LogManager.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager em;

	public Department getOrCreateDepartment(String departmentName, String area) {
		log.info("Retrieving department {} in area {}",departmentName, area);

		if (!StringUtils.hasText(departmentName) || !StringUtils.hasText(area)) {
			String errorMessage = "Both supplied department name ["+departmentName+"] and area ["+area+"] must be populated";
			log.error(errorMessage);
			throw new IllegalArgumentException("errorMessage");
		}

		List<Department> result = em.createNamedQuery("findDepartmentByNameAndArea", Department.class)
				.setParameter("name", departmentName)
				.setParameter("area", area)
				.getResultList();
		
		if (result.size() > 1) {
			String errorMessage = "Supplied values for department name ["+departmentName+"] and area ["+area+"] returned "+result.size()+" results";
			log.error(errorMessage);
			throw new IllegalArgumentException("errorMessage");
		}
		
		if (result.size() == 1) {
			log.debug("Found department [name={},area={}]", departmentName, area);
			return result.get(0);
		} 
		
		log.debug("Creating new department [name={},area={}]", departmentName, area);
		Department department = new Department(departmentName, area);
		em.persist(department);
		em.flush();
		
		return department;
	}

	public Department getDefaultDepartment() {
		log.info("Retrieving default department");

		return null;
	}

	public List<Department> findDepartmentsInArea(String area) {
		log.info("Retrieving all departments in area {}", area);

		return null;
	}
}
