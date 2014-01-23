/**
 * 
 */
package com.cxf.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.SearchObject;

/**
 * @author justin.hancock
 *
 */
public interface SearchObjectRepo extends JpaRepository<SearchObject, Long>
{
	SearchObject saveAndFlush(SearchObject so);
	
	List<SearchObject> findByOwningSearchCriteria(Long owningSearchCriteriaId);
}
