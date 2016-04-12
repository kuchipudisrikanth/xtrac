package fidelity.xtrac.com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import fidelity.xtrac.com.inmemory.InMemoryDB;
import fidelity.xtrac.com.model.Application;
import fidelity.xtrac.com.model.User;

public class UserService {

	private Map<String, User> userMap;

	private Map<Long, Application> applicationMap;

	private static List<Long> appIdList = new ArrayList<Long>();

	public UserService()
	{
		userMap = InMemoryDB.getUsers();
		applicationMap = InMemoryDB.getApplications();
		
	}


	public List<User> getAllUsers()
	{
		return new ArrayList<User>(userMap.values());
	}


	//create user
	public User addUser(User user)
	{
		String email=user.geteMail();
		if(user!=null && !userMap.containsKey(email)&& email.indexOf('@')!=-1 && email.indexOf('.')!=-1 &&   email.indexOf('@')+1 <  email.indexOf('.') )
		{
			if(user.getFirstName() != null && user.getLastName()!= null  && user.getPhoneNumber() != null && user.getPhoneNumber().length() == 10 && user.getPhoneNumber().charAt(0) != 0 ){
				userMap.put(user.geteMail(), user);
				System.out.println(user.getPhoneNumber());
				return user;
			}
		}
		else
		{
			return null;
		}
		return null;

	}

	//Retrieve user
	public User getUser(String  eMail)
	{
		if(eMail!=null && userMap.containsKey(eMail))
		{
			User user = userMap.get(eMail);
			return user;
		}
		else
		{
			return null;
		}
	}


	//update user
	public User updateUser(User user)
	{
		if(user!=null && user.geteMail()!=null && userMap.containsKey(user.geteMail()))
		{
			userMap.put(user.geteMail(), user);
			return user;
		}
		else
		{
			return null;
		}
	}


	//Delete user
	public void deleteUser(String  eMail)
	{
		System.out.println(eMail);
		if(eMail!=null && userMap.containsKey(eMail))
		{
			Iterator<Map.Entry<Long, Application>> iter = applicationMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<Long, Application> entry = (Map.Entry<Long, Application>) iter.next();
				Application app=entry.getValue();
				if(eMail.equalsIgnoreCase(app.geteMail()))
				{
					iter.remove();
				}

			}
			userMap.remove(eMail);
		}
		else{

		}
	}



	//register app
	public Application registerApplication(Application application)
	{
		if(userMap.containsKey(application.geteMail()))
		{
			String email = application.geteMail();
			String name = application.getAppName();

			boolean flag = true;

			for(Application app : applicationMap.values())
			{
				if(app.geteMail().equals(email))
				{
					if(app.getAppName().equalsIgnoreCase(name))
					{
						flag = false;
					}
				}

			}

			//register application
			if(flag)
			{
				Long appId = new Long(getRandomId());

				do{

					if(appIdList.contains(appId))
					{
						appId = new Long(getRandomId());
					}
					else{
						break;
					}
				}
				while(true);

				application.setAppId(appId);
				application.setAppSecretKey(randomAlphabeticString());

				applicationMap.put(appId, application);

				return application;

			}
			else{
				return null;
			}
		}
		else{
			return null;
		}

	}



	//getApplicationByEmail
	public List<Application> getApplicationByEmail(String email)
	{ 
		if(userMap.containsKey(email))
		{

			List<Application> apps = new ArrayList<>();

			for(Application app : applicationMap.values())
			{
				//System.out.println(app.getAppId());
				if(app.geteMail().equals(email))
				{
					apps.add(app);
					//System.out.println(apps.size());

				}
			}
			return apps;
		}
		else{
			return null;
		}

	}

	//deleteAppByAppID
	public void deleteAppByAppID(String email, Long appId)
	{
		System.out.println(email);

		if(userMap.containsKey(email))
		{
			if(applicationMap.containsKey(appId))
			{
				System.out.println(applicationMap.size());
				applicationMap.remove(appId);
				System.out.println(applicationMap.size());
			}


		}

	}

	public int getRandomId(){
		Random r = new Random(System.currentTimeMillis());
		return 10000+r.nextInt(20000);
	}

	private String randomAlphabeticString() {

		String generatedSring = RandomStringUtils.randomAlphabetic(5);

		System.out.println(generatedSring);

		return generatedSring;
	}

}
