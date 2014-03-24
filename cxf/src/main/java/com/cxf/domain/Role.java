/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jjhancock
 * 
 */
@Entity
@XmlRootElement
@Table(name = "ROLE", uniqueConstraints =
{ @UniqueConstraint(columnNames =
{ "ROLE_NAME" }) })
public class Role extends DomainObject implements Serializable,
		Comparable<Role>
{
	private static final long serialVersionUID = -2154659537673765358L;
	private String roleDescription;
	private String roleName;

	@Override
	public int compareTo(Role compareRole)
	{
		return this.getRoleName().compareTo(compareRole.getRoleName());
	}

	@Column(name = "ROLE_DESC", unique = false, nullable = false)
	public String getRoleDescription()
	{
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription)
	{
		this.roleDescription = roleDescription;
	}

	@Column(name = "ROLE_NAME", unique = true, nullable = false)
	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

}