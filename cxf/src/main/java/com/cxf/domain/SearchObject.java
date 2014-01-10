/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

/**
 * @author justin.hancock
 * 
 */
@Entity
@Table(name="SEARCH_OBJECT")
public class SearchObject extends DomainObject implements Serializable
{	
	private static final long serialVersionUID = 7870640217944440758L;
	private List<City> cities;
	private Date datePosted;
	private SearchConfig owningSearchConfig;
	private String postingBody;
	private List<ImageLink> imageLinks;
	private String title;
	

	public SearchObject()
	{
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getCities()
	 *
	 */
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = City.class)
	public List<City> getCities()
	{
		return cities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#setCities(java.util.List)
	 */
	public void setCities(List<City> theCities)
	{
		this.cities = theCities;
	}

	@Column(name = "DATE_POSTED", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatePosted()
	{
		return this.datePosted;
	}
	
	public void setDatePosted(Date aDate)
	{
		this.datePosted = aDate;
	}
	
	@OneToOne
	public SearchConfig getOwningSearchConfig()
	{
		return owningSearchConfig;
	}

	public void setOwningSearchConfig(SearchConfig owningSearchConfig)
	{
		this.owningSearchConfig = owningSearchConfig;
	}

	@Column(name = "POSTING_BODY")
	public String getPostingBody()
	{
		return this.postingBody;
	}

	
	public void setPostingBody(String aPostingBody)
	{
		this.postingBody = aPostingBody;
	}

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owningSearchObject", targetEntity = ImageLink.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	public List<ImageLink> getImageLinks()
	{
		return this.imageLinks;
	}

	
	public void setImageLinks(List<ImageLink> theImages)
	{
		this.imageLinks = theImages;
	}
	
	@Column(name = "TITLE")
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String aTitle)
	{
		this.title = aTitle;
	}

	

}
