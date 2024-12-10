package com.sunbeam.daos;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;
import com.sunbeam.utils.HibernateUtil;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Long teamId, Player player) {
		String msg = "Player Not Added";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			IPLTeam team = session.get(IPLTeam.class, teamId);

			if (team != null) {
				team.addPlayer(player);
				session.persist(player);

			}
			msg = "New Player Added in team" + team.getId();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;
	}

	@Override
	public List<Player> displayPlayers(Long teamId) {
		List<Player> players = null;
		IPLTeam team = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.get(IPLTeam.class, teamId);
			if (team != null) {
				Hibernate.initialize(team.getPlayers());
				players = team.getPlayers();
			}

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return players;

	}

	@Override
	public String removePlayer(Long teamId, Long playerId) {
		String msg = "Player not removed..";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			IPLTeam team = session.get(IPLTeam.class, teamId);
			Player players = session.get(Player.class, playerId);

			if (team != null && players != null) {
				team.removePlayer(players);

				msg = "Player Removed";
				tx.commit();
			}

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;

	}

}
