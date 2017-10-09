package mir.project.massenger.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mir.project.massenger.database.Database;
import mir.project.massenger.exception.DataNotFoundException;
import mir.project.massenger.model.Message;
import mir.project.massenger.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Override
	public List<Message> getAllMessages() {
		return new ArrayList<>(Database.messages.values());
	}

	@Override
	public Message getMessage(long id) throws DataNotFoundException {
		Message mes =  Database.messages.get(new Long(id));
		if(mes == null) {
			throw new DataNotFoundException();
		}
		return mes;
	}

	@Override
	public Message insertMessage(Message m) {
		long id = Database.messageId();
		m.setId(id);
		Database.messages.put(id, m);
		m.setId(id);
		return m;
	}

	@Override
	public Message updateMessage(Message m) {

		Message mes = Database.messages.get(m.getId());

		if (mes == null) {
			return null;
		} else {
			Database.messages.put(m.getId(), m);
		}

		return m;
	}

	@Override
	public void removeMessage(long m) throws DataNotFoundException {
		
		Message mes = Database.messages.get(m);

		if (mes == null) {
			throw new DataNotFoundException();
		} else {
			Database.messages.remove(m);
		}

		
	}

	@Override
	public List<Message> getMessagesByCount(long count) {
		List<Message> list = new ArrayList<>(Database.messages.values());
		if(list.size() > count) {
			return list.subList(0, new Long(count).intValue());	
		}else {
			return list;
		}
	}

}
