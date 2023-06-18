package dis.prob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Huffman {
	
	static List<Rama> calculoHuffman (List<Proba> listaSeniales){
	List<Rama> hojas = pasarDeListaProbaAHoja(listaSeniales);
	List<Rama> arbol = new ArrayList<>(hojas);
	while (arbol.size() > 1) {
		Rama r1 = arbol.get(0);
		Rama r2 = arbol.get(1);
		Rama r = new Rama(r1, r2);
		arbol.remove(r1);
		arbol.remove(r2);
		arbol.add( r);
	}
	arbol.get(0).calculoBits("");
	//System.out.println(hojas.get(0).getBits());
	return hojas;
	
}

	private static List<Rama> pasarDeListaProbaAHoja (List<Proba> listaSeniales){ // convierte la lista proba a una de hojas
		List<Rama> hojas = new ArrayList<>();
		for (int i =0; i < listaSeniales.size(); i++) { // crea hojas y las pone en la lista
			Rama h = new Rama(null, null);
			h.setProb(listaSeniales.get(i).getProb());
			h.setSenial(listaSeniales.get(i).getSenial());
			h.setOcurrencia(listaSeniales.get(i).getExitos());
			hojas.add(h);
		}
		Collections.sort(hojas);
		return hojas;
	}
	
}

