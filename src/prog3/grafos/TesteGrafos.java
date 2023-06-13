package prog3.grafos;
import prog3.listagenerica.*;
public class TesteGrafos {

	public static void main(String[] args) {
		Grafo<Integer> numeros = new GrafoImplListAdy<>();
		
		Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
		Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
		Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
		Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
		Vertice<Integer> v5 = new VerticeImplListAdy<Integer>(5);
		Vertice<Integer> v6 = new VerticeImplListAdy<Integer>(6);
		
		numeros.agregarVertice(v1);
		numeros.agregarVertice(v2);
		numeros.agregarVertice(v3);
		numeros.agregarVertice(v4);
		numeros.agregarVertice(v5);
		numeros.agregarVertice(v6);
		
		numeros.conectar(v1, v2);
		numeros.conectar(v1, v3);
		numeros.conectar(v3, v4);
		numeros.conectar(v4, v5);
		numeros.conectar(v2, v6);
		
		Recorridos r = new Recorridos();
		System.out.println("----Recorrido BFS-----");
		ListaGenerica<Arista<Integer>> caminos =  r.bfs(numeros);
		caminos.imprimir();
	}

}
