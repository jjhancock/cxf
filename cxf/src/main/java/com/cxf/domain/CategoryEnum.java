/**
 * 
 */
package com.cxf.domain;

/**
 * @author justin.hancock
 * 
 */
public enum CategoryEnum
{
	JOBS("jjj"),
	FOR_SALE("sss");	
	
	private String categoryName;

	private CategoryEnum(String aCategoryName)
	{
		this.categoryName = aCategoryName;
	}

	public String getCategoryName()
	{
		return this.categoryName;
	}
	
}
