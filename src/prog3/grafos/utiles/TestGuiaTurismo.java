package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class TestGuiaTurismo {

	public static void main(String[] args) {
		Grafo<Integer> grafo = new GrafoImplListAdy<>();
		
		Vertice<Integer> v1 = new VerticeImplListAdy<>(1);
		Vertice<Integer> v2 = new VerticeImplListAdy<>(2);
		Vertice<Integer> v3 = new VerticeImplListAdy<>(3);
		Vertice<Integer> v4 = new VerticeImplListAdy<>(4);
		Vertice<Integer> v5 = new VerticeImplListAdy<>(5);
		Vertice<Integer> v6 = new VerticeImplListAdy<>(6);
		Vertice<Integer> v7 = new VerticeImplListAdy<>(7);
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		
		grafo.conectar(v1, v2, 30);
		grafo.conectar(v2, v1, 30);
		
		grafo.conectar(v1, v3, 15);
		grafo.conectar(v3, v1, 15);
		
		grafo.conectar(v1,v4,10);
		grafo.conectar(v4,v1,10);
		
		grafo.conectar(v4, v2, 25);
		grafo.conectar(v2, v4, 25);
		
		grafo.conectar(v4, v3,40);
		grafo.conectar(v3, v4,40);
		
		grafo.conectar(v4, v7,35);
		grafo.conectar(v7, v4,35);
		
		grafo.conectar(v2, v5,60);
		grafo.conectar(v5, v2,60);
		
		grafo.conectar(v3, v6,20);
		grafo.conectar(v6, v3,20);
		
		grafo.conectar(v5, v7,20);
		grafo.conectar(v7, v5,20);
		
		grafo.conectar(v6, v7, 30);
		grafo.conectar(v7, v6, 30);
		
		GuiaDeTurismo guia = new GuiaDeTurismo();
		ListaGenerica<Integer> camino = guia.caminoConMenorNrodeViajes(grafo, 1, 7);
		camino.imprimir();
		

	}

}
