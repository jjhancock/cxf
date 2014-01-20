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
public class DashboardController
{

	private static final Logger LOG = Logger.getLogger(DashboardController.class);
	/**
	 * 
	 */
	public DashboardController()
	{
		super();
	}
	
	@RequestMapping(value = "/dashboard.do", method = RequestMethod.GET)
	public ModelAndView goHome(Principal user)
	{
		return new ModelAndView("dashboard");
	}

}
