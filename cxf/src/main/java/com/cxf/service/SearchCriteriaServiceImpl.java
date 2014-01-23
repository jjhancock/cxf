/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.domain.SearchCriteria;
import com.cxf.repo.SearchCriteriaRepo;

/**
 * @author justin.hancock
 *
 */
@Service("searchCriteriaService")
public class SearchCriteriaServiceImpl implements SearchCriteriaService
{
	@Autowired
	private SearchCriteriaRepo scRepo;
	
	/**
	 * 
	 */
	public SearchCriteriaServiceImpl()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.cxf.service.SearchConfigService#saveAndFlush(com.cxf.domain.SearchConfig)
	 */
	@Override
	@Transactional
	public SearchCriteria saveAndFlush(SearchCriteria aSearchCriteria)
	{
		return scRepo.saveAndFlush(aSearchCriteria);
	}

	@Override
	public List<SearchCriteria> findByOwningUserId(Long userId)
	{
		return scRepo.findByOwningUserId(userId);
	}

}
