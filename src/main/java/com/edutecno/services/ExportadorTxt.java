package com.edutecno.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.edutecno.model.Cliente;
import com.edutecno.utilities.Utilidad;

public class ExportadorTxt extends Exportador {
	Scanner sc = new Scanner(System.in);

	@Override
	public void exportar(String ruta, List<Cliente> clientes) {
		Utilidad.linea();
		System.out.println("ingrese nombre del archivo como: ejemplo.txt");

		String nombreArchivo = sc.nextLine();

		crearDirectorio(ruta);
		crearArchivoYEscribir(ruta, nombreArchivo, clientes);

	} // End exportar()

	private static void crearDirectorio(String nombreDirectorio) {
		File directorio = new File(nombreDirectorio);

		if (directorio.exists()) {
			System.out.println("El directorio o carpeta existe, verificar");

		} else {
			directorio.mkdir();
			System.out.println("Directorio o carpeta creada...");
			Utilidad.tiempoEspera();

		}

	} // End crearDirectorio()

	private static void crearArchivoYEscribir(String ruta, String nombreArchivo, List<Cliente> clientes) {
		File archivo = new File(ruta + "/" + nombreArchivo);// src/carpeta/nombredeArchivo.txt

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();

				System.out.println("Archivo creado, escribiendo...");
				Utilidad.tiempoEspera();

			} else {
				System.out.println("Archivo existe, editando");
				Utilidad.tiempoEspera();

			}

			FileWriter fileWriter = new FileWriter(archivo);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (Cliente clienteTemp : clientes) {
				bufferedWriter.write(clienteTemp.toStringDos());
				bufferedWriter.newLine();

			}

			bufferedWriter.close();
			fileWriter.close();

			System.out.println("Datos de clientes exportados correctamente en formato .txt");
			System.out.println();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	} // End crearArchivoYEscribir()

} // End Class
