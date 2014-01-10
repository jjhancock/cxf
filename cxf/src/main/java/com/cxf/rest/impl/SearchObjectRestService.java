package com.cxf.rest.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.SearchObject;
import com.cxf.service.SearchObjectService;

@Path("/searchObject")
@Service("searchObjectRestService")
public class SearchObjectRestService
{
	
	//@Autowired
	//private SearchObjectService soService;

	public SearchObjectRestService()
	{
		super();
	}
	
//	@GET
//	@Path("/get/all/{id}")
//	@Produces("application/json")
//	public List<SearchObject> getAll(@PathParam("id") Long owningSearchConfigId)
//	{
//		return soService.findByOwningSearchConfig(owningSearchConfigId);
//	}

}
