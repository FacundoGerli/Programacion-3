package prog3.grafos.ejercicio6;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class TestEJ6 {

	public static void main(String[] args) {
		 Grafo<String> grafo = new GrafoImplListAdy<String>();

		    Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
		    Vertice<String> v2 = new VerticeImplListAdy<String>("Gonnet");
		    Vertice<String> v3 = new VerticeImplListAdy<String>("City Bell");
		    Vertice<String> v4 = new VerticeImplListAdy<String>("Villa Elisa");
		    Vertice<String> v5 = new VerticeImplListAdy<String>("Quilmes");

		    grafo.agregarVertice(v1);
		    grafo.agregarVertice(v2);
		    grafo.agregarVertice(v3);
		    grafo.agregarVertice(v4);
		    grafo.agregarVertice(v5);

		    grafo.conectar(v1, v2, 400);
		    grafo.conectar(v1, v3, 300);
		    grafo.conectar(v2, v4, 200);
		    grafo.conectar(v3, v4, 100);
		    grafo.conectar(v4, v5, 800);
		    
		    Mapa mapa = new Mapa();
		    mapa.setMapaCiudades(grafo);
		    
		    ListaGenerica<String> caminoCorto = mapa.caminoConMenorCargaDeCombustible("La Plata","Villa Elisa",301);
		    while(!caminoCorto.fin()) {
		    	System.out.println(caminoCorto.proximo()+" ");
		    }
	}
}