package com.codeatest.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosServiceTest {

	@Mock
	private UsuariosRepository repository;

	@InjectMocks
	private UsuariosService service;

	
	@Test
	public void listaTodosUsuarios() {
		service.todosUsuarios();
	}

}
