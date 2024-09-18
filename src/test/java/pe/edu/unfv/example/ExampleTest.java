package pe.edu.unfv.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExampleTest {

	private Example example;
	
	@BeforeEach
	 void init() {
		
		this.example = new Example();
	}
	
	@Test
	void testSumar() {

		// Given => teniendo		
		int numberA = 3;
		int numberB = 3;

		// When => cuando
		int result = example.sumar(numberA, numberB);

		// Then => entonces
		assertNotNull(result);
		assertEquals(6, result);
		assertInstanceOf(Integer.class, result);
	}

	@Test
	void testcheckPositivo() {

		// Given => teniendo
		Example example = new Example();
		int numero = 9;
		
		// When => cuando
		boolean result = example.checkPositivo(numero);
		
		// Then => entonces
		assertTrue(result);
	}
	
	@Test
	void testcheckPositivoError() {

		// Given => teniendo
		Example example = new Example();
		int numero = -9;		
		
		// Then => entonces
		assertThrows(IllegalArgumentException.class, () -> {
			example.checkPositivo(numero);
		});
	}
	
	@Test
	void testContarLetraA() {

		// Given => teniendo
		Example example = new Example();
		String cadena = "Pachamama";
		
		// When => cuando
		int result = example.contarLetraA(cadena);
		
		// Then => entonces
		assertNotNull(result);
		assertInstanceOf(Integer.class, result);
		assertEquals(4, result);
	}
	
	@Test
	void testContieneElemento() {

		// Given => teniendo
		Example example = new Example();
		List<String> lista = new ArrayList<>();
		lista.add("Rosa Nautica");
		lista.add("El muelle");
		lista.add("Pachamama");
		lista.add("Rockys");
		lista.add("Norkys");
		lista.add("El Dorado");
		lista.add("Pachamama");
		
		String cadena = "Pachamama";
		
		// When => cuando
		boolean result = example.contieneElemento(lista, cadena);
		
		// Then => entonces
		assertNotNull(result);		
		assertTrue(result);
	}
}
