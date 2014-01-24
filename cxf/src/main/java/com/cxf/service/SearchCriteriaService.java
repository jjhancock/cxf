/**
 * 
 */
package com.cxf.service;

import java.util.List;

import com.cxf.domain.SearchCriteria;


/**
 * @author justin.hancock
 *
 */
public interface SearchCriteriaService
{
	SearchCriteria saveAndFlush(SearchCriteria so);
		
	SearchCriteria findById(Long anId);
	
	List<SearchCriteria> findByOwningUserId(Long userId);
}
