/*
 * Copyright Telrock Communications Limited 2008 * 
 *
 * $Header:  $
 * $Revision:  $
 * $Date:  $ 
 * 
 */
package com.telrock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Objects;

@Entity
@NamedQuery(name="findDepartmentByNameAndArea", query="SELECT d FROM Department d WHERE d.name = :name AND d.area = :area")
public class Department
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String area;


	public Department() {}

	public Department(String name, String area) {
		this.name = name;
		this.area = area;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("id", id).append("name", name)
				.append("area", area).toString();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Department)) {
			return false;
		}
		Department castOther = (Department) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
