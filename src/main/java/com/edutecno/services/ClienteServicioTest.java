package com.edutecno.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.edutecno.model.CategoriaEnum;
import com.edutecno.model.Cliente;

public class ClienteServicioTest {
	private static ClienteServicio clienteServicio = new ClienteServicio();
	private static Logger logger = Logger.getLogger("com.edutecno");

	@BeforeAll
	static void setUp() {
		clienteServicio = new ClienteServicio();
		logger = Logger.getLogger("com.edutecno");
		logger.info("Inicio de la clase test ClienteServicioTest\n");
		
	}// fin setUp()

	@BeforeEach
	void init() {
		logger.info("Iniciando metodo de prueba\n");
		
	}// fin init()

	@AfterAll
	static void finish() {
		logger.info("Terminando clase test ServicioPersonaTest\n");
		
	}// fin finish()

	@AfterEach
	void done() {
		logger.info("Terminando metodo de prueba \n");
		
	}// fin done()

	// Test metodo agregarCliente()
	@Test
	@DisplayName("Test metodo agregarCliente()")
	public void agregarClienteTest() {
		logger.info("Iniciando metodo de prueba agregarClienteTest en la clase ClienteServicioTest");
		Cliente cliente = new Cliente("27-0", "Fulanito", "Perez", "2", CategoriaEnum.ACTIVO);
		clienteServicio.agregarCliente(cliente);
		assertEquals(1, clienteServicio.getListaClientes().size());

	} // fin agregarClienteTest()

	// Test metodo agregarClienteNull
	@Test
	@DisplayName("Test metodo agregarClienteNull()")
	public void agregarClienteNullTest() {
		logger.info("Iniciando metodo de prueba agregarClienteNullTest en la clase ClienteServicioTest");
		Cliente cliente = new Cliente();
		System.out.println("cliente" + cliente);
		clienteServicio.agregarCliente(cliente);
		assertEquals(null, clienteServicio.getListaClientes().get(0).getNombreCategoria());
		/*
		 * Método entrega falso debido a que agregarCliente() no agrega en el caso que
		 * sea null o vacío.
		 */
	} // fin agregarClienteNullTest()

}// fin class
