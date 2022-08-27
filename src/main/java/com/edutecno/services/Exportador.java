package com.edutecno.services;

import java.util.List;

import com.edutecno.model.Cliente;

public abstract class Exportador {

	public abstract void exportar(String fileName, List<Cliente> clientes);

}
