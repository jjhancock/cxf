/**
 * 
 */
package cxf.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * @author justin.hancock
 *
 */
@XmlRootElement
@Path("/example")
@Service("exampleRestService")
public class ExampleRestService
{

	/**
	 * 
	 */
	public ExampleRestService()
	{
		super();
	}
	
	@GET
	@Path("/{num}")
	@Produces("application/json")
	public boolean isPrime(@PathParam("num") int num)
	{
		return (num % 2 == 0) == true;
	}
	
	@GET
	@Path("/foo")
	@Produces("application/json")
	public List<Foo> foo()
	{
		List<Foo> myFoo = new ArrayList<Foo>();
		myFoo.add(Foo.newInstance("duder", "el duderino"));
		myFoo.add(Foo.newInstance("yes", "no"));
		return myFoo;
		
	}

}
