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
import com.cxf.domain.User;
import com.cxf.scraper.Scraper;
import com.cxf.service.CityService;
import com.cxf.service.SearchCriteriaService;
import com.cxf.service.SearchObjectService;
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
	private SearchObjectService soService;
	
	@Autowired
	private Scraper scraper;

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
	
	@RequestMapping(value = "/viewCriteriaResults.do", method = RequestMethod.GET)
	public ModelAndView viewCriteriaResults(Principal p, Long critId)
	{
		ModelAndView mav = new ModelAndView("viewSearchResults");		
		SearchCriteria sc = scService.findById(critId);
		scraper.setSearchCrit(sc);
		scraper.run();				
		
		mav.getModelMap().put("searchResults", soService.findByOwningSearchCriteriaId(sc.getId()));		
		return mav;
	}

}
