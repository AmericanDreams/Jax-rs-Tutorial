package mir.project.massenger.database;

import java.util.HashMap;
import java.util.Map;

import mir.project.massenger.model.Author;
import mir.project.massenger.model.Message;

public class Database {

	public static Map<Long,Message> messages = new HashMap<>();
	public static Map<Long,Author> authors = new HashMap<>();
	
	private static long messageId = 1;
	private static long authorId = 1;
	
	public static long messageId() {
		return messageId++;
	}
	
	public static long authorId() {
		return authorId++;
	}
	
}
