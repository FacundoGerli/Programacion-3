package prog3.grafos.utiles;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class TestParcial {
        public static void main(String[] args) {
        	
        Grafo<String> grafo = new GrafoImplListAdy<String>();
        VerticeImplListAdy<String> buzet = new VerticeImplListAdy<String>("Buzet");
        VerticeImplListAdy<String> champagne = new VerticeImplListAdy<String>("Champagne");
        VerticeImplListAdy<String> cahors = new VerticeImplListAdy<String>("Cahors");
        VerticeImplListAdy<String> bellet = new VerticeImplListAdy<String>("Bellet");
        VerticeImplListAdy<String> beaujolais = new VerticeImplListAdy<String>("Beaujolais");
        VerticeImplListAdy<String> armagnac = new VerticeImplListAdy<String>("Armagnac");
        VerticeImplListAdy<String> bugey = new VerticeImplListAdy<String>("Bugey");
        VerticeImplListAdy<String> chabils = new VerticeImplListAdy<String>("Chabils");
        
        grafo.conectar(buzet, champagne, 2);
        grafo.conectar(champagne, cahors, 10);
        grafo.conectar(cahors, bellet, 3);
        grafo.conectar(bellet, beaujolais, 5);
        grafo.conectar(beaujolais, armagnac, 0);
        grafo.conectar(cahors, beaujolais, 1);
        grafo.conectar(cahors, chabils, 30);
        grafo.conectar(chabils, bugey, 3);
   
        grafo.conectar(chabils, bugey, 3);
        grafo.conectar(bugey, armagnac, 3);
        
        grafo.agregarVertice(buzet);
        grafo.agregarVertice(champagne);
        grafo.agregarVertice(cahors);
        grafo.agregarVertice(bellet);
        grafo.agregarVertice(beaujolais);
        grafo.agregarVertice(armagnac);
        grafo.agregarVertice(bugey);
        grafo.agregarVertice(chabils);
        
     
        ParcialFecha1 r = new ParcialFecha1();
        ListaGenerica<ListaGenerica<String>> caminos = r.resolverParcial(grafo,"Buzet","Beaujolais",20);
        caminos.comenzar();
        int i= 1;
        while(!caminos.fin()) {
        	System.out.println("Camino numero "+i);
        	i++;
        	ListaGenerica<String> camino = caminos.proximo();
        	camino.imprimir();
        }
        
    }

}