package com.sunbeam.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.IPLTeam;
import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.io.Serializable;

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
	

}
