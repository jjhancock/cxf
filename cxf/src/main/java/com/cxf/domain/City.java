/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;

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
@Table(name = "CITY")
public class City extends DomainObject implements Serializable
{	
	private static final long serialVersionUID = 9132029158313482885L;
	private String cityCode;
	private String cityName;
	private SearchObject owningSearchObject;
	
	/**
	 * 
	 */
	public City()
	{
		super();
	}

	@Column(name = "CITY_CODE", nullable = false)
	public String getCityCode()
	{
		return cityCode;
	}

	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	@Column(name = "CITY_NAME", nullable = false)
	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SearchObject.class)
	@JoinColumn(name = "OWNING_SEARCH_OBJ_ID")
	public SearchObject getOwningSearchObject()
	{
		return this.owningSearchObject;
	}
	
	public void setOwningSearchObject(SearchObject aSearchObject)
	{
		this.owningSearchObject = aSearchObject;		
	}

}
