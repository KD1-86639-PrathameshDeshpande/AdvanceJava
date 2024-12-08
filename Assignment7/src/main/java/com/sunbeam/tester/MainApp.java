package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.IPLTeamDao;
import com.sunbeam.daos.IPLTeamDaoImpl;
import com.sunbeam.entities.IPLTeam;
import com.sunbeam.utils.HibernateUtil;

public class MainApp {
	private static void displayAllTeams() {
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
	
	
	
	private static int menu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add team");
		System.out.println("2.Display All teams");
		System.out.println("3.Display Teams with MaxPlayerAge and MaxBattingAverage");
		System.out.println("4.Display owner and abbreviation of teams with given PlayerAge and BattingAverage");
		System.out.println("5.Update Teams Max Player Age Requirement");
		System.out.println("6.Delete Team");
		System.out.println("Enter Your Choice:");
		int choice=sc.nextInt();
		return choice;
	}
	public static void main(String[] args) {
		int choice;
		
		while((choice=menu())!=0) {
			switch (choice) {
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


			default:System.out.println("Invalid Choice..");
				break;
			}
		}
		
	}

}
