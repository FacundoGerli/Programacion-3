package prog3.practica5;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Aluar {

	public static void main(String[] args) {
		Empresa presidente = new Empresa();
		
		//Nivel 1//
		
		Empresa gerente = new Empresa();
		Empresa gerente2 = new Empresa();
		Empresa gerente3 = new Empresa();
		ListaGenericaEnlazada<ArbolGeneral<Empresa>> p_hijos = new ListaGenericaEnlazada<ArbolGeneral<Empresa>>();
		p_hijos.agregarFinal(gerente);
		p_hijos.agregarFinal(gerente2);
		p_hijos.agregarFinal(gerente3);
		
		//Nivel2
	}

}
