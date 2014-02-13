/**
 * 
 */
package com.cxf.rest.impl;

import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.rest.RestService;
import com.cxf.service.UserService;

/**
 * @author justin.hancock
 *
 */
public class RestServiceImpl implements RestService
{
	@Autowired
	private UserService uService;
	
	/**
	 * 
	 */
	public RestServiceImpl()
	{
		super();
	}
	
	protected Long getUserId(SecurityContext sc)
	{
		return uService.findByUserIdAndVerified(sc.getUserPrincipal().getName(), Boolean.TRUE).getId();
	}

}
