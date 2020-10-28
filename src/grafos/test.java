package grafos;

public class test {

	public static void main(String[] args) {
		GrafoConPeso grafo2 = new GrafoConPeso(5);
		grafo2.agregarArista(0, 1, 6);
		grafo2.agregarArista(0, 2, 1);//primero
		grafo2.agregarArista(1, 3, 2);//segundo
		grafo2.agregarArista(1, 4, 4);
		grafo2.agregarArista(3, 4, 3);//tercero
		grafo2.agregarArista(2, 4, 5);
		GrafoConPeso mst = grafo2.mst();
		mst.eliminarAristaMax();
		System.out.println(mst.aristas());
	}

}
