package prog3.arbol;
import prog3.listaenteros.*;
public class TestArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		
		arbolBinarioB.recorridoPorNiveles();
		Utiles<Integer> util = new Utiles<Integer>();
		System.out.println();
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		lista = util.trayectoriaPesada(arbolBinarioB);
		lista.imprimirLista();
		System.out.println("La suma vertical maxima fue de "+ util.sumaMaximaVertical(arbolBinarioB));
}	}

