package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.utils.HibernateUtil;

public class UpdateRequirement {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtil.getSessionFactory();
				Scanner sc=new Scanner(System.in)
				){
			IPLTeamDao teamDao=new IPLTeamDaoImpl();
			System.out.println("Enter team Name and New Age Requirement");
			System.out.println(teamDao.updateMaxAgeRequirement(sc.next(),sc.nextInt()));
		} catch(RuntimeException e){
		
			e.printStackTrace();
		}
	}

}
