package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.entities.IPLTeam;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;
public class TeamRegistration {
	public static void main(String[] args) {
		try(SessionFactory sf=getSessionFactory();
			Scanner sc=new Scanner(System.in)){
			IPLTeamDao iplDao=new IPLTeamDaoImpl();
			System.out.println("Enter Team Details: ");
			System.out.println(" String name, String abbreviation, String owner ,Int Max Player Age, Double Avg_Batting , int Wicket_Taken");
			
			IPLTeam team=new IPLTeam(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(iplDao.registerTeam(team));
		}catch(Exception e) {
		e.printStackTrace();
		}
	}

}
