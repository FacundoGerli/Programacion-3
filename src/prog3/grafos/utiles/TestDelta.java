package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class TestDelta {

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		
		Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Dolores");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Mardel");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Miramar");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Capital Federal");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Quilmes");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Azul");
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		
		grafo.conectar(v1, v2);
		grafo.conectar(v1,v5);
		grafo.conectar(v1, v7);
		grafo.conectar(v2, v3);
		grafo.conectar(v2, v4);
		grafo.conectar(v5, v6);
		//grafo no dirigido
		grafo.conectar(v2, v1);
		grafo.conectar(v5,v1);
		grafo.conectar(v7, v1);
		grafo.conectar(v3, v2);
		grafo.conectar(v4, v2);
		grafo.conectar(v6, v5);
		
		Delta delta = new Delta();
		
		System.out.println("Cantidad de islas maximas"+delta.maxIslasDistintas(grafo));
		
	}

}
