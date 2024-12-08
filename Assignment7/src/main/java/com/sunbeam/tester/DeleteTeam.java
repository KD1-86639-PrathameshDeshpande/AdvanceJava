package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.utils.HibernateUtil;

public class DeleteTeam {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtil.getSessionFactory();
				Scanner sc=new Scanner(System.in)
				){
			IPLTeamDao teamDao=new IPLTeamDaoImpl();
			System.out.println("Enter Team id tp delete");
			System.out.println(teamDao.deleteTeam(sc.nextLong()));
		} catch(RuntimeException e){
		
			e.printStackTrace();
		}
	
	
	}
	}
