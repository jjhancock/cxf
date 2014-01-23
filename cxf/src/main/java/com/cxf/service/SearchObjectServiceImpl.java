/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public SearchObject saveAndFlush(SearchObject so)
	{
		return soRepo.saveAndFlush(so);
	}

	@Override
	public List<SearchObject> findByOwningSearchCriteria(Long owningSearchCriteriaId)
	{
		return soRepo.findByOwningSearchCriteria(owningSearchCriteriaId);
	}

}
