package prog3.grafos.utiles;
import java.lang.reflect.Array;

import prog3.grafos.*;
import prog3.listagenerica.*;
public class Algoritmos<T> {
	public boolean subgrafoCuadrado(Grafo<T> grafo) {
		
		boolean ciclo = false;
		
		if((grafo == null)||(grafo.esVacio())) return false;
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		vertices.comenzar();
		while((!vertices.fin())&&(!ciclo)){
			boolean[] visitados = new boolean[vertices.tamanio()];
			Vertice<T> vActual  = vertices.proximo();
			ciclo = dfsSubgrafo(grafo,visitados,4,vActual,vActual.posicion());
		}
		return ciclo;
	}
	private boolean dfsSubgrafo(Grafo<T> grafo,boolean[]visitados,int porRecorrer,Vertice<T> vActual,int origen) {
		porRecorrer--;
		boolean ciclo = false;
		visitados[vActual.posicion()] = true;
		
		if(porRecorrer>= 0) {
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vActual);
			ady.comenzar();
			
			while((!ady.fin()) &&(!ciclo)){
				Vertice<T> vSiguiente = ady.proximo().verticeDestino();
				if((porRecorrer == 0)&&(vSiguiente.posicion() == origen)) {
					ciclo = true;
				}else if(!visitados[vSiguiente.posicion()]) {
					ciclo =dfsSubgrafo(grafo,visitados,porRecorrer,vSiguiente,origen);
				}
			}
			
		}
		porRecorrer++;
		visitados[vActual.posicion()] = false;
		return ciclo;
	}
	public int getGrado(Grafo<T> grafo) {
		if((grafo == null) || (grafo.esVacio()))return 0;
		int grado = -1;
		int[] grados = new int[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> vertices  =  grafo.listaDeVertices();
		vertices.comenzar();
		
		while(!vertices.fin()) {
			Vertice<T> actual = vertices.proximo();
			grados[actual.posicion()] += grafo.listaDeAdyacentes(actual).tamanio();
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while(!ady.fin()) {
				grados[ady.proximo().verticeDestino().posicion()]+= 1;
			}
			}
		for(int i =0;i<grados.length;i++) {
			if(grados[i]>grado) grado = grados[i];
		}
		return grado;
	}
	public boolean tieneCiclo(Grafo<T> grafo) {
		boolean ciclo = false;
		if ((grafo!=null)&&(!grafo.esVacio())) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();

			while (!listaDeVertices.fin()) {
				Vertice<T> vInicial = listaDeVertices.proximo();
				if (!visitados[vInicial.posicion()]) {
					ciclo = dfsCiclo(vInicial, visitados, grafo,ciclo);
				}
			}
		}
		return ciclo;
	}
	private boolean dfsCiclo(Vertice<T> vActual, boolean[] visitados, Grafo<T> grafo,boolean ciclo) {
		visitados[vActual.posicion()] = true;
	//	System.out.println(vActual.dato());
		ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
		listaDeAdyacentes.comenzar();
		while ((!listaDeAdyacentes.fin())&&(!ciclo)) {
			Vertice<T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();
			if (!visitados[vSiguiente.posicion()]) {
				ciclo = dfsCiclo(vSiguiente, visitados, grafo,ciclo);
			}
			else ciclo = true;
		}
		return ciclo;
	}
}
