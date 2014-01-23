/**
 * 
 */
package com.cxf.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.SearchCriteria;

/**
 * @author justin.hancock
 *
 */
public interface SearchCriteriaRepo extends JpaRepository<SearchCriteria, Long>
{
	SearchCriteria saveAndFlush(SearchCriteria so);
	
	List<SearchCriteria> findByOwningUserId(Long userId);
}
