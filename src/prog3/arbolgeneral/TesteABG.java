package prog3.arbolgeneral;
import prog3.listagenerica.*;

public class TesteABG {

	public static void main(String[] args) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<>(1);

		// Nivel 1
		ArbolGeneral<Integer> hijo1 = new ArbolGeneral<>(2);
		ArbolGeneral<Integer> hijo2 = new ArbolGeneral<>(3);
		ArbolGeneral<Integer> hijo3 = new ArbolGeneral<>(4);
		arbol.agregarHijo(hijo1);
		arbol.agregarHijo(hijo2);
		arbol.agregarHijo(hijo3);

		// Nivel 2
		ArbolGeneral<Integer> nieto1 = new ArbolGeneral<>(5);
		ArbolGeneral<Integer> nieto2 = new ArbolGeneral<>(6);
		ArbolGeneral<Integer> nieto3 = new ArbolGeneral<>(7);
		hijo1.agregarHijo(nieto1);
		hijo1.agregarHijo(nieto2);
		hijo1.agregarHijo(nieto3);

		ArbolGeneral<Integer> nieto4 = new ArbolGeneral<>(8);
		ArbolGeneral<Integer> nieto5 = new ArbolGeneral<>(9);
		ArbolGeneral<Integer> nieto6 = new ArbolGeneral<>(10);
		hijo2.agregarHijo(nieto4);
		hijo2.agregarHijo(nieto5);
		hijo2.agregarHijo(nieto6);

		ArbolGeneral<Integer> nieto7 = new ArbolGeneral<>(11);
		ArbolGeneral<Integer> nieto8 = new ArbolGeneral<>(12);
		ArbolGeneral<Integer> nieto9 = new ArbolGeneral<>(13);
		hijo3.agregarHijo(nieto7);
		hijo3.agregarHijo(nieto8);
		hijo3.agregarHijo(nieto9);

		// Nivel 3
		ArbolGeneral<Integer> bisnieto1 = new ArbolGeneral<>(14);
		ArbolGeneral<Integer> bisnieto2 = new ArbolGeneral<>(15);
		ArbolGeneral<Integer> bisnieto3 = new ArbolGeneral<>(16);
		nieto1.agregarHijo(bisnieto1);
		nieto1.agregarHijo(bisnieto2);
		nieto1.agregarHijo(bisnieto3);

		ArbolGeneral<Integer> bisnieto4 = new ArbolGeneral<>(17);
		ArbolGeneral<Integer> bisnieto5 = new ArbolGeneral<>(18);
		ArbolGeneral<Integer> bisnieto6 = new ArbolGeneral<>(19);
		nieto2.agregarHijo(bisnieto4);
		nieto2.agregarHijo(bisnieto5);
		nieto2.agregarHijo(bisnieto6);

		ArbolGeneral<Integer> bisnieto7 = new ArbolGeneral<>(20);
		ArbolGeneral<Integer> bisnieto8 = new ArbolGeneral<>(21);
		ArbolGeneral<Integer> bisnieto9 = new ArbolGeneral<>(22);
		nieto3.agregarHijo(bisnieto7);
		nieto3.agregarHijo(bisnieto8);
		nieto3.agregarHijo(bisnieto9);

		System.out.println("Árbol creado exitosamente.");
		System.out.println("El arbol es de ancho"+arbol.ancho());
	}
	}

