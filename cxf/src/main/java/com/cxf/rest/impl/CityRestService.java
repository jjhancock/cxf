/**
 * 
 */
package com.cxf.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cxf.domain.City;
import com.cxf.service.CityService;

/**
 * @author justin.hancock
 *
 */
@Path("/city")
@Service("cityRestService")
public class CityRestService
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
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCities()
	{
		return cService.findAll();		
	}


}
