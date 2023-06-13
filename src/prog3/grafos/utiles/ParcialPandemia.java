package prog3.grafos.utiles;
import prog3.listagenerica.*;
import prog3.grafos.*;

public class ParcialPandemia {
	public ListaGenerica<String> resolver(Grafo<C> ciudades, String origen, String destino, int minFase){
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
		boolean existeDestino = false;
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<C>> listaVertices = ciudades.listaDeVertices();
		listaVertices.comenzar();
	    Vertice<C> vInicial = listaVertices.proximo();
	    while((!listaVertices.fin())&&(!vInicial.dato().getNombre().equals(origen))){
	    	vInicial = listaVertices.proximo();
	    }
	    
		listaVertices.comenzar();
		while((!listaVertices.fin())&&(listaVertices.proximo().dato().getNombre().equals(destino))){
		}
		
		existeDestino = (listaVertices.fin())? false: true;
		if((vInicial.dato().getNombre().equals(origen))&&(existeDestino)) {
			System.out.println("entro");
			dfsParcial(visitados,ciudades,vInicial,destino,minFase,camino);
		}
		return camino;
	}
	
	private void dfsParcial(boolean[] visitados,Grafo<C> ciudades,Vertice<C> vActual,String destino,int minFase, ListaGenerica<String> camino) {
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato().getNombre());
		if(!vActual.dato().getNombre().equals(destino)) {
			ListaGenerica<Arista<C>> ady = ciudades.listaDeAdyacentes(vActual);
			ady.comenzar();
			
			while(!ady.fin()) {
				Arista<C> arista = ady.proximo();
				System.out.println(arista.verticeDestino().dato().getFase() +">"+ minFase);

				if((arista.peso()==1)&&(arista.verticeDestino().dato().getFase()>minFase) && !camino.elemento(camino.tamanio() - 1).equals(destino)){
					Vertice<C> vSiguiente = arista.verticeDestino();

					if(!visitados[vSiguiente.posicion()]) {
						dfsParcial(visitados,ciudades,vSiguiente,destino,minFase,camino);
					}
				}
			}
		}
		if(!camino.elemento(camino.tamanio()-1).equals(destino)) {
			camino.eliminarEn(camino.tamanio()-1);
		}
		visitados[vActual.posicion()] = false;
	}
}
