/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cxf.domain.User;
import com.cxf.security.TokenUtils;
import com.cxf.service.PasswordService;
import com.cxf.web.StatusResponse;

/**
 * @author justin.hancock
 *
 */
@Service("authenticationRestService")
@Path("/authenticate")
public class AuthenticationRestService
{
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 
	 */
	public AuthenticationRestService()
	{
		super();
	}
	
	
	// this needs to return success and a token, otherwise failure with no token
	@POST
	@Path("/me")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces("application/json")
	public StatusResponse login(User user)
	{
		Boolean result = false;
		String token = null;
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserId());
		if (userDetails.getPassword().equalsIgnoreCase(passwordService.encryptMd5(user.getPassword())))
		{
			// we've got a successful login.  Proceed to build the token and send it back
			token = TokenUtils.createToken(userDetails);
			result = true;
		}
		
		return new StatusResponse(result, token == null ? "" : token);
	}

}
