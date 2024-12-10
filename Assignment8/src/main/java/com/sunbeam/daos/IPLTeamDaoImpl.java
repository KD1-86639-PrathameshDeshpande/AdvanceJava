package com.sunbeam.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.IPLTeam;
import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class IPLTeamDaoImpl implements IPLTeamDao{

	@Override
	public String registerTeam(IPLTeam team) {
		String msg="Team Registration Failed";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable teamId=session.save(team);
			tx.commit();
			msg="Team Registered.."+teamId;
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
	
			}
			throw e;
			
		}
		
		return msg;
	}

	@Override
	public List<IPLTeam> displayTeams() {
		String jpql="select t from IPLTeam t";
		List<IPLTeam> teams=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			teams =session.createQuery(jpql,IPLTeam.class).getResultList();
		tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return teams;
	}

	@Override
	public List<IPLTeam> diaplayTeamswithAgenBatting(int maxPlayerAge, double battingAvg) {
		String jpql="select t from IPLTeam t where t.maxPlayerAge < :age and t.battingAvg > : avg ";
		List<IPLTeam> teams=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			teams=session.createQuery(jpql,IPLTeam.class).setParameter("age",maxPlayerAge).setParameter("avg", battingAvg).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
			
		}
		return teams;
	}

	@Override
	public List<IPLTeam> displayOwnerandAbbreviation(int maxPlayerAge, double battingAvg) {
		String jpql="select new com.sunbeam.entities.IPLTeam(owner,abbreviation) from IPLTeam t where t.maxPlayerAge < :age and t.battingAvg > :avg";
		List<IPLTeam> teams=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(jpql,IPLTeam.class).setParameter("age",maxPlayerAge).setParameter("avg", battingAvg).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
			
		}
		return teams;
	}

	@Override
	public String updateMaxAgeRequirement(String name,int newAge) {
		IPLTeam team=null;
		String msg="Requirement Update Failed";
		String jpql="select t from IPLTeam t where t.name=:tname";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			team=session.createQuery(jpql,IPLTeam.class).setParameter("tname",name).getSingleResult();
			team.setMaxPlayerAge(newAge);
			msg="Team Requirement Updated..";
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
				
			}
			throw e;
		}
		
		
		return msg;
	}

	@Override
	public String deleteTeam(Long teamId) {
	String msg="Team Not deleted";
	IPLTeam team=null;
	Session session=getSessionFactory().getCurrentSession();
	Transaction tx=session.beginTransaction();
	try {
		team=session.get(IPLTeam.class, teamId);
		if(team!=null) {
			session.delete(team);
			msg=team.getName()+" Deleted Successfully";
			tx.commit();
		}
		
	}catch(RuntimeException e) {
		if(tx!=null) {
			tx.rollback();
		}
		throw e;
	}

		return msg;
	}
	

}
