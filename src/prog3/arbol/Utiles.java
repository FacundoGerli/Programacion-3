package prog3.arbol;
import prog3.util.*;
import prog3.listaenteros.*;

public class Utiles<T> {
	public int sumaMaximaHorizontal(ArbolBinario<T> a) {
		int maximo = -9999;
		int sumaActual=0;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		ArbolBinario<T> arbol = new ArbolBinario<T>();
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacio()){ 
			arbol = cola.desencolar();
			if(arbol != null) {
				sumaActual+=(int)arbol.getDato();
				if(arbol.tieneHijoIzquierdo())cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho()) cola.encolar(arbol.getHijoDerecho());
			}
			else {
				if(! cola.esVacio()) {
					if(sumaActual >maximo) maximo = sumaActual;
					sumaActual=0;
					cola.encolar(null);		
				}
			}
		}
		if(sumaActual >maximo) maximo = sumaActual;                                                                                                                     
		return 0;
	}
	private void analizarArbol(ArbolBinario<Integer> arbol,ListaDeEnterosEnlazada resultado,int nivel,int suma) {
		if(arbol==null)return;
		suma+=arbol.getDato()*nivel;
		if(arbol.esHoja()) {
			resultado.agregarFinal(suma);
		}
		else {
			if(arbol.tieneHijoIzquierdo())analizarArbol(arbol.getHijoIzquierdo(),resultado,nivel +1,suma);
			if(arbol.tieneHijoDerecho())analizarArbol(arbol.getHijoDerecho(),resultado,nivel +1,suma);
		}
	}
	public ListaDeEnterosEnlazada trayectoriaPesada(ArbolBinario<Integer> arbol) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		analizarArbol(arbol,l,0,0);
		return l;
	}
	private void recorrerArbol(ArbolBinario<Integer>arbol,ListaDeEnterosEnlazada maximo,int suma) {
		if(arbol==null)return;
		suma+= arbol.getDato();
		if(arbol.esHoja()) {
			if(suma> (int)maximo.elemento(0)) {
				maximo.eliminarEn(0);
				maximo.agregarEn(suma, 0);
			}
		}else {
				if(arbol.tieneHijoIzquierdo())recorrerArbol(arbol.getHijoIzquierdo(),maximo,suma);
				if(arbol.tieneHijoDerecho())recorrerArbol(arbol.getHijoDerecho(),maximo,suma);
			}
		}
	public int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
	    ListaDeEnterosEnlazada maximo = new ListaDeEnterosEnlazada();
	    maximo.agregarEn(Integer.MIN_VALUE, 0); // Inicializar con un valor mínimo
	    recorrerArbol(arbol, maximo, 0);
	    
	    if (maximo.esVacia()) {
	        return 0; // Devolver valor predeterminado si no se encontraron elementos en el árbol
	    } else {
	        return maximo.elemento(0);
	    }
	}
}