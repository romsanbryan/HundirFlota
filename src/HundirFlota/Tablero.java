package HundirFlota;
/*
 * Es una clase basica, se utiliza para poder mostrar las posiciones dichas por el usuario de forma más visual. Es utilizada por la clase Juego
 * 
 * @author Bryan Jesús Romero Santos
 * @version 1.0 
 * 
 */

public class Tablero {
	String[][] tablero = { // Array del tablero de juego
		 	{"A1","B1","C1","D1","E1","F1"},
			{"A2","B2","C2","D2","E2","F2"},
			{"A3","B3","C3","D3","E3","F3"},
			{"A4","B4","C4","D4","E4","F4"},
			{"A5","B5","C5","D5","E5","F5"},
			{"A6","B6","C6","D6","E6","F6"}};
	
	
	/*
	 * Metodo que permite mostrar el tablero del juego (solo en modo texto)
	 * 
	 * @return tablero del juego
	 * 
	 * @deprecated Obsoleto
	 */
	public void mostrarTablero(){
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
}
