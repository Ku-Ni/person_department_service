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

import com.telrock.model.Department;

public class DepartmentServiceImpl implements DepartmentService
{
	@PersistenceContext
	private EntityManager em;

	public Department getOrCreateDepartment(String departmentName, String area)
	{
		return null;
	}

	public Department getDefaultDepartment()
	{
		return null;
	}

	public List<Department> findDepartmentsInArea(String area)
	{
		return null;
	}
}
