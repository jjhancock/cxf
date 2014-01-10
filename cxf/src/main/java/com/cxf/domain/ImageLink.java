/**
 * 
 */
package com.cxf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author justin.hancock
 *
 */
@Entity
@Table(name = "IMAGE_LINK")
public class ImageLink extends DomainObject implements Serializable
{
	private static final long serialVersionUID = 8225708190410424551L;
	
	private String link;
	private SearchObjectImpl owningSearchObject;

	public ImageLink()
	{
		super();
	}

	@Column(name = "LINK", nullable = false)
	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "OWNING_SEARCH_OBJECT_ID", nullable = false)
	public SearchObjectImpl getOwningSearchObject()
	{
		return this.owningSearchObject;
	}
	
	public void setOwningSearchObject(SearchObjectImpl anOwningSearchObject)
	{
		this.owningSearchObject = anOwningSearchObject;
	}
	
	
	

}
