/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.domain.SearchObject;
import com.cxf.repo.SearchObjectRepo;

/**
 * @author justin.hancock
 *
 */
@Service("searchObjectService")
public class SearchObjectServiceImpl implements SearchObjectService
{
	@Autowired
	private SearchObjectRepo soRepo;

	/**
	 * 
	 */
	public SearchObjectServiceImpl()
	{
		super();
	}

	@Override
	@Transactional
	public SearchObject saveAndFlush(SearchObject so)
	{
		return soRepo.saveAndFlush(so);
	}

	@Override
	public List<SearchObject> findByOwningSearchCriteriaId(Long owningSearchCriteriaId)
	{
		return soRepo.findByOwningSearchCriteriaId(owningSearchCriteriaId);
	}

}
