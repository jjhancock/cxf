/**
 * 
 */
package com.cxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.service.CityService;

/**
 * @author justin.hancock
 *
 */
@Controller
public class IndexController
{
	@Autowired
	private CityService cService;
	
	/**
	 * 
	 */
	public IndexController()
	{
		super();
	}
	
	@RequestMapping(value="index.do", method = RequestMethod.GET)
	public ModelAndView goHome()
	{
		return new ModelAndView("index");
	}

}
