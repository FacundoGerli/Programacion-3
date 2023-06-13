package prog3.arbolgeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.*;
public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public ArbolGeneral() {
		
	}
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		int nivel=0;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()) {
			arbol=cola.desencolar();
			if(arbol!=null) {
				if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos=arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin())
					cola.encolar(hijos.proximo());
					}
					
				}
			else {
				if(!cola.esVacio()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		
		return nivel;
	}

	public Integer nivel(T dato) {
		int nivel=0;
		boolean encontro = false;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()&& (!encontro)) {
			arbol=cola.desencolar();
			if(arbol!=null) {
				if(arbol.getDato()==dato)encontro=true;
				if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos=arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin())
					cola.encolar(hijos.proximo());
					}
					
				}
			else {
				if(!cola.esVacio()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		
		return nivel;
	}

	public Integer ancho() {
		int ancho=0;
		int max=-999;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()) {
			arbol=cola.desencolar();
			if(arbol!=null) {
				ancho++;
				if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos=arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin())
					cola.encolar(hijos.proximo());
					}
					
				}
			else {
				if(!cola.esVacio()) {
					if(max<ancho)max=ancho;
					ancho=0;
					cola.encolar(null);
				}
			}
		}
		
		return max;
	}
	public boolean include(T elem) {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol;
		boolean encontro=false;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()&& (!encontro)) {
			arbol=cola.desencolar();
			if(arbol!=null) {
				if(arbol.getDato()==elem)encontro=true;
				if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos=arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin())
					cola.encolar(hijos.proximo());
					}
					
				}
			else {
				if(!cola.esVacio()) {
					cola.encolar(null);
				}
			}
		}
		
		return encontro;
	}

}