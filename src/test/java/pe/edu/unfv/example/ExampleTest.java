package pe.edu.unfv.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
		int numero = 6;
		
		// When => cuando
		long result = example.factorial(numero);
		
		// Then => entonces
		assertEquals(720, result);
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
	void testEsPrimoMayorUnoNoPrimo() {

		// Given => teniendo
		int numero = 8;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertFalse(result);
	}
	
	@Test
	void testEsPrimoMayorUnoPrimo() {

		// Given => teniendo
		int numero = 9;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertFalse(result);
	}
	
	@Test
	void testEsPrimoTrue() {

		// Given => teniendo
		int numero = 3;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertTrue(result);
	}
	
	@Test
	void testEsPrimoFalse() {

		// Given => teniendo
		int numero = 10;
		
		// When => cuando
		boolean result = example.esPrimo(numero);
		
		// Then => entonces
		assertFalse(result);
	}
	
	@Test
	void testMensajeConRetraso() throws InterruptedException {

		// Given => teniendo
		//int numero = 10;
		
		// When => cuando
		String result = example.mensajeConRetraso();
		
		// Then => entonces
		assertEquals("Listo despues de un retraso",result);
	}
	
	@Test
	void testConvertirAsString() {

		// Given => teniendo
		List<Integer> numero = new ArrayList<>();
		numero.add(5);
		numero.add(10);
		numero.add(15);
		numero.add(20);
		numero.add(25);
		numero.add(30);
		numero.add(35);
		
		
		// When => cuando
		List<String> result = example.convertirAsString(numero);
		
		List<String> resultEsperado = new ArrayList<>();
		resultEsperado.add("5");
		resultEsperado.add("10");
		resultEsperado.add("15");
		resultEsperado.add("20");
		resultEsperado.add("25");
		resultEsperado.add("30");
		resultEsperado.add("35");
		
		// Then => entonces
		assertIterableEquals(resultEsperado,result);
	}
	
	@Test
	void testCalcularMediaEmpty() {

		// Given => teniendo
		List<Integer> numero = new ArrayList<>();	
		
		// When with Then => entonces
		assertThrows(IllegalArgumentException.class, () -> {
			example.calcularMedia(numero);
		});
	}
	
	@Test
	void testCalcularMediaNull() {

		// Given => teniendo
		List<Integer> numero = null;	
		
		// When with Then => entonces
		assertThrows(IllegalArgumentException.class, () -> {
			example.calcularMedia(numero);
		});
	}
	
	@Test
	void testCalcularMedia() {

		// Given => teniendo
		List<Integer> numero = new ArrayList<>();	
		numero.add(5);
		numero.add(10);
		numero.add(15);
		numero.add(20);
		numero.add(25);
		numero.add(30);
		numero.add(35);
		
		// When => cuando
		double result = example.calcularMedia(numero);
				
		// Then => entonces
		assertEquals(20, result);
	}
	
	@Test
	void testConvertirListAsString() {

		// Given => teniendo
		List<String> resultEsperado = new ArrayList<>();
		resultEsperado.add("5");
		resultEsperado.add("10");
		resultEsperado.add("15");
		
		// When => cuando
		String result = example.convertirListAsString(resultEsperado);
				
		// Then => entonces
		assertEquals("5,10,15", result);
	}
}
