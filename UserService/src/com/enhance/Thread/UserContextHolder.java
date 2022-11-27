package com.enhance.Thread;

/* This class describes about  on a web server how different services can know the user
 and how to make the user acessible to everyone*/
public class UserContextHolder {

	public static ThreadLocal<User> holder = new ThreadLocal();
}
class User
{
	
}
class Service1{
	
	//here this class will set the user into threadPool
	public void process() {
		User user = getUser();
		UserContextHolder.holder.set(user);
	}

	private User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Service2{
	//Clases like this will get the user from the UserContextHolder
	public void process() {
		User user = UserContextHolder.holder.get();
	}
}

class Service4{
	//To clean the UserContext
	public void process() {
		UserContextHolder.holder.remove();
	}
}