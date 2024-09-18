package pe.edu.unfv.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
		int numero = 9;
		
		// When => cuando
		boolean result = example.checkPositivo(numero);
		
		// Then => entonces
		assertTrue(result);
	}
	
	@Test
	void testcheckPositivoError() {

		// Given => teniendo
		int numero = -9;		
		
		// Then => entonces
		assertThrows(IllegalArgumentException.class, () -> {
			example.checkPositivo(numero);
		});
	}
	
	@Test
	void testContarLetraA() {

		// Given => teniendo
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
	
	@Test
	void testRevertirCadena() {

		// Given => teniendo
		String cadena = "Pachamama";
		
		// When => cuando
		String result = example.revertirCadena(cadena);
		
		// Then => entonces
		assertNotNull(result);	
		assertEquals("amamahcaP", result);
	}
	
	@Test
	void testFactorialError() {

		// Given => teniendo
		int numero = -9;		
		
		// Then => entonces
		assertThrows(IllegalArgumentException.class, () -> {
			example.factorial(numero);
		});
	}
	
	@Test
	void testFactorial() {

		// Given => teniendo
		int numero = 2;
		
		// When => cuando
		long result = example.factorial(numero);
		
		// Then => entonces
		assertEquals(2, result);
	}
	
	@Test
	void testEsPrimoMenorIgualUno() {

		// Given => teniendo
		int numero = 1;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertFalse(result);
	}
	
	@Test
	void testEsPrimoMayorUno() {

		// Given => teniendo
		int numero = 2;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertTrue(result);
	}
}
