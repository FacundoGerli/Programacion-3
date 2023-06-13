package prog3.arbol;

import prog3.listagenerica.*;
import prog3.util.*;
public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> arbol = new ArbolBinario<T>();
		int nivel = 1;
		int cant_nodos = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				cant_nodos ++;
				if(arbol.tieneHijoIzquierdo())cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho()) cola.encolar(arbol.getHijoDerecho());
			}
			else {
				if(! cola.esVacio()) {
					nivel++;
					cola.encolar(null);
					System.out.println();
				}
			}
		
	}
		if((cant_nodos == (Math.pow(2, nivel))-1))return true;
		else return false;
	}

	 boolean esCompleto() {
		return false;
	}

	// imprime el arbol en preorden  
	public void printPreorden() {
		System.out.print(this.getDato()+"-");
		if(this.tieneHijoIzquierdo()) this.getHijoIzquierdo().printPreorden();
		if(this.tieneHijoDerecho()) this.getHijoDerecho().printPreorden();
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if(this.tieneHijoIzquierdo())this.getHijoIzquierdo().printInorden();
		System.out.print(this.getDato()+"-");
		if(this.tieneHijoDerecho())this.getHijoDerecho().printInorden();
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if(this.tieneHijoIzquierdo())this.getHijoIzquierdo().printPostorden();
		if(this.tieneHijoDerecho())this.getHijoDerecho().printPostorden();
		System.out.print(this.getDato()+"-");
	}


	public void recorridoPorNiveles() {
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> arbol = new ArbolBinario<T>();
		int nivel = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacio()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				System.out.print(" "+arbol.getDato()+" ");
				if(arbol.tieneHijoIzquierdo())cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho()) cola.encolar(arbol.getHijoDerecho());
			}
			else {
				if(! cola.esVacio()) {
					nivel++;
					cola.encolar(null);
					System.out.println();
				}
			}
		}
	}

	private void recorrerArbol(ListaGenericaEnlazada<T> l,ArbolBinario<T> arbol) {
		if(arbol.esHoja()) {
			l.agregarFinal(arbol.getDato());
		}
		else {
			if(arbol.tieneHijoIzquierdo())recorrerArbol(l,arbol.getHijoIzquierdo());
			if(arbol.tieneHijoDerecho())recorrerArbol(l,arbol.getHijoDerecho());
		}
		
	}

	public ListaGenericaEnlazada<T> frontera() {
		ListaGenericaEnlazada<T> l = new ListaGenericaEnlazada<T>();
		l.comenzar();
		recorrerArbol(l,this);
		return l;
	}

	
	
	
	public int contarHojas() {
		int cant_hojas = 0;
		if(this.esHoja()) {
			return 1;
		}
		else {
			if(this.tieneHijoIzquierdo()) cant_hojas += this.getHijoIzquierdo().contarHojas();
			if(this.tieneHijoDerecho()) cant_hojas += this.getHijoDerecho().contarHojas();
			return cant_hojas;
		}
	}
}
