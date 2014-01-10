/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.User;
import com.cxf.service.UserService;

/**
 * @author justin.hancock
 *
 */
@Path("/user")
@Service("userRestService")
public class UserRestService
{
	@Autowired
	private UserService uService;
	
	public UserRestService()
	{
		super();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") Long id)
	{
		return uService.findById(id);
	}

}
