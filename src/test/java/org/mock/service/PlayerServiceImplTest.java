package org.mock.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.Mockito;

class PlayerServiceImplTest {

	@Test
	void testFindAll() {
		// Given -> Teniendo
		PlayerRepositoryImpl playerRepositoryImpl = Mockito.mock(PlayerRepositoryImpl.class);
		PlayerServiceImpl playerServiceImpl = new PlayerServiceImpl(playerRepositoryImpl);

		// When -> Cuando
		Mockito.when(playerRepositoryImpl.findAll())
				.thenReturn("");
		List<Player> result = playerServiceImpl.findAll();

		// Then -> entonces
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Kevin De Bruyne", result.get(4).getName());
		assertEquals("Manchester City", result.get(4).getTeam());
		assertEquals("Volante", result.get(4).getPosition());
	}

	@Test
	void testFindById() {
		// Given -> Teniendo
		PlayerRepositoryImpl playerRepositoryImpl = new PlayerRepositoryImpl();
		PlayerServiceImpl playerServiceImpl = new PlayerServiceImpl(playerRepositoryImpl);

		// When -> Cuando
		Long id = 5L;
		Player result = playerServiceImpl.findById(id);

		// Then -> entonces
		assertNotNull(result);
		assertEquals("Kevin De Bruyne", result.getName());
		assertEquals("Manchester City", result.getTeam());
		assertEquals("Volante", result.getPosition());
	}	

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
