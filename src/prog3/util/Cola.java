package prog3.util;
import prog3.listagenerica.*;
public class Cola<T> {
	private ListaGenericaEnlazada<T> datos = new ListaGenericaEnlazada<T>();
	private int cantidadElementos;
	public Cola(){
		datos.comenzar();
	}

	public void  encolar(T elem) {
		cantidadElementos++;
		datos.agregarInicio(elem);
	}
	public T desencolar() {
		cantidadElementos--;
		T elemento;
		elemento = datos.elemento(datos.tamanio()-1);
		datos.eliminarEn(datos.tamanio()-1);
		return elemento;
	}
	public T tope() {
		return datos.elemento(datos.tamanio()-1);
	}
	public boolean esVacio() {
		if(cantidadElementos==0)return true; else return false;
	}

}
