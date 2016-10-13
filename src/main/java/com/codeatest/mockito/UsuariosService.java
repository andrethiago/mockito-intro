package com.codeatest.mockito;

import java.util.List;

public class UsuariosService {

	private UsuariosRepository repository;

	public UsuariosService(UsuariosRepository repository) {
		this.repository = repository;
	}

	public List<Usuario> todosUsuarios() {
		return repository.consultarTodos();
	}

}
