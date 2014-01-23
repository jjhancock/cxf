/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.SearchCriteria;
import com.cxf.service.CityService;
import com.cxf.service.SearchCriteriaService;
import com.cxf.service.UserService;
import com.cxf.web.StatusResponse;
import com.cxf.web.presentation.SearchCriteriaPresentationModel;

/**
 * @author justin.hancock
 *
 */
@Path("/searchCrit")
@Service("searchCritRestService")
public class SearchCriteriaRestService
{
	@Autowired
	private CityService cService;
	
	@Autowired
	private SearchCriteriaService scService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 */
	public SearchCriteriaRestService()
	{
		super();
	}
		
	@POST
	@Path("/new")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse saveNew(SearchCriteriaPresentationModel scpm)
	{
		SearchCriteria sc = scpm.getSc();
		sc.setOwningUser(userService.findByUserId("justin.hancock"));
		sc.setCity(cService.findById(scpm.getCityId()));
		sc = scService.saveAndFlush(sc);		
		return new StatusResponse(Boolean.TRUE);		
	}
	

}
