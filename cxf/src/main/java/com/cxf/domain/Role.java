/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author jjhancock
 * 
 */
@Entity
@Table(name = "ROLE", uniqueConstraints =
{ @UniqueConstraint(columnNames =
{ "ROLE_NAME" }) })
public class Role extends DomainObject implements Serializable,
		Comparable<Role>
{
	private static final long serialVersionUID = -2154659537673765358L;
	private String roleDescription;
	private String roleName;
	private Set<User> users;

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

	@ManyToMany(mappedBy = "roles")
	public Set<User> getUsers()
	{
		return users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
}