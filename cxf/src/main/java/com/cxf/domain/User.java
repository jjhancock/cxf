/**
 * 
 */
package com.cxf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "USER")
public class User extends DomainObject
{
	private SearchConfig searchConfig;
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
