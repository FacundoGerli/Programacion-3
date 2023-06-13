package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class TestParcia {

	public static void main(String[] args) {
		Grafo<C> grafo = new GrafoImplListAdy<C>();
		
		Vertice<C> suipacha = new VerticeImplListAdy<C>(new C("Suipacha", 5));
	    Vertice<C> carlosKeen = new VerticeImplListAdy<C>(new C("Carlos Keen", 3));
	    Vertice<C> moreno = new VerticeImplListAdy<C>(new C("Moreno", 2));
	    Vertice<C> quilmes = new VerticeImplListAdy<C>(new C("Quilmes", 2));
	    Vertice<C> abasto = new VerticeImplListAdy<C>(new C("Abasto", 2));
	    Vertice<C> laPlata = new VerticeImplListAdy<C>(new C("La Plata", 2));
	    Vertice<C> pinamar = new VerticeImplListAdy<C>(new C("Pinamar", 3));
	    Vertice<C> navarro = new VerticeImplListAdy<C>(new C("Navarro", 4));
	    Vertice<C> canuelas = new VerticeImplListAdy<C>(new C("Canuelas", 3));
	    Vertice<C> lobos = new VerticeImplListAdy<C>(new C("Lobos", 3));
	    Vertice<C> saladillo = new VerticeImplListAdy<C>(new C("Saladillo", 4));

	    // add vertices to graph /////////////////////////////////
	    grafo.agregarVertice(suipacha);
	    grafo.agregarVertice(carlosKeen);
	    grafo.agregarVertice(moreno);
	    grafo.agregarVertice(quilmes);
	    grafo.agregarVertice(abasto);
	    grafo.agregarVertice(laPlata);
	    grafo.agregarVertice(pinamar);
	    grafo.agregarVertice(navarro);
	    grafo.agregarVertice(canuelas);
	    grafo.agregarVertice(lobos);
	    grafo.agregarVertice(saladillo);

	    // add connections to graph /////////////////////////////////
	    grafo.conectar(suipacha, carlosKeen,1);
	    grafo.conectar(suipacha, navarro,1);
	    grafo.conectar(carlosKeen, moreno,1);
	    grafo.conectar(moreno, quilmes,1);
	    grafo.conectar(moreno, abasto,0);
	    grafo.conectar(quilmes, laPlata,1);
	    grafo.conectar(abasto, laPlata,1);
	    grafo.conectar(laPlata, pinamar,0);
	    grafo.conectar(navarro, canuelas,1);
	    grafo.conectar(navarro, lobos,0);
	    grafo.conectar(navarro, saladillo,1);
	    grafo.conectar(canuelas, abasto,1);

	    // make it a digraph /////////////////////////////////
	    grafo.conectar(carlosKeen, suipacha,1);
	    grafo.conectar(navarro, suipacha,1);
	    grafo.conectar(moreno, carlosKeen,1);
	    grafo.conectar(quilmes, moreno,1);
	    grafo.conectar(abasto, moreno,0);
	    grafo.conectar(laPlata, quilmes,1);
	    grafo.conectar(laPlata, abasto,1);
	    grafo.conectar(pinamar, laPlata,0);
	    grafo.conectar(canuelas, navarro,1);
	    grafo.conectar(lobos, navarro,0);
	    grafo.conectar(saladillo, navarro,1);
	    grafo.conectar(abasto, canuelas,1);
	    
	    ParcialPandemia p = new ParcialPandemia();
	    ListaGenerica<String> camino = p.resolver(grafo,"La Plata","Suipacha", 1);
	    camino.imprimir();
	    
	   
	}

}
