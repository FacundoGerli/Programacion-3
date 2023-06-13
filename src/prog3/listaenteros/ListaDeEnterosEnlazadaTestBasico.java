package prog3.listaenteros;

import prog3.listagenerica.ListaGenericaEnlazada;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada ordenada = new ListaDeEnterosEnlazada();
		l.agregarInicio(3);l.agregarInicio(4);
		l.agregarInicio(5);l.agregarFinal(2323);l.agregarInicio(232);
		l.ordenar();
		
		ListaDeEnterosEnlazada n = new ListaDeEnterosEnlazada();
		n.agregarInicio(2);
		n.agregarInicio(20);
		n.agregarInicio(3);
		n.agregarInicio(4);
		n.ordenar();
		
		n.imprimirLista();
		l.imprimirLista();
		
		n= l.combinarOrdenado(n);
		n.imprimirLista();
	}

}
