package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

public class TestHibernate {
	public static void main(String[] args) {
		
		
		try(SessionFactory sf=getSessionFactory()){
			System.out.println("Hibernate is Up and Running");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
