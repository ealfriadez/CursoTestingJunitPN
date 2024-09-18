package pe.edu.unfv.example;

import java.util.List;

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
}
