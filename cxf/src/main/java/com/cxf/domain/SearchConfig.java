/**
 * 
 */
package com.cxf.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "SEARCH_CONFIG")
public class SearchConfig extends DomainObject
{
	private List<SearchObject> searchObjects;
	private User owningUser;

	public SearchConfig()
	{
		super();
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SearchObject.class) 
	@JoinColumn(name = "SEARCH_CONFIG_ID")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	public List<SearchObject> getSearchObjects()
	{
		return searchObjects;
	}

	public void setSearchObjects(List<SearchObject> searchObjects)
	{
		this.searchObjects = searchObjects;
	}

	@OneToOne
	@JoinColumn(name = "OWNING_USER_ID", nullable = false)
	public User getOwningUser()
	{
		return this.owningUser;
	}
	
	public void setOwningUser(User anOwner)
	{
		this.owningUser = anOwner;
	}
	
}
