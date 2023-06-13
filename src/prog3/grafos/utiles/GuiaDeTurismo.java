package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.grafos.ejercicio6.Resultado;
public class GuiaDeTurismo {
	public ListaGenerica<Integer> caminoConMenorNrodeViajes(Grafo<Integer> grafo, Integer origen, Integer destino){
		ListaGenerica<Integer> camino = new ListaGenericaEnlazada<>();
		if((grafo == null)||(grafo.esVacio())) return camino;
		Resultado resultado = new Resultado();
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
		//buscar vertice origen;
		ListaGenerica<Vertice<Integer>> listaVertices = grafo.listaDeVertices();
		listaVertices.comenzar();
		Vertice<Integer> vInicial = listaVertices.proximo();
		while((!listaVertices.fin())&&(!vInicial.dato().equals(origen))) {
			vInicial = listaVertices.proximo();
			}
		
		if(vInicial.dato().equals(origen)) { //si encontro el origen
			dfsTurismo(camino,resultado,vInicial,400,visitados,destino,grafo);
		}
	
		return resultado.getCamino();
	}
	private void dfsTurismo(ListaGenerica<Integer> camino, Resultado resultado,Vertice<Integer> vActual,int cuelloBotella,boolean[] visitados, Integer destino, Grafo<Integer> grafo) {
		camino.agregarFinal(vActual.dato());
		visitados[vActual.posicion()] = true;
		
		if(vActual.dato().equals(destino)) { //encontro destino
			if(cuelloBotella>resultado.getPeso()) {
				resultado.setPeso(cuelloBotella);
				resultado.setCamino(camino.clonar());
			}
		}else { // si no es el destino sigo buscando
			ListaGenerica<Arista<Integer>> ady = grafo.listaDeAdyacentes(vActual);
			ady.comenzar();
			int aux;
			while(!ady.fin()) {
				Arista<Integer> arista = ady.proximo();
				Vertice<Integer> vSiguente = arista.verticeDestino();
				aux = (arista.peso()<cuelloBotella)? arista.peso(): cuelloBotella;
				if(!visitados[vSiguente.posicion()]) {
					dfsTurismo(camino,resultado,vSiguente,aux,visitados,destino,grafo);
				}
			
		}
		
	}
		camino.eliminarEn(camino.tamanio()-1);
		visitados[vActual.posicion()] = false;
}
}