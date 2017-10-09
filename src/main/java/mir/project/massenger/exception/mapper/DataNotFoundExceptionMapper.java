package mir.project.massenger.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import mir.project.massenger.exception.DataNotFoundException;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		
		return Response.status(Status.NOT_FOUND).entity(ex.getExceptionResponse()).build();
	}

}
