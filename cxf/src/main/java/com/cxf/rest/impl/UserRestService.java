/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cxf.domain.User;
import com.cxf.service.UserService;
import com.cxf.web.StatusResponse;

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
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces("application/json")
	public StatusResponse saveUser(User user)
	{
		Boolean result = false;
		if (uService.findByUserId(user.getUserId()) == null)
		{				
			user.setVerified(Boolean.TRUE);
			uService.saveAndFlush(user);
			result = true;
		}		
		return new StatusResponse(result);
	}

}
