package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;

public class TestAlgoritmos {

	public static void main(String[] args) {
		Grafo<Integer> grafo = new GrafoImplListAdy<>();
		Vertice<Integer> v1 = new VerticeImplListAdy<>(1);
		Vertice<Integer> v2 = new VerticeImplListAdy<>(2);
		Vertice<Integer> v3 = new VerticeImplListAdy<>(3);
		Vertice<Integer> v4 = new VerticeImplListAdy<>(4);
		Vertice<Integer> v5 = new VerticeImplListAdy<>(5);
		
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		
		grafo.conectar(v1, v2);
		grafo.conectar(v2, v3);
		grafo.conectar(v3, v4);
		grafo.conectar(v4, v1);
		
		Algoritmos<Integer> a = new Algoritmos<>();
		
		System.out.println("El arbol tiene un ciclo cuadrado? "+a.subgrafoCuadrado(grafo));
		System.out.println("El grado del arbol es de: "+ a.getGrado(grafo));
		System.out.println("El arbol tiene ciclo?"+ a.tieneCiclo(grafo));
		
		

	}

}
