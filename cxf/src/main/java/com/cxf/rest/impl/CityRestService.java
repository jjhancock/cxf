/**
 * 
 */
package com.cxf.rest.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cxf.domain.City;
import com.cxf.service.CityService;

/**
 * @author justin.hancock
 *
 */
@Path("/secure/city")
@Service("cityRestService")
public class CityRestService extends RestServiceImpl
{
	
	@Autowired
	private CityService cService;

	/**
	 * 
	 */
	public CityRestService()
	{
		super();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCities(@Context SecurityContext sc)
	{
//		Principal p = sc.getUserPrincipal();		
//		Long id = getUserId(sc);
		
		return cService.findAll();		
	}


}
