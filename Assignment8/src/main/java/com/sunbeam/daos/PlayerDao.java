package com.sunbeam.daos;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;

public interface PlayerDao {
 String addNewPlayer(Long teamId,Player player);
 List<Player> displayPlayers(Long teamId);
 String removePlayer(Long teamId, Long playerId);
}
