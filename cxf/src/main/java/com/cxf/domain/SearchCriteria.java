/**
 * 
 */
package com.cxf.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "SEARCH_CRIT")
public class SearchCriteria extends DomainObject
{

	private List<City> cities;
	private String keyword;
	
	public SearchCriteria()
	{
		super();
	}
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = City.class)
	public List<City> getCities()
	{
		return cities;
	}
	
	public void setCities(List<City> cities)
	{
		this.cities = cities;
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

}