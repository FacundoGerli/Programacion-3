package prog3.grafos.ejercicio6;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa() {
		mapaCiudades = new GrafoImplListAdy<String>();
		System.out.println("----------------- Mapa creado --------------");
	}


	public Grafo<String> getMapaCiudades() {
		return mapaCiudades;
	}

	public void setMapaCiudades(Grafo<String> mapaciudades) {
		this.mapaCiudades = mapaciudades;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1,String ciudad2) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		if((mapaCiudades != null)&&(!mapaCiudades.esVacio())) {
		
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
		Vertice<String> vInicial = mapaCiudades.listaDeVertices().elemento(0);
		
		ciudades.comenzar();
		while (!ciudades.fin() && !vInicial.dato().equals(ciudad1)) {
			vInicial = ciudades.proximo();
		}
		
		if(vInicial.dato().equals(ciudad1)) {
			devolverCamino(camino,vInicial,ciudad2,visitados);
		}
		}
		return camino;
	}
	private void devolverCamino(ListaGenerica<String> camino,Vertice<String> vActual,String ciudad2,boolean[] visitados) {
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato());
		
		if(!vActual.dato().equals(ciudad2)) {
		ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vActual);
		ady.comenzar();
		while(!ady.fin()) {
			Vertice<String> vSiguiente = ady.proximo().verticeDestino();
			if(!visitados[vSiguiente.posicion()]) {
				devolverCamino(camino,vSiguiente,ciudad2,visitados);
			}
			if ( !camino.elemento(camino.tamanio() - 1).equals(ciudad2)) {
				camino.eliminarEn(camino.tamanio() -1);
			}
			
		}
	}
	}
	public ListaGenerica<String> caminoExceptuando(String ciudad1,String ciudad2, ListaGenerica<String> ciudadesExceptuadas){
		ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();

		if (mapaCiudades != null && !mapaCiudades.esVacio()) {
			boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
			// marco ciudades exceptuadas como visitadas
			ciudadesExceptuadas.comenzar();

			while (!ciudadesExceptuadas.fin()) { // recorro lista de ciudades visitadas
				String ciudad = ciudadesExceptuadas.proximo();
				ListaGenerica<Vertice<String>> listaDeVertices = mapaCiudades.listaDeVertices();
				listaDeVertices.comenzar();
				Vertice<String> vInicial = listaDeVertices.proximo();

				while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad)) {
					vInicial = listaDeVertices.proximo();
				}

				if (vInicial.dato().equals(ciudad)) { // si encontre la ciudad la marco como visitada
					visitados[vInicial.posicion()] = true;
				}
			}

			ListaGenerica<Vertice<String>> listaDeVertices = mapaCiudades.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				devolverCamino(resultado,vInicial,ciudad2,visitados);
			}
		}

		return resultado;
	}
	public ListaGenerica<String> caminoMasCorto(String ciudad1,String ciudad2){
		Resultado resultado  = new Resultado();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		
		if((mapaCiudades != null)&&(!mapaCiudades.esVacio())) {
		
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
		Vertice<String> vInicial = mapaCiudades.listaDeVertices().elemento(0);
		
		ciudades.comenzar();
		while (!ciudades.fin() && !vInicial.dato().equals(ciudad1)) {
			vInicial = ciudades.proximo();
		}
		
		if(vInicial.dato().equals(ciudad1)) {
			dfsCorto(camino,vInicial,ciudad2,visitados,0,resultado);
		}
		}
		return resultado.getCamino();
	}
	private void dfsCorto(ListaGenerica<String> camino,Vertice<String> vActual,String ciudad2,boolean[]visitados,int peso,Resultado resultado) {
		
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato());
		
		if(!vActual.dato().equals(ciudad2)) { // si no encontro sigo buscando
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vActual);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista =  ady.proximo();
				Vertice<String> v = arista.verticeDestino();
				if(!visitados[v.posicion()]) {
					dfsCorto(camino,v,ciudad2,visitados,peso+arista.peso(),resultado);
				}
				
			}
		}else	if(resultado.getPeso()>peso) { // si llego a destino comparo
				resultado.setCamino(camino.clonar());
				resultado.setPeso(peso);
			
		}
		
		camino.eliminarEn(camino.tamanio()-1);
		visitados[vActual.posicion()] = false;
	}
	public ListaGenerica<String> caminoSinCargarCombustible(String origen, String destino, int combustible){
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		if((mapaCiudades != null)&&(!mapaCiudades.esVacio())) {
		
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
		Vertice<String> vInicial = mapaCiudades.listaDeVertices().elemento(0);
		
		ciudades.comenzar();
		while (!ciudades.fin() && !vInicial.dato().equals(origen)) {
			vInicial = ciudades.proximo();
		}
		
		if(vInicial.dato().equals(origen)) {
			dfsSinCargar(camino,vInicial,destino,visitados,combustible,0);
		}
		}
		return camino;
	}
	
	private void dfsSinCargar(ListaGenerica<String> camino,Vertice<String>vActual,String destino,boolean[] visitados,int combustible,int kmRecorridos) {
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato());
		if(!vActual.dato().equals(destino)) {//si no es sigo buscando
			ListaGenerica<Arista<String>> aristas = mapaCiudades.listaDeAdyacentes(vActual);
			aristas.comenzar();
			while(!aristas.fin()) {
				Arista<String> arista = aristas.proximo();
				Vertice<String> ciudadSiguente = arista.verticeDestino();
				if((!visitados[ciudadSiguente.posicion()])&&((kmRecorridos+arista.peso())<=combustible)) {
					dfsSinCargar(camino,ciudadSiguente,destino,visitados,combustible,kmRecorridos+arista.peso());
				}
			}
		}
		if(!camino.elemento(camino.tamanio()-1).equals(destino)) {
			camino.eliminarEn(camino.tamanio()-1);
			visitados[vActual.posicion()] = false;
		}
	}
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String origen,String destino,int tanqueAuto){
		Resultado resultado  = new Resultado();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		
		if((mapaCiudades != null)&&(!mapaCiudades.esVacio())) {
		
		boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
		Vertice<String> vInicial = mapaCiudades.listaDeVertices().elemento(0);
		
		ciudades.comenzar();
		while (!ciudades.fin() && !vInicial.dato().equals(origen)) {
			vInicial = ciudades.proximo();
		}
		
		if(vInicial.dato().equals(origen)) {
			dfsCaminoMenorCargas(camino,vInicial,destino,visitados,tanqueAuto,0,0,resultado);
		}
		}
		return resultado.getCamino();
	}
	private void dfsCaminoMenorCargas(ListaGenerica<String> camino, Vertice<String> vActual, String destino,boolean[] visitados,int tanqueAuto,int recargas,int kmRecorridos,Resultado resultado) {
		visitados[vActual.posicion()] = true;
		camino.agregarFinal(vActual.dato());
		if(!vActual.dato().equals(destino)) {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vActual);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				Vertice<String> siguienteCiudad = arista.verticeDestino();
				int increment = 0;
				if(tanqueAuto-arista.peso()<=0) {
					tanqueAuto += kmRecorridos;
					kmRecorridos = 0;
					increment++;
				}
				if(!visitados[siguienteCiudad.posicion()]) {
					dfsCaminoMenorCargas(camino,siguienteCiudad,destino,visitados,tanqueAuto-arista.peso(),recargas+increment,kmRecorridos+arista.peso(),resultado);
				}
				
			}
		}else if(recargas<resultado.getCargas()) {
			resultado.setCargar(recargas);
			resultado.setCamino(camino.clonar());
		}
		camino.eliminarEn(camino.tamanio()-1);
		visitados[vActual.posicion()] = false;
		
	}
}
