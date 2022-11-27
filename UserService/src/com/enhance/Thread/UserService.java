package com.enhance.Thread;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

	private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	//private static SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args)
	{
		for(int i=0;i<1000;i++) {
			int id=i;
			 threadPool.submit(()->{
				String birthDate = UserService.birthDate(id);
				System.out.println(birthDate);
			});
			
		}
		
		
		
		
		
	}
	public static String birthDate(int UserId) {
		Date birthDate = birthDateFromDB(UserId);
		// Here we are calling the ThreadSafeFormatter
		final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
		
		return df.format(birthDate);
	}
	private static Date birthDateFromDB(int userId) {
		// TODO Auto-generated method stub
		
		Date myObj = new Date(userId);
		 return myObj;
	}
}


class ThreadSafeFormatter{
	
	//java 8 coonvention to make threadsafe dateFormatter
	public static ThreadLocal<SimpleDateFormat> dateFormatter  = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd"));
	
	
}
