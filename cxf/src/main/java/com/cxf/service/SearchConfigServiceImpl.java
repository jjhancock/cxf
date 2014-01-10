/**
 * 
 */
package com.cxf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.SearchConfig;
import com.cxf.repo.SearchConfigRepo;

/**
 * @author justin.hancock
 *
 */
@Service("searchConfigService")
public class SearchConfigServiceImpl implements SearchConfigService
{
	@Autowired
	private SearchConfigRepo scRepo;
	
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
		return scRepo.saveAndFlush(so);
	}

	@Override
	public SearchConfig findByOwningUserId(Long userId)
	{
		return scRepo.findByOwningUserId(userId);
	}

}
