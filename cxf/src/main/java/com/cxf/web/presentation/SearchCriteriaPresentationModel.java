/**
 * 
 */
package com.cxf.web.presentation;

import com.cxf.domain.SearchCriteria;

/**
 * @author justin.hancock
 *
 */
public class SearchCriteriaPresentationModel
{
	private String category;
	private Long cityId;
	private String keyword;
	private SearchCriteria sc;	
	private Long userId;
	
	/**
	 * 
	 */
	public SearchCriteriaPresentationModel()
	{
		super();
		this.sc = new SearchCriteria();
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
		getSc().setCategory(category);
	}

	public Long getCityId()
	{
		return cityId;
	}

	public void setCityId(Long cityId)
	{
		this.cityId = cityId;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
		getSc().setKeyword(keyword);
	}

	public SearchCriteria getSc()
	{
		return sc;
	}

	public void setSc(SearchCriteria sc)
	{
		this.sc = sc;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

}
