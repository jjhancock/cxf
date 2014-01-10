/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.domain.SearchObject;

/**
 * @author justin.hancock
 *
 */
public class SearchObjectServiceImpl implements SearchObjectService
{
	@Autowired
	private SearchObjectService soService;

	/**
	 * 
	 */
	public SearchObjectServiceImpl()
	{
		super();
	}

	@Override
	public SearchObject saveAndFlush(SearchObject so)
	{
		return soService.saveAndFlush(so);
	}

	@Override
	public List<SearchObject> findByOwningSearchConfig(Long owningSearchConfigId)
	{
		return soService.findByOwningSearchConfig(owningSearchConfigId);
	}

}
