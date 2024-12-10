package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.utils.HibernateUtil;

public class GetTeamAbbreviation {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtil.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				IPLTeamDao teamdao=new IPLTeamDaoImpl();
				System.out.println("Enter Max_age and Avg_Batting ");
				teamdao.displayOwnerandAbbreviation(
						sc.nextInt(),
						sc.nextDouble()).forEach(System.out::println);
				
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
	}

}
