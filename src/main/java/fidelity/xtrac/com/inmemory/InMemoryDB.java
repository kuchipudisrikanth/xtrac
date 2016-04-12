package fidelity.xtrac.com.inmemory;

import java.util.HashMap;
import java.util.Map;

import fidelity.xtrac.com.model.Application;
import fidelity.xtrac.com.model.User;

public class InMemoryDB {

	private static Map<String, User> users = new  HashMap<>();
	
	private static Map<Long, Application> applications = new  HashMap<>();
	
	static
	{
		User u = new User("sreekanth@outlook.com","sreekanth","kuchipudi","111-222-3333");
		users.put("sreekanth@outlook.com", u);	
		Application a = new Application(new Long("11111"),"Test","Test","sreekanth@outlook.com","abcdABCD");
		applications.put(a.getAppId(),a);
	}
	
	public static Map<String, User> getUsers()
	{
		return users;
	}
	
	public static Map<Long, Application> getApplications()
	{
		return applications;
	}
}
