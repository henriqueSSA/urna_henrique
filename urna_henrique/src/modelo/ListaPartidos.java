package modelo;

import java.util.ArrayList;

public class ListaPartidos {
	public static ArrayList<Partido> partidos = new ArrayList<Partido>();
	
	public static void adicionarPartidos(Partido partido) {
		partidos.add(partido);
	}
}
