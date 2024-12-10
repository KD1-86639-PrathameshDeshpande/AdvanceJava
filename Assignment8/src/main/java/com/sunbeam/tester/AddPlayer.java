package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.PlayerDao;
import com.sunbeam.daos.PlayerDaoImpl;
import com.sunbeam.entities.Player;
import com.sunbeam.utils.HibernateUtil;

public class AddPlayer {
public static void main(String[] args) {
	try(SessionFactory sf=HibernateUtil.getSessionFactory();
		Scanner sc=new Scanner(System.in)	) {
		PlayerDao pdao=new PlayerDaoImpl();
		System.out.println("Enter team id");
		Long teamId=sc.nextLong();
		System.out.println("Enter Player Details: (FirstName,LastName,DOB,Batting Average,Wickets Taken)");
		Player p=new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
		
		System.out.println(pdao.addNewPlayer(teamId, p));
	}catch(RuntimeException e) {
		e.printStackTrace();
		
	}
}
}
