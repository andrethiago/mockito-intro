package com.codeatest.mockito;

import java.util.List;

public class TarefasService {
	
	private TarefasRepository repository;

	public List<Tarefa> todas(Sprint sprint) {
		return repository.consultarTodas(sprint);
	}

	public void salvar(List<Tarefa> tarefas) {
		repository.salvar(tarefas);		
	}

}
