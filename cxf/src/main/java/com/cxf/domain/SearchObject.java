/**
 * 
 */
package com.cxf.domain;

import java.util.Date;
import java.util.List;

/**
 * @author justin.hancock
 *
 */
public interface SearchObject
{	
	List<City> getCities();
	void setCities(List<City> theCities);
	
	Date getDatePosted();
	void setDatePosted(Date aDate);
	
	String getPostingBody();
	void setPostingBody(String aPostingBody);
	
	List<ImageLink> getImageLinks();
	void setImageLinks(List<ImageLink> theImages);
	
	String getTitle();
	void setTitle(String aTitle);
}
