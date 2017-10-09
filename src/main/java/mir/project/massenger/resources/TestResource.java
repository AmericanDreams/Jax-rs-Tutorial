package mir.project.massenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import mir.project.massenger.resources.beans.CustomFilterBean;

@Path("/test")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class TestResource {

	@GET
	@Path("/test1")
	public String test( @MatrixParam("matrix") String matrix ,
						@HeaderParam("customHeader") String header,
						@CookieParam("cookieParam") String cookie) {
		
		return "@MatrixParam : " + matrix + " @HeaderParam : " + header + " @CookieParam : " + cookie ;
	}
	
	@GET
	@Path("/test2")
	public String test2(@BeanParam CustomFilterBean bean) {
		
		return "@MatrixParam : " + bean.getMatrix() + " @HeaderParam : " + bean.getHeader() + " @CookieParam : " + bean.getCookie() ;
	}
	
	@GET
	@Path("/test3")
	public String test2(@Context UriInfo info ,@Context HttpHeaders headers ) {
		
		return "absolute path is " + info.getAbsolutePath() + " header " + headers.getRequestHeader("customHeader"); 
		
	}

}












