/**
 * 
 */
package com.cxf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "SEARCH_CRIT")
public class SearchCriteria extends DomainObject
{

	private String category;
	private City city;
	private String keyword;
	private User owningUser;
	
	public SearchCriteria()
	{
		super();
	}
	
	@Column(name = "CATEGORY", nullable = false)
	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = City.class)
	public City getCity()
	{
		return city;
	}
	
	public void setCity(City aCity)
	{
		this.city = aCity;
	}
	
	@Column(name = "KEYWORD", nullable = false)
	public String getKeyword()
	{
		return keyword;
	}
	
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "OWNING_USER_ID", nullable = false)
	public User getOwningUser()
	{
		return owningUser;
	}

	public void setOwningUser(User owningUser)
	{
		this.owningUser = owningUser;
	}

}
