package com.edutecno.views;

import java.util.Scanner;

import com.edutecno.model.CategoriaEnum;
import com.edutecno.model.Cliente;
import com.edutecno.services.ArchivoServicio;
import com.edutecno.services.ClienteServicio;
import com.edutecno.services.ExportadorCsv;
import com.edutecno.services.ExportadorTxt;
import com.edutecno.utilities.Utilidad;

public class Menu {
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	private Scanner sc = new Scanner(System.in);

	public void iniciarMenu() {

		do {
			Utilidad.titulo("Menu Principal");
			Utilidad.mostrarMensaje("1. Listar");
			Utilidad.mostrarMensaje("2. Agregar Cliente");
			Utilidad.mostrarMensaje("3. Editar Cliente");
			Utilidad.mostrarMensaje("4. Cargar Datos");
			Utilidad.mostrarMensaje("5. Exportar Datos");
			Utilidad.mostrarMensaje("6. Salir");
			Utilidad.mostrarMensaje("");
			Utilidad.linea();
			Utilidad.mostrarMensaje("Ingrese una opción:");

			String opcion = sc.nextLine();

			switch (opcion) {
			case "1": // Listar
				listarClientes();
				break;

			case "2": // Agregar Cliente
				agregarCliente();
				break;

			case "3": // Editar Cliente
				editarCliente();
				break;

			case "4": // Cargar Datos
				cargarDatos();
				break;

			case "5": // Exportar Datos
				exportarDatos();
				break;

			case "6": // Terminar
				terminarPrograma();
				break;

			default:
				break;
			}

		} while (true);
	} // End iniciarMenu()

	public void listarClientes() {
		Utilidad.tiempoEspera();
		Utilidad.titulo("Menu Listar Cliente");

		clienteServicio.listarClientes();

	} // End listarClientes()

	public void agregarCliente() {
		Cliente cliente = new Cliente();

		Utilidad.titulo("Menu Agregar Cliente");
//		Utilidad.mostrarMensaje("Menu Agregar Cliente");

		Utilidad.mostrarMensaje("Ingrese RUN del Cliente:");
		cliente.setRunCliente(Utilidad.validarString(sc));
		Utilidad.mostrarMensaje("Ingrese nombre del Cliente:");
		cliente.setNombreCliente(Utilidad.validarString(sc));
		Utilidad.mostrarMensaje("Ingrese apellido del Cliente:");
		cliente.setApellidoCliente(Utilidad.validarString(sc));
		Utilidad.mostrarMensaje("Ingrese años como Cliente:");
		cliente.setAniosCliente(Utilidad.validarString(sc));
		cliente.setNombreCategoria(CategoriaEnum.ACTIVO);

		clienteServicio.agregarCliente(cliente);

	} // End agregarCliente()

	public void editarCliente() {
		Utilidad.titulo("Editar Cliente");

		Utilidad.mostrarMensaje("Ingrese RUN del Cliente:");
		clienteServicio.editarCliente(Utilidad.validarString(sc));

	} // End editarCliente()

	public void cargarDatos() {
		Utilidad.linea();
		Utilidad.mostrarMensaje("Cargar datos en Linux o mac");
		Utilidad.mostrarMensaje("Ingrese la ruta");
		Utilidad.mostrarMensaje("ejemplo: 'src/DBClientes.csv'");
		archivoServicio.cargarDatos(Utilidad.validarString(sc), clienteServicio);

	} // End cargarDatos()

	public void exportarDatos() {
		Utilidad.titulo("Exportar Datos");
		Utilidad.mostrarMensaje("1.-Formato csv");
		Utilidad.mostrarMensaje("2.-Formato txt");
		Utilidad.mostrarMensaje("3.-Salir");
		Utilidad.mostrarMensaje("");
		Utilidad.mostrarMensaje("Ingrese una opción para exportar:");

		String opcion = sc.nextLine();

		Utilidad.mostrarMensaje("Ingrese la ruta");
		Utilidad.mostrarMensaje("ejemplo: 'src'");

		String ruta = Utilidad.validarString(sc);

		if (!opcion.isEmpty()) {
			switch (opcion) {
			case "1":
				exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
				break;

			case "2":
				exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
				break;

			case "3":
				Utilidad.mostrarMensaje("Regresar al menu princial");
				break;

			default:
				exportarDatos();
				break;
			}

		}
	} // End exportarDatos()

	public void terminarPrograma() {
		Utilidad.mostrarMensaje("Saliendo del Programa");
		Utilidad.tiempoEspera();
		Utilidad.mostrarMensaje("Hasta Luego");
		System.exit(0);

	} // End terminarDatos()

} // End Class
