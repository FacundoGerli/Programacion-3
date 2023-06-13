package prog3.util;

public class TestPila {

	public static void main(String[] args) {
		Cola<Integer> cola = new Cola<Integer>();
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		cola.encolar(4);
		
		System.out.println("La cola esta vacia?"+ cola.esVacio());
		
		System.out.println(cola.desencolar());
		System.out.println(cola.desencolar());
		System.out.println(cola.desencolar());
		System.out.println(cola.desencolar());
		
		System.out.println("La cola esta vacia?"+ cola.esVacio());
		
		
	}
}
