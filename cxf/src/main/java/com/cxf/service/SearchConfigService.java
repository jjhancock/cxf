/**
 * 
 */
package com.cxf.service;

import com.cxf.domain.SearchConfig;

/**
 * @author justin.hancock
 *
 */
public interface SearchConfigService
{
	SearchConfig saveAndFlush(SearchConfig so);
		
	SearchConfig findByOwningUserId(Long userId);
}
