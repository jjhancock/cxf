/**
 * 
 */
package com.cxf.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.domain.CategoryEnum;
import com.cxf.domain.SearchCriteria;
import com.cxf.service.CityService;
import com.cxf.service.SearchCriteriaService;
import com.cxf.service.UserService;

/**
 * @author justin.hancock
 * 
 */
@Controller
public class CriteriaController
{

	private static final Logger LOG = Logger.getLogger(CriteriaController.class
			.getName());

	@Autowired
	private CityService cService;

	@Autowired
	private SearchCriteriaService scService;

	@Autowired
	private UserService uService;

	public CriteriaController()
	{
		super();
	}

	@RequestMapping(value = "/viewSearchCrits.do", method = RequestMethod.GET)
	public ModelAndView viewSearchCrits(Principal user)
	{
		ModelAndView result = new ModelAndView("searchCrits");
		result.getModelMap().put("cities", cService.findAll());
		result.getModelMap().put("cats", CategoryEnum.values());
		
		List<SearchCriteria> myScs = scService.findByOwningUserId(uService.findByUserId(user.getName()).getId());
		
		result.getModelMap().put(
				"searchCrits", myScs
				);
		return result;
	}

}