
package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.PlayerDao;
import com.sunbeam.daos.PlayerDaoImpl;
import com.sunbeam.utils.HibernateUtil;

public class DisplayPlayers {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtil.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			PlayerDao pdao=new PlayerDaoImpl();
			System.out.println("Enter Team Id: ");
			System.out.println(pdao.displayPlayers(sc.nextLong()));
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

}
