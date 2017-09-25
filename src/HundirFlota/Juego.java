package HundirFlota;
/*
 * Clase encargada de realizar todas las operaciones del juego. Utiliza la clase Tablero para mostrar de manera visual las posiciones y mandarla a la clase principal
 * 
 * @author Bryan Jesús Romero Santos
 * @version 1.2
 * 
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;


import java.util.Random;

public class Juego {
	Tablero j = new Tablero(); // Objeto de la clase tablero
	ArrayList<String> informe = new ArrayList<String>(); // Array principal
	ArrayList<String> ch = new ArrayList<String>(); // Array utilizado para comprobar la existencia de coordenadas dichas por el usuario para no ser repetidas
	int contador, ronda; // Utilizados para salidas del programa
	String barco1, barco2, barco3; // Barcos que se generan el el tablero de forma aleatoria
	int x, y;
	int barcos; // Coordenadas del usuario 

	/*
	 * Metodo que asigna de manera aletatoria la posicion de los 3 barcos. Cuenta con dos estructuras repetitivas que permite que si se generan dos barcos en misma posicion
	 * se recargen el ultimo barco asignado
	 * 
	 * @param r Permite generar numero aleatorios, en este caso del 1 al 6, para posteriormente guardarlos en las variables correspondientes a los barcos 
	 */
	public void ubicacion(){
		Random r = new Random();
		
		int x1 = r.nextInt(6);
		int y1 = r.nextInt(6);
		barco1 = j.tablero[x1][y1];
		
		do{
			int x2 = r.nextInt(6);
			int y2 = r.nextInt(6);
			barco2 = j.tablero[x2][y2];
			
			
		} while (barco1.equals(barco2));
		
		
		do {
			
			int x3 = r.nextInt(6);
			int y3 = r.nextInt(6);
			
			barco3 = j.tablero[x3][y3];	
		} while(barco1.equals(barco3) || barco2.equals(barco3));
	}
	
	/*
	 * Metodo encargado de comprobar que el usuario acierta en un barco. 
	 * 
	 *  @return Si acierta algun barco mostrara "Tocado", si por el contrario falla, muestra "Agua"
	 */
	public String comprueba(){	
		if (barco1.equals(this.coordenadas()) ||
				barco2.equals(this.coordenadas()) ||
					barco3.equals(this.coordenadas())){
			return "Tocado";
			}
		else
			return "Agua";
	}
	
	/*
	 * Metodo auxiliar del anterior. Permite establecer las coordenadas que el jugador ha establecido en un String, para mas tarde compararlo
	 * 
	 * @param coordenadas Guarda la cadena de caracteres de las coordenas introducidas por el usuario
	 * @return Devuelve el String de coordenadas
	 */
	private String coordenadas(){
		String coordenadas = j.tablero[this.getX()][this.getY()];
		return coordenadas;
	}
	
	/*
	 * Metodo encargado de guardar la informacion de los tiros realizados por el usuario. Tambien incrementa un contador si acierta un tiro
	 * 
	 * @param cadena Almacena un String con las coordenadas y la accion del tiro
	 */
	public void historial(){
		String cadena = j.tablero[this.getX()][this.getY()]+": "+this.comprueba();
		informe.add(cadena);
		if (this.comprueba().equals("Tocado")) contador++;
	}
	
	/*
	 * Metodo que permite mostrar por pantalla el historial de coordenadas dichas por el usuario y su correspondiente ataque (si fue tocado o agua)
	 * 
	 * @return Resumen de la partida
	 * 
	 * @deprecated Obsoleto, se actualizo para que saliera por ventana
	 */
	public void verHistorial(){
		for (String inf : informe) {
			System.out.println(inf);
		}
	}
	
	/*
	 * Metodo para comprobar que no se repiten coordenadas. En caso de que no se repitan se guardaran en un array, si se repiten decrementa 1 ronda para que esta no cuenta
	 * y en caso de si es tocado nuevamente el barco, tambien lo decremente
	 * 
	 * @param cadena String que recoge la posicion de tablero dicha por el usuario para que la pueda comparar
	 */
	public String compruebaHistorial(){
		String cadena = j.tablero[this.getX()][this.getY()];
		if(!ch.contains(cadena)) {
						ch.add(cadena);
						return " ";
						}
		else {
			ronda--;
			if (this.comprueba().equals("Tocado")) {
				contador--;
				barcos--;

			}
			return "Coordenada ya dicha: ";

		}
	}
	
	/*
	 * Metodo que te muestra a traves de una ventana el informe de la partida
	 * 
	 * @param informe2 Es un Array que se utiliza de para poder operarlo con JOpcion y no altere nuestro array principal
	 * 
	 * @return Ventana con coordenadas y resultado del tiro del usuario, tras la partida
	 */
	public void ventana() {
		ArrayList<String> informe2 = new ArrayList<String>();
		for (String inf : informe) {
			  String returnValue ="\n"+inf.toString();
			  
			  informe2.add(returnValue);
		}
		if(contador==3) 
				JOptionPane.showMessageDialog(null, "Flota hundida. Has ganado\n"+informe2.toString().replace("[", " ").replace("]"," "), "Informe", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Flota NO hundida. Has perdido\n"+informe2.toString().replace("[", " ").replace("]"," "), "Informe", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/*
	 * Metodo getX
	 * @return Devuelve lo que contiene el parametro X
	 */
	public int getX() {
		return x;
	}

	/*
	 * Metodo setX  que obliga al usuario a decir un numero del 1 al 6
	 * Si acierta le quita 1 para que pueda ser buscado por el aray del tablero, si lo pone incorrecto devuelve -1 para salir del programa
	 */
	public void setX(int x) {
		if(x>0 && x<=6) 	
			this.x = x - 1;
		else {
			this.x = - 1;
			}
	}

	/*
	 * Metodo getY
	 * @return Devuelve lo que contiene el parametro y
	 */
	public int getY() {
		return y;
	}

	/*
	 *  Metodo setY que comprueba de que el usuario introdujo una letra valida y le asigna un numero para operar con el array del tablero
	 *  Si pone una letra valida se le asignara su valor, si la pone invalida devuelve -1 para salir del programa
	 */
	public void setY(String letra) {
		if (letra.toUpperCase().equals("A"))	
			this.y=0;
		else if (letra.toUpperCase().equals("B"))
				this.y=1;
			else if (letra.toUpperCase().equals("C")) 
					this.y=2;
				else if (letra.toUpperCase().equals("D"))
						this.y=3;
					else if (letra.toUpperCase().equals("E"))
							this.y=4;
					else if (letra.toUpperCase().equals("F"))
							this.y=5;
						else 
							this.y=-1;
	}
}
