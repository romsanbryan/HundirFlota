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

public class Main {

	public static void main(String[] args) {
		Juego b = new Juego();
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;
  
   
		while (!salir) {
			System.out.println("1. Jugar");
			System.out.println("2. Salir");
			System.out.print("Escribe una de las opciones: ");
			opcion = sc.nextInt();
			System.out.println();


			switch (opcion) {
				case 1:
					b.ubicacion();

					for (b.ronda = 0; b.ronda < 6; b.ronda++) {
						System.out.println("\n"+"Ronda: "+(b.ronda+1));
						System.out.print("Introducir coordenads [A-F]:");
						b.setY(sc.next());
            	   
						if (b.getY() == -1){
							break;
						}

						System.out.print("Introducir coordenads [1-6]:");
						b.setX(sc.nextInt());
						if (b.getX() == -1) {
							break;
						}
            	  
						b.compruebaHistorial();

						System.out.println(b.comprueba());
						b.historial();

						if(b.contador==3){
							System.out.println("Flota hundida");
							break;
						}
					}
					
					System.out.println();
					if (b.ronda > 0)
						b.ventana();
					System.out.println("\n");
					b.ch.clear();
					break;
					
				case 2:
					salir = true;
					System.out.println("Fin del juego\n");
					break;
				default:
					System.out.println("Solo opciones 1 y 2\n");
			}
		}
		sc.close();
		}

	}
