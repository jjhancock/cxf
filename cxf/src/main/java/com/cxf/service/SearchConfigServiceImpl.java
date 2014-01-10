/**
 * 
 */
package com.cxf.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.domain.SearchConfig;

/**
 * @author justin.hancock
 *
 */
public class SearchConfigServiceImpl implements SearchConfigService
{
	@Autowired
	private SearchConfigService scService;
	
	/**
	 * 
	 */
	public SearchConfigServiceImpl()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.cxf.service.SearchConfigService#saveAndFlush(com.cxf.domain.SearchConfig)
	 */
	@Override
	public SearchConfig saveAndFlush(SearchConfig so)
	{
		return scService.saveAndFlush(so);
	}

	@Override
	public SearchConfig findByOwningUserId(Long userId)
	{
		return scService.findByOwningUserId(userId);
	}

}
