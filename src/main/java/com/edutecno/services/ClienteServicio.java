package com.edutecno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edutecno.model.CategoriaEnum;
import com.edutecno.model.Cliente;
import com.edutecno.utilities.Utilidad;

public class ClienteServicio {
	// Atributos
	private List<Cliente> listaClientes;
	Scanner sc = new Scanner(System.in);

	// Constructor
	public ClienteServicio() {
		listaClientes = new ArrayList<Cliente>();
	}

	// Getters and Setters
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	// metodos
	public void listarClientes() {
		if (!listaClientes.isEmpty() && listaClientes != null) {
			for (Cliente clienteTemp : listaClientes) {
				Utilidad.mostrarMensaje(clienteTemp.toStringLista());
			}

		} else {
			Utilidad.mostrarMensaje("La lista esta vacía");
		}
	} // End listarClientes()

	public void agregarCliente(Cliente cliente) {

		if (!cliente.getRunCliente().isEmpty()) {
			if (listaClientes != null) {
				listaClientes.add(cliente);
				Utilidad.tiempoEspera();
				Utilidad.linea();
				Utilidad.mostrarMensaje("Cliente Agregado");
			}

		} else {
			Utilidad.mostrarMensaje("Error: El cliente no esta agregado");
		}
	} // End agregarCliente()

	public void editarCliente(String run) {
		if (listaClientes != null) {
			for (Cliente clienteTemp : listaClientes) {
				if (clienteTemp.getRunCliente().equals(run)) {
					Utilidad.linea();
					Utilidad.mostrarMensaje("Acciones Disponibles:");
					Utilidad.mostrarMensaje("1. Cambiar el estado del cliente");
					Utilidad.mostrarMensaje("2. Editar los datos ingresados del cliente");
					Utilidad.linea();
					Utilidad.mostrarMensaje("Seleccione que desea hacer:");
					String opcion = sc.nextLine();

					switch (opcion) {
					case "1":
						editarEstadoCliente(clienteTemp);
						break;

					case "2":
						editarCamposCliente(clienteTemp);
						break;

					default:
						Utilidad.mostrarMensaje("opcion incorrecta");
						break;
					}
				}
			}
		}
	} // End editarCliente()

	public void editarEstadoCliente(Cliente cliente) {
		Utilidad.mostrarMensaje("Actualizando estado del Cliente");
		Utilidad.mostrarMensaje("El estado actual es: " + cliente.getNombreCategoria().toString());
		Utilidad.mostrarMensaje("");
		Utilidad.mostrarMensaje("1. Si desea cambiar el estado del Cliente a Inactivo");
		Utilidad.mostrarMensaje("2. Si desea mantener el estado del Cliente como Activo");
		Utilidad.mostrarMensaje("");
		Utilidad.linea();
		Utilidad.mostrarMensaje("Ingrese opción:");

		String opcion = sc.nextLine();

		switch (opcion) {
		case "1":
			cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
			Utilidad.tiempoEspera();
			Utilidad.linea();
			Utilidad.mostrarMensaje("Categoría cambiada");
			break;

		case "2":
			cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
			Utilidad.tiempoEspera();
			break;

		case "3":
			Utilidad.mostrarMensaje("Regresando al menu principal");
			Utilidad.tiempoEspera();
			break;

		default:
			Utilidad.mostrarMensaje("Opción incorrecta");
			Utilidad.linea();
			editarEstadoCliente(cliente);
			break;

		}
	} // End editarEstadoCliente()

	public void editarCamposCliente(Cliente cliente) {
		Utilidad.titulo("Actualizando datos del cliente");

		Utilidad.mostrarMensaje("1.-El RUN del Cliente es:" + cliente.getRunCliente().toString());
		Utilidad.mostrarMensaje("2.-El Nombre del Cliente es:" + cliente.getNombreCliente().toString());
		Utilidad.mostrarMensaje("3.-El Apellido del Cliente es:" + cliente.getApellidoCliente());
		Utilidad.mostrarMensaje("4.-Los años como Cliente son: " + cliente.getAniosCliente());
		Utilidad.mostrarMensaje("5.-Salir");
		Utilidad.mostrarMensaje("");

		Utilidad.linea();
		Utilidad.mostrarMensaje("Ingrese opción a editar de los datos del cliente:");

		String opcion = sc.nextLine();
		Utilidad.mostrarMensaje("");

		switch (opcion) {
		case "1":
			Utilidad.mostrarMensaje("Ingrese nuevo RUN del cliente:");
			cliente.setRunCliente(Utilidad.validarString(sc));

			Utilidad.linea();
			Utilidad.tiempoEspera();
			Utilidad.mostrarMensaje("Dato RUN cambiado con exito");
			break;

		case "2":
			Utilidad.mostrarMensaje("Ingrese nuevo Nombre del cliente:");
			cliente.setNombreCliente(Utilidad.validarString(sc));

			Utilidad.linea();
			Utilidad.tiempoEspera();
			Utilidad.mostrarMensaje("Dato Nombre cambiado con exito");

			break;

		case "3":
			Utilidad.mostrarMensaje("Ingrese nuevo Apellido del cliente:");
			cliente.setApellidoCliente(Utilidad.validarString(sc));

			Utilidad.tiempoEspera();
			Utilidad.mostrarMensaje("Dato Apellido cambiado con exito");
			break;

		case "4":
			Utilidad.mostrarMensaje("Ingrese nuevo Apellido del cliente:");
			cliente.setAniosCliente(Utilidad.validarString(sc));

			Utilidad.tiempoEspera();
			Utilidad.mostrarMensaje("Dato Apellido cambiado con exito");
			break;

		case "5":
			Utilidad.mostrarMensaje("Regresando al menu principal");
			Utilidad.tiempoEspera();
			break;

		default:
			Utilidad.mostrarMensaje("Opción incorrecta");

			Utilidad.linea();
			editarCamposCliente(cliente);
			break;
		}
	} // End editarCamposCliente()

} // End Class
