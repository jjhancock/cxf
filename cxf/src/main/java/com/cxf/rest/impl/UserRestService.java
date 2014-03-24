/**
 * 
 */
package com.cxf.rest.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.domain.Role;
import com.cxf.domain.User;
import com.cxf.service.PasswordService;
import com.cxf.service.RoleService;
import com.cxf.service.SearchCriteriaService;
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
	private PasswordService passwordService;
	
	@Autowired
	private RoleService rService;
	
	@Autowired
	private SearchCriteriaService scService;
	
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
			Set<Role> roles = new HashSet<Role>();
			roles.add(rService.findByRoleName("ROLE_USER"));
			user.setRoles(roles);
			user.setPassword(passwordService.encryptMd5(user.getPassword()));
			user.setPassword2(passwordService.encryptMd5(user.getPassword()));
			uService.saveAndFlush(user);
			result = true;
		}		
		return new StatusResponse(result);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces("application/json")
	public StatusResponse updateUser(User user)
	{
		Boolean result = false;
		
		user = uService.saveAndFlush(user);
		
		return new StatusResponse(result);
	}

}
