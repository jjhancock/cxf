/**
 * 
 */
package com.cxf.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxf.domain.SearchCriteria;
import com.cxf.domain.SearchObject;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author justin.hancock
 *
 */
@Component
public class Scraper implements Runnable
{	
	private SearchCriteria searchCrit;
	
	@Autowired
	private SearchObjectService soService;

	/**
	 * 
	 */
	private Scraper()
	{
		super();
	}
	
//	public static Scraper newInstance(SearchCriteria sc)
//	{
//		Scraper scraper = new Scraper();
//		scraper.setSearchCrit(sc);		
//		return scraper;
//	}

	public SearchCriteria getSearchCrit()
	{
		return searchCrit;
	}

	public void setSearchCrit(SearchCriteria aSearchCrit)
	{
		this.searchCrit = aSearchCrit;
	}

	@Override
	public void run()
	{
		final WebClient webClient = new WebClient();
		webClient.setJavaScriptEnabled(false);
		try
		{			
			/*
			 * http://denver.craigslist.org/search/?query=fatboy&catAbb=sss
			 */
			
			final HtmlPage startPage = 
					webClient.getPage("http://" + getSearchCrit().getCity().getCityName() 
							+ ".craigslist.org/search/?query=" 
							+ getSearchCrit().getKeyword() + "&catAbb=" 
							+ getSearchCrit().getCategory());
						
			List<HtmlElement> elements = (List<HtmlElement>)startPage.getByXPath("//p[@class='row']/a[@class='i']");
						
			for (HtmlElement elem : elements)
			{
				HtmlAnchor anchor = (HtmlAnchor) elem;
				soService.saveAndFlush(SearchObject.newInstance("http://" + getSearchCrit().getCity().getCityName() 
						+ ".craigslist.org" + anchor.getHrefAttribute(), this.getSearchCrit()));
			}
		} 
		catch (FailingHttpStatusCodeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
