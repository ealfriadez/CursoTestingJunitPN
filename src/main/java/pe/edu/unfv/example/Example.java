package pe.edu.unfv.example;

import java.util.List;
import java.util.stream.Collectors;

public class Example {

	//1. Metodo para sumar 2 numeros
	public int sumar(int a, int b) {
		
		return a + b;
	}
	
	//Metodo que lanza una excepcion si el argumento es negativo
	public boolean checkPositivo(int numero) {
		
		if(numero < 0) {
			throw new IllegalArgumentException("El numero no puede ser negativo");
		}
		
		return true;
	}
	
	//3. Metodo para contar el numero de letras 'a' en un cadena
	public int contarLetraA(String cadena) {
		
		return (int) cadena.chars()
				.filter(letra -> letra == 'a')
				.count();
	}
	
	//4. Metodo que retorna un valor booleano si la lista contiene el elemento
	public boolean contieneElemento(List<String> lista, String elemento) {
		
		return lista.contains(elemento);
	}
	
	//5. Metodo para revertir una cadena
	public String revertirCadena(String cadena) {
		
		return new StringBuilder(cadena).reverse().toString();
	}
	
	//6. Metodo que calcula el factorial de un numero
	public long factorial(int numero) {
		
		if(numero < 0) {
			throw new IllegalArgumentException("Factorial no definido para numeros negativos");
		}
		long resultado = 1;
		for (int i = 1; i <= numero; i++) {
			resultado *= i;
		}
		return resultado;
	}
	
	//7. Metodo para verificar si un numero es primo
	public boolean esPrimo(int numero) {
	
		if(numero <= 1) {
			return false;
		}
		
		for (int i = 2; i * i <= numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//8. Metodo que simula un retraso y retorna un mensaje
	@SuppressWarnings("unused")
	public String mensajeConRetraso() throws InterruptedException{
		
		Thread.sleep(5000);
		return "Listo despues de un retraso";
	}
	
	//9. Metodo para convertir una lista de enteros a lista de strings	
	public List<String> convertirAsString(List<Integer> lista) {
				
		return lista.stream()
				.map(String::valueOf)
				.collect(Collectors.toList());
	}
	
	//10. Media que calcula una lista de enteros
	public double calcularMedia(List<Integer> lista) {
		
		if(lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("Factorial no definido para numeros negativos");
		}
		
		return lista.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();
	}
	
	//11. Metodo para compartir una lista de enteros a lista de strings
	public String convertirListAsString(List<String> lista) {
		
		return lista.stream()
				.map(String::toUpperCase)
				.collect(Collectors.joining(","));
	}
}
