package mir.project.massenger.service;

import java.util.List;

import mir.project.massenger.exception.DataNotFoundException;
import mir.project.massenger.model.Message;

public interface MessageService {
	
	List<Message> getAllMessages();
	
	Message getMessage(long id) throws DataNotFoundException;
	
	Message insertMessage(Message m);
	
	Message updateMessage(Message m);
	
	void removeMessage(long m) throws DataNotFoundException;

	List<Message> getMessagesByCount(long count);
}
