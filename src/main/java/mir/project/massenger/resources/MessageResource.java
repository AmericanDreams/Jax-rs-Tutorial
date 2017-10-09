package mir.project.massenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import mir.project.massenger.exception.DataNotFoundException;
import mir.project.massenger.model.ExceptionResponse;
import mir.project.massenger.model.Link;
import mir.project.massenger.model.Message;
import mir.project.massenger.service.MessageService;
import mir.project.massenger.service.impl.MessageServiceImpl;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageServiceImpl();
	
	
	@Path("/{messageId}/comments")
	public CommentResource forvardMessageResource () {
		return new CommentResource();
	}
	
	@GET
	public List<Message> getAllMessages(@QueryParam("count") long count) {
		if(count > 0) {
			return messageService.getMessagesByCount(count);
		}else {
			return messageService.getAllMessages();
		}
		
	}
	
	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") long id , @Context UriInfo uriInfo) throws DataNotFoundException {
		try {
			Message message =  messageService.getMessage(id);
			return message;
		} catch (DataNotFoundException e) {
			e.setExceptionResponse(new ExceptionResponse(id + " idli Mesaj Yoxdur", 404, "https://www.youtube.com/watch?v=9oeJc_VkZxo&index=27&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn"));
			throw e;
		}
	}

	
	
	
	@POST
	public Response addMessage(Message message , @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.insertMessage(message);;
		return Response.status(Status.CREATED)
				.location(uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build())
				.entity(newMessage)
				.build();			
	}

	
	
	
	@PUT
	@Path("/{id}")
	public Response updateMessage(@PathParam("id") long id ,Message m , @Context UriInfo uriInfo) {
		m.setId(id);
		Message newMessage  = messageService.updateMessage(m);
		if(newMessage == null) {
			ExceptionResponse ex = new ExceptionResponse(id + " idli Message Not found", 404, "https://www.youtube.com/watch?v=Vdk_tUhcJZM&index=28&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn");
			Response res = Response.status(404).entity(ex).build();
			throw new WebApplicationException(res);
		}else {
			return Response.status(Status.OK)
					.location(uriInfo.getAbsolutePath())
					.entity(newMessage)
					.build();
		}
		
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteMessage(@PathParam("id") long id ) throws DataNotFoundException {
		try {
			messageService.removeMessage(id);
		} catch (DataNotFoundException e) {
			e.setExceptionResponse(new ExceptionResponse(id + " id li Mesaj Tapilmadi", 404, "http://localhost:8080/jax.rs.tutorial/"));
			throw e;
		}
	}	
	
	

}
















