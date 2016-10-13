package com.codeatest.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UsuariosServiceTest {

	private UsuariosRepository repository;

	private UsuariosService service;

	@Before
	public void prepara() {
		repository = Mockito.mock(UsuariosRepository.class);
		service = new UsuariosService(repository);
	}

	@Test
	public void listaTodosUsuarios() {
		service.todosUsuarios();
	}

}
