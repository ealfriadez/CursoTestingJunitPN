package org.mock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

	@Mock
	PlayerRepositoryImpl playerRepositoryImpl;

	@InjectMocks
	PlayerServiceImpl playerServiceImpl;

	@Test
	void testFindAll() {

		// When -> Cuando
		Mockito.when(playerRepositoryImpl.findAll()).thenReturn(DataProvider.playerListMock());

		List<Player> result = playerServiceImpl.findAll();

		// Then -> entonces
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Kevin De Bruyne", result.get(4).getName());
		assertEquals("Manchester City", result.get(4).getTeam());
		assertEquals("Volante", result.get(4).getPosition());
		verify(this.playerRepositoryImpl).findAll();
	}

	@Test
	void testFindById() {

		// Given -> Mientras
		Long id = 5L;

		// When -> Cuando
		Mockito.when(playerRepositoryImpl.findById(anyLong())).thenReturn(DataProvider.playerMock());
		Player result = playerServiceImpl.findById(id);

		// Then -> entonces
		assertNotNull(result);
		assertEquals("Neymar Jr.", result.getName());
		assertEquals("Paris Saint-Germain", result.getTeam());
		assertEquals("Delantero", result.getPosition());
		verify(this.playerRepositoryImpl).findById(anyLong());
	}

	@Test
	void testSave() {

		// Given
		Player player = DataProvider.newPlayerMock();

		// When -> Cuando
		this.playerServiceImpl.save(player);

		// Then -> entonces		
		//verify(this.playerRepositoryImpl).save(any(Player.class));
		ArgumentCaptor<Player> argumentCaptor = ArgumentCaptor.forClass(Player.class);
		verify(this.playerRepositoryImpl).save(argumentCaptor.capture());
		assertEquals(7L, argumentCaptor.getValue().getId());
		assertEquals("Loco Vargas", argumentCaptor.getValue().getName());
		assertEquals("Marcador", argumentCaptor.getValue().getPosition());
		assertEquals("Fiorentina", argumentCaptor.getValue().getTeam());
	}

	@Test
	void testDeleteById() {

		// Given -> Mientras
		Long id = 5L;

		// When -> Cuando
		this.playerServiceImpl.deleteById(id);
		
		//then
		ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
		verify(this.playerRepositoryImpl).deleteById(anyLong());
		verify(this.playerRepositoryImpl).deleteById(argumentCaptor.capture());
		assertEquals(5L, argumentCaptor.getValue());
	}

}
