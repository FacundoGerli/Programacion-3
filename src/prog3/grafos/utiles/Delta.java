package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class Delta {

	public int maxIslasDistintas(Grafo<String> grafo) {
		int distintas = 0;
		if((grafo == null)||(grafo.esVacio())) return 0;
		boolean[] visitadas = new boolean[grafo.listaDeVertices().tamanio()];
		distintas=dfsIslas(visitadas,grafo.listaDeVertices().elemento(0),grafo,0,grafo.listaDeVertices().elemento(0));
		return distintas;
	}
	private int dfsIslas(boolean[] visitadas,Vertice<String> vActual,Grafo<String> grafo,int distintas,Vertice<String> principal) {
		int cant = 1;
		visitadas[vActual.posicion()] = true;
		
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vActual);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> arista = ady.proximo();
			if((!visitadas[arista.verticeDestino().posicion()])&&(!arista.verticeDestino().equals(principal))) {
				cant += dfsIslas(visitadas,vActual,grafo,distintas,principal);
			}
		}
		return cant;
	}
}
