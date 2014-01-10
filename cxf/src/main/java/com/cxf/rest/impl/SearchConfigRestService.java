/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.SearchConfig;
import com.cxf.service.SearchConfigService;

/**
 * @author justin.hancock
 *
 */
@Path("/searchConfig")
@Service("searchConfigRestService")
public class SearchConfigRestService
{
	
	@Autowired
	private SearchConfigService scService;
	
	public SearchConfigRestService()
	{
		super();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces("application/json")
	public SearchConfig get(@PathParam("id") Long userId)
	{
		return scService.findByOwningUserId(userId);
	}
	
	@POST
	@Path("/save")
	@Produces("application/json")
	public Boolean saveSearchConfig(@PathParam("searchConfig") SearchConfig sc)
	{		
		SearchConfig savedConfig = scService.saveAndFlush(sc);		
		return (savedConfig == null ? Boolean.FALSE : Boolean.TRUE);
	}

}
