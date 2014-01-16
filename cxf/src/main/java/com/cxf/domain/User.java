/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Sort;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "USER")
public class User extends DomainObject implements Serializable
{
	private static final long serialVersionUID = -5355316429315818946L;
	
	private String emailAddress;
	private String firstName;
	private String lastName;	
	
	private String userId;
	private String password;
	private String password2;
	private Date lastLogin;
	private Date loginBeforeLast;
	
	@Sort
	public Set<Role> roles;	
	
	private SearchConfig searchConfig;
	private List<SearchObject> searchObjects;
		
	private Boolean isVerified;
	
	public User()
	{
		super();
	}

	@Column(name = "EMAIL_ADDY", nullable = true)
	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false)
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Column(name = "USER_ID", unique = true, nullable = false)
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	@Column(name = "PASSWORD", unique = false, nullable = false)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "PASSWORD2", unique = false, nullable = false)
	public String getPassword2()
	{
		return password2;
	}

	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}

	@Column(name = "LAST_LOGIN", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}
	
	@Column(name = "LOGIN_BEFORE_LAST", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLoginBeforeLast()
	{
		return loginBeforeLast;
	}

	public void setLoginBeforeLast(Date loginBeforeLast)
	{
		this.loginBeforeLast = loginBeforeLast;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Role> getRoles()
	{
		return this.roles;
	}

	public void setRoles(Set<Role> theRoles)
	{
		this.roles = theRoles;
	}

	public void addRole(Role role)
	{
		getRoles().add(role);
	}

	@OneToOne(optional = true)
	@JoinColumn(name = "SEARCH_CONFIG_ID")
	public SearchConfig getSearchConfig()
	{
		return searchConfig;
	}

	public void setSearchConfig(SearchConfig searchConfig)
	{
		this.searchConfig = searchConfig;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = SearchObject.class) 
	@JoinColumn(name = "SEARCH_OBJECT_ID")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	public List<SearchObject> getSearchObjects()
	{
		return searchObjects;
	}

	public void setSearchObjects(List<SearchObject> aSearchObjects)
	{
		this.searchObjects = aSearchObjects;
	}
	
	@Transient
	public void addSearchObject(SearchObject so)
	{
		this.searchObjects.add(so);
	}
	
	@Column(name = "VERIFIED", nullable = false)
	public Boolean isVerified()
	{
		return isVerified;
	}

	public void setVerified(Boolean isVerified)
	{
		this.isVerified = isVerified;
	}


}
