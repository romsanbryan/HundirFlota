package HundirFlota;
/*
 * Esta clase es la principal, se encarga de recoger datos del usuario y establecer un menu para que el usuario eliga si jugar o salir.
 * Cuenta con un contador para que solo permita 6 tiros y varias comprobaciones para saber la efectividad de los tiros.
 * Tambien cuenta con una salida del juego si se producen 3 aciertos (8,33% de acierto) o algun error en coordenas (insertar un valor "invalido").
 * 
 * @author Bryan Jesús Romero Santos
 * @version 1.0
 * 
 */

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		Juego b = new Juego();
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		String cadenaY;
		int numeroX;
  
		String instrucciones ="Hundir la flota:\n"
				+ " El juego consiste en destruir los barcos generados automáticamente.\n"
				+ "Si los consigues destruir los 3 barcos en 6 intentos habras ganado.\n"
				+ "Cada barco esta ubicado en una única celda y solo podra ser tocado (a diferencia del juego"
				+ "real que existe el hundido cuando se le toca varias veces el barco).\n"
				+ "Si das \"agua\" es un disparo fallado, si das \"tocado\", es diparo acertado.";
		JOptionPane.showMessageDialog(null, instrucciones.toString(), "Hundir la flota", JOptionPane.INFORMATION_MESSAGE);
		
		while (!salir) {
			String opcion = JOptionPane.showInputDialog (null, "1.- Jugar\n2.- Salir", "Hundir la flota. Menu", JOptionPane.INFORMATION_MESSAGE);

			if (opcion.equals("1")) {
		b.contador=0;
b.barcos=3;
b.ubicacion();
					
	//				System.out.println(b.barco1 + " "+b.barco2 + " "+b.barco3);
					for (b.ronda = 0; b.ronda < 6; b.ronda++) {
					
						do {
							cadenaY = JOptionPane.showInputDialog (null, "Ronda: "+(b.ronda+1) + "\nCoordenadas X para disparo [A-F]: ","Hundir la flota", JOptionPane.QUESTION_MESSAGE);		
							b.setY(cadenaY);
							
							if (b.getY() == -1){
								JOptionPane.showMessageDialog(null, "Fuera del rango".toString(),"Hundir la flota",JOptionPane.ERROR_MESSAGE);
							}
						} while (b.getY() == -1);

						do {
							numeroX = Integer.parseInt(JOptionPane.showInputDialog(null,"Introducir coordenadas Y para disparo [1-6]:","Hundir la flota", JOptionPane.QUESTION_MESSAGE));

							b.setX(numeroX);
							if (b.getX() == -1) {
								JOptionPane.showMessageDialog(null, "Fuera del rango".toString(),"Hundir la flota",JOptionPane.ERROR_MESSAGE);
							}
						} while (b.getX() == -1);


						String comprueba =  b.compruebaHistorial() + b.comprueba();
						
						if(b.comprueba().equals("Tocado")) b.barcos--;
						
						if(b.barcos>0)
							JOptionPane.showMessageDialog(null, comprueba.toString()+"\nQuedan: "+b.barcos+"/3 barcos","Resultado", JOptionPane.INFORMATION_MESSAGE);
						else 
							JOptionPane.showMessageDialog(null, comprueba.toString()+"\nÚltimo barco destruido","Resultado", JOptionPane.INFORMATION_MESSAGE);

						b.historial();

						if(b.contador==3){
							b.ventana();	

							break;
						}
						

					}

					if (b.ronda == 6) {
						b.ventana();	
					}
					System.out.println();
					b.informe.clear();
					b.ch.clear();
					System.out.println("\n");
			}

			else if (opcion.equals("2")){
					salir = true;
					JOptionPane.showMessageDialog(null, "Fin del juego".toString(),"Hundir la flota", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
			else
				JOptionPane.showMessageDialog(null, "Solo opciones 1 y 2\n".toString(),"Hundir la flota", JOptionPane.INFORMATION_MESSAGE);			
		}
		sc.close();
		}

	}
