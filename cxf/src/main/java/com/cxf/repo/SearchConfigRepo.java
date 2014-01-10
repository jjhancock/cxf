/**
 * 
 */
package com.cxf.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.SearchConfig;

/**
 * @author justin.hancock
 *
 */
public interface SearchConfigRepo extends JpaRepository<SearchConfig, Long>
{
	SearchConfig saveAndFlush(SearchConfig so);
	
	SearchConfig findByOwningUserId(Long userId);
}
