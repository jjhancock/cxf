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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	private City city;
	private Date datePosted;
	private SearchCriteria owningSearchCriteria;
	private String postingBody;
	private List<ImageLink> imageLinks;
	private String title;
	private String link;

	public SearchObject()
	{
		super();
	}
	
	@Transient
	public static SearchObject newInstance(String link, SearchCriteria osc)
	{
		SearchObject result = new SearchObject();
		result.setLink(link);
		result.setOwningSearchCriteria(osc);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#getCities()
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
	@JoinColumn(name = "CITY_ID")
	public City getCity()
	{
		return city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.SearchObject#setCities(java.util.List)
	 */
	public void setCity(City theCity)
	{
		this.city = theCity;
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
	@JoinColumn(name = "OWNING_SEARCH_CRIT_ID")
	public SearchCriteria getOwningSearchCriteria()
	{
		return owningSearchCriteria;
	}

	public void setOwningSearchCriteria(SearchCriteria anOwningSearchCriteria)
	{
		this.owningSearchCriteria = anOwningSearchCriteria;
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

	@Column(name = "LINK", nullable = false, unique = true)
	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

}
