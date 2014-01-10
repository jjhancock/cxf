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
public class SearchObjectImpl extends DomainObject implements SearchObject, Serializable
{	
	private static final long serialVersionUID = 7870640217944440758L;
	private List<City> cities;
	private Date datePosted;
	private String postingBody;
	private List<ImageLink> imageLinks;
	private String title;

	public SearchObjectImpl()
	{
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getCities()
	 */
	@Override
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

	@Override
	@Column(name = "DATE_POSTED", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatePosted()
	{
		return this.datePosted;
	}

	@Override
	public void setDatePosted(Date aDate)
	{
		this.datePosted = aDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getPostingBody()
	 */
	@Override
	@Column(name = "POSTING_BODY")
	public String getPostingBody()
	{
		return this.postingBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#setPostingBody()
	 */
	@Override
	public void setPostingBody(String aPostingBody)
	{
		this.postingBody = aPostingBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getImageLinks()
	 */
	@Override
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owningSearchObject", targetEntity = ImageLink.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	public List<ImageLink> getImageLinks()
	{
		return this.imageLinks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#setImageLinks(java.util.List)
	 */
	@Override
	public void setImageLinks(List<ImageLink> theImages)
	{
		this.imageLinks = theImages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getTitle()
	 */
	@Override
	@Column(name = "TITLE")
	public String getTitle()
	{
		return this.title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String aTitle)
	{
		this.title = aTitle;
	}

	

}
