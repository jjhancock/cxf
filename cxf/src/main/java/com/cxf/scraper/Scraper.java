/**
 * 
 */
package com.cxf.scraper;

/**
 * @author justin.hancock
 *
 */
public class Scraper
{
	private Enum<?> category;
	private String searchCrit;

	/**
	 * 
	 */
	public Scraper()
	{
		super();
	}

	public Enum<?> getCategory()
	{
		return category;
	}

	public void setCategory(Enum<?> category)
	{
		this.category = category;
	}

	public String getSearchCrit()
	{
		return searchCrit;
	}

	public void setSearchCrit(String searchCrit)
	{
		this.searchCrit = searchCrit;
	}

}
