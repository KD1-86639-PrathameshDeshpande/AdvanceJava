package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.utils.HibernateUtil;

public class GetAllTeams {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtil.getSessionFactory()){
			IPLTeamDao teamDao=new IPLTeamDaoImpl();
			teamDao.displayTeams().forEach(System.out::println);
		} catch(RuntimeException e){
		
			e.printStackTrace();
		}
	}

}
