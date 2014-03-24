/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Sort;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "USER")
@XmlRootElement
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
	
	private List<SearchCriteria> searchCriteria;
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
	
	@OneToMany(fetch = FetchType.EAGER)
	public Set<Role> getRoles()
	{
		return (this.roles == null ? new HashSet<Role>() : this.roles);
	}

	public void setRoles(Set<Role> theRoles)
	{
		this.roles = theRoles;
	}

	public void addRole(Role role)
	{
		getRoles().add(role);
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEARCH_CRIT_ID")
	public List<SearchCriteria> getSearchCriteria()
	{
		return this.searchCriteria;
	}

	public void setSearchCriteria(List<SearchCriteria> aSearchCriteria)
	{
		this.searchCriteria = aSearchCriteria;
	}
	
	@JsonIgnore
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
