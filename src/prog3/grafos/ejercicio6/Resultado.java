package prog3.grafos.ejercicio6;
import prog3.listagenerica.*;

public class Resultado {
	private int peso;
	private ListaGenerica<Integer> camino;
	private int cargas;
	
	public Resultado() {
		peso = 0;
		camino = new ListaGenericaEnlazada<Integer>();
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public ListaGenerica<Integer> getCamino() {
		return camino;
	}
	public void setCamino(ListaGenerica<Integer> camino) {
		this.camino = camino;
	}
	public void setCargar(int cargas) {
		this.cargas = cargas;
	}
	public int getCargas() {
		return this.cargas;
	}
	
}
