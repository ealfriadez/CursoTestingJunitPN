package org.mock.service;

import java.util.List;

import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;

public class PlayerServiceImpl implements IPlayerService{

	private PlayerRepositoryImpl playerRepositoryImpl;
	
	public PlayerServiceImpl(PlayerRepositoryImpl playerRepositoryImpl) {
		super();
		this.playerRepositoryImpl = playerRepositoryImpl;
	}

	@Override
	public List<Player> findAll() {
		
		return this.playerRepositoryImpl.findAll();
	}

	@Override
	public Player findById(Long id) {
		
		return this.playerRepositoryImpl.findById(id);
	}

	@Override
	public void save(Player player) {
		
		this.playerRepositoryImpl.save(player);
	}

	@Override
	public void deleteById(Long id) {
		
		this.playerRepositoryImpl.deleteById(id);
	}
}
