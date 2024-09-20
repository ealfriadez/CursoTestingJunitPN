package org.mock.persistence.entity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class PlayerRepositoryImplTest {

	private PlayerRepositoryImpl playerRepositoryImpl;

	@BeforeEach
	void init() {

		this.playerRepositoryImpl = new PlayerRepositoryImpl();
	}

	@Test
	void testFindAll() {

		// When -> cuando
		List<Player> result = playerRepositoryImpl.findAll();

		// Then -> entonces
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Kevin De Bruyne", result.get(4).getName());
		assertEquals("Manchester City", result.get(4).getTeam());
		assertEquals("Volante", result.get(4).getPosition());

	}

	@Test
	void testFindById() {

		// Given -> mientras
		Long id = 3L;

		// When -> cuando
		Player result = playerRepositoryImpl.findById(id);

		// Then -> entonces
		assertNotNull(result);
		assertEquals("Neymar Jr.", result.getName());
		assertEquals("Paris Saint-Germain", result.getTeam());
		assertEquals("Delantero", result.getPosition());
	}

	@Test
	void testSave() {

		// Given -> mientras
		Player playerNew = new Player(7L, "Maradona", "Boca Juniors", "Delantero");

		// When -> cuando
		playerRepositoryImpl.save(playerNew);
		List<Player> result = playerRepositoryImpl.findAll();

		// Then -> entonces
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Maradona", result.get(6).getName());
		assertEquals("Boca Juniors", result.get(6).getTeam());
		assertEquals("Delantero", result.get(6).getPosition());
	}

	@Test
	void testDeleteById() {

		// Given -> mientras
		Long id = 3L;

		// When -> cuando
		playerRepositoryImpl.deleteById(id);
		List<Player> result = playerRepositoryImpl.findAll();

		// Then -> entonces
		assertNotNull(result);
		assertTrue(result.size() > 0);
		assertFalse(result.isEmpty());
	}

}
