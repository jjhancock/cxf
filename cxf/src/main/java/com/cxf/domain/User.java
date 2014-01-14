/**
 * 
 */
package com.cxf.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "USER")
public class User extends DomainObject
{
	private SearchConfig searchConfig;
	private List<SearchObject> searchObjects;
	private String userName;
	
	public User()
	{
		super();
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
	
	@Column(name = "USERNAME")
	public String getUsername()
	{
		return this.userName;
	}
	
	public void setUsername(String aUserName)
	{
		this.userName = aUserName;
	}

}
