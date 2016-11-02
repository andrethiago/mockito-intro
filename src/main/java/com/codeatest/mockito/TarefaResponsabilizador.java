package com.codeatest.mockito;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class TarefaResponsabilizador {
	
	private TarefasService tarefasService;
	 
	 public TarefaResponsabilizador(TarefasService tarefasService) {
	    this.tarefasService = tarefasService;
	 }
	 
	 public void atribuirResponsabilidadeTarefas(Sprint sprint, Usuario usuarioResponsavel) {
	    List<Tarefa> tarefas = tarefasService.todas(sprint);
	 
	    if (CollectionUtils.isNotEmpty(tarefas)) {
	       tarefas.forEach(tarefa -> tarefa.defineResponsavel(usuarioResponsavel));
	       tarefasService.salvar(tarefas);
	    }
	 }

}
