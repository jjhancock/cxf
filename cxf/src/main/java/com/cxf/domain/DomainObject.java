/**
 * 
 */
package com.cxf.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author justin.hancock
 *
 */
@MappedSuperclass
public class DomainObject
{
	private Long id;

	/**
	 * 
	 */
	public DomainObject()
	{
		super();
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return this.id;		
	}
	
	public void setId(Long anId)
	{
		this.id = anId;
	}

}
