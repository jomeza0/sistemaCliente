package com.edutecno.utilities;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilidad {

	public static void linea() {
		// Método para colocar un línea de separación
		// reducir tiempo y estandarizar la línea
		System.out.println("-------------------------");

	} // End linea()

	public static void titulo(String mensaje) {
		System.out.println("");
		Utilidad.linea();
		System.out.println("-- " + mensaje + " --");
		Utilidad.linea();
		System.out.println("");

	} // End titulo()

	public static void limpiarPantalla() {
		// Metodo para la limpieza de la pantalla al agregar varias lineas en blanco
		for (int i = 0; i < 20; i++) {
			System.out.println();

		}
	} // End limpiarPantalla()

	public static void tiempoEspera() {
		// metodo para que muestre carga de pantalla
		for (int i = 3; i > 0; i--) { // mostrar cuenta regresiva en pantalla
			System.out.println("Cargando en " + i + "...");

			try {
				TimeUnit.MILLISECONDS.sleep(500); // regular tiempo en que aparece

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	} // End tiempoEspera()

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);

	} // End mostrarMensaje()

	public static String validarString(Scanner sc) {
		String ingreso = "";

		do {
			ingreso = sc.nextLine();

			if (ingreso.isEmpty()) {
				Utilidad.mostrarMensaje("Ingrese Dato");
			}

		} while (ingreso.isEmpty());
		return ingreso;

	} // End validarString()

} // End Class
