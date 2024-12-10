package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.daos.PlayerDao;
import com.sunbeam.daos.PlayerDaoImpl;
import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;
import com.sunbeam.utils.HibernateUtil;

public class MainApp {
	private static Scanner sc=new Scanner(System.in);
	private static void displayAllTeams() {
		try(SessionFactory sf=HibernateUtil.getSessionFactory()){
			IPLTeamDao teamDao=new IPLTeamDaoImpl();
			teamDao.displayTeams().forEach(System.out::println);
		} catch(RuntimeException e){
		
			e.printStackTrace();
		}
	}
private static void addTeam() {
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
private static void displaySelectedTeam() {
	
	try(SessionFactory sf=HibernateUtil.getSessionFactory();
			Scanner sc=new Scanner(System.in)){
			IPLTeamDao teamdao=new IPLTeamDaoImpl();
			System.out.println("Enter Max_age and Avg_Batting ");
			teamdao.diaplayTeamswithAgenBatting(
					sc.nextInt(),
					sc.nextDouble()).forEach(t->System.out.println(t.getAbbreviation()+"-->"+t.getOwner()));
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
}
private static void displayOwnerAndAbbre() {
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
private static void UpdateTeam() {
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
private static void deleteTeam() {
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
private static void displayplayerbyid() {
	try(SessionFactory sf=HibernateUtil.getSessionFactory();
			Scanner sc=new Scanner(System.in)){
		PlayerDao pdao=new PlayerDaoImpl();
		System.out.println("Enter Team Id: ");
		System.out.println(pdao.displayPlayers(sc.nextLong()));
		
	}catch(RuntimeException e) {
		e.printStackTrace();
	}
}
private static void addPlayer() {
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

	
	public static void main(String[] args) {
		int choice=0;
		
		try(SessionFactory sf=HibernateUtil.getSessionFactory();
				Scanner sc=new Scanner(System.in))
		{
			
		
		for(;;) {
		System.out.println("0.Exit");
		System.out.println("1.Add team");
		System.out.println("2.Display All teams");
		System.out.println("3.Display Teams with MaxPlayerAge and MaxBattingAverage");
		System.out.println("4.Display owner and abbreviation of teams with given PlayerAge and BattingAverage");
		System.out.println("5.Update Teams Max Player Age Requirement");
		System.out.println("6.Delete Team");
		System.out.println("7.Add Player In Team");
		System.out.println("8.Display Players in specific team");
		System.out.println("Enter Your Choice:");
		choice=sc.nextInt();
	
			switch (choice) {
			case 0:
				System.out.println("Thank You For Using App");
				System.exit(0);
				
				break;
			case 1:
				addTeam();
				
				break;
			case 2:
				displayAllTeams();
				
				break;
			case 3:
				displaySelectedTeam();
	
				break;
			case 4:
				displayOwnerAndAbbre();
	
				break;
			case 5:
				UpdateTeam();
	
				break;
			case 6:
				deleteTeam();
	
				break;
			case 7:
				addPlayer();
	
				break;
			case 8:
				displayplayerbyid();
				
				break;

			default:System.out.println("Invalid Choice..");
				break;
			}
		}
		}
		
	}

}
