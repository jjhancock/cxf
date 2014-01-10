/**
 * 
 */
package com.cxf.service;

import java.util.List;

import com.cxf.domain.SearchObject;

/**
 * @author justin.hancock
 *
 */
public interface SearchObjectService
{
	SearchObject saveAndFlush(SearchObject so);
	
	List<SearchObject> findByOwningSearchConfig(Long owningSearchConfigId);
}
