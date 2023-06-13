package prog3.grafos.utiles;
import prog3.listagenerica.*;
import prog3.grafos.*;
public class ParcialFecha1 {
	public ListaGenerica<ListaGenerica<String>> resolverParcial(Grafo<String> ciudades,String origen,String destino,int maxKilometros){
		ListaGenerica<ListaGenerica<String>> caminos = new ListaGenericaEnlazada<ListaGenerica<String>>();
		if((ciudades == null)||(ciudades.esVacio()))return caminos;
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
		//busco el origen
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		Vertice<String> vInicial = vertices.proximo();
		while((!vertices.fin())&&(!vInicial.dato().equals(origen))) {
			vInicial = vertices.proximo();
		}

		vertices.comenzar();
		Vertice<String> vDestino = vertices.proximo();
		while((!vertices.fin())&&(!vDestino.dato().equals(destino))) {
			vDestino = vertices.proximo();
		}
		if((vInicial.dato().equals(origen))&&(vDestino.dato().equals(destino))) {
			ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
			dfsParcial(visitados,vInicial,destino,camino,ciudades,caminos,maxKilometros);
		}
		return caminos;
	}
	private void dfsParcial(boolean[] visitados,Vertice<String> vActual, String destino, ListaGenerica<String> camino,Grafo<String> ciudades,ListaGenerica<ListaGenerica<String>> caminos,int maxKilometros) {
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato());
		
		if(vActual.dato().equals(destino)) {
			caminos.agregarFinal(camino.clonar());
		}
		else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vActual);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				Vertice<String> vSiguente = arista.verticeDestino();
				System.out.println(arista.peso()+"<"+maxKilometros);
				if((arista.peso()<=maxKilometros)&&(!visitados[vSiguente.posicion()])) {
					dfsParcial(visitados,vSiguente,destino,camino,ciudades,caminos,maxKilometros-arista.peso());
				}
			}
		}
		visitados[vActual.posicion()] = false;
		camino.eliminarEn(camino.tamanio()-1);
	}
}
