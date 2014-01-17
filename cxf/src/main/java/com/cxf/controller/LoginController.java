/**
 * 
 */
package com.cxf.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author justin.hancock
 *
 */
@Controller
public class LoginController
{
	private static final Logger LOG = Logger.getLogger(LoginController.class);
	/**
	 * 
	 */
	public LoginController()
	{
		super();
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(Principal user)
	{
		return new ModelAndView("login");
	}

}
