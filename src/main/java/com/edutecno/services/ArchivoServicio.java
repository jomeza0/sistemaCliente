package com.edutecno.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.edutecno.model.CategoriaEnum;
import com.edutecno.model.Cliente;
import com.edutecno.utilities.Utilidad;

public class ArchivoServicio {

	public ArrayList<Cliente> cargarDatos(String ruta, ClienteServicio clienteServicio) {
		ArrayList<Cliente> listarClientes = new ArrayList<Cliente>();
		Scanner sc = new Scanner(System.in); // Para "presione enter para continuar

		try {
			File archivo = new File(ruta);
			FileReader fileReader = new FileReader(archivo);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String linea = bufferedReader.readLine();

			while (linea != null) {
				ArrayList<String> listaTemporal = new ArrayList<String>(Arrays.asList(linea.split(",")));

				Cliente cliente = new Cliente();
				cliente.setRunCliente(listaTemporal.get(0));
				;
				cliente.setNombreCliente(listaTemporal.get(1));
				;
				cliente.setApellidoCliente(listaTemporal.get(2));
				;
				cliente.setAniosCliente(listaTemporal.get(3));
				cliente.setNombreCategoria(CategoriaEnum.valueOf(listaTemporal.get(4)));

				listarClientes.add(cliente);

				linea = bufferedReader.readLine();
			}

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!listarClientes.isEmpty()) {
			clienteServicio.getListaClientes().addAll(listarClientes);

			Utilidad.linea();
			Utilidad.tiempoEspera();
			Utilidad.titulo("Los datos se han cargado");
			System.out.println("Presione Enter para continuar:");
			System.out.println(sc.nextLine());

		}
		return listarClientes;

	}

}
