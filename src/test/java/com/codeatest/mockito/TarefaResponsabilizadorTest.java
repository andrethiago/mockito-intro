package com.codeatest.mockito;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
 
import java.util.Arrays;
import java.util.List;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
 
@RunWith(MockitoJUnitRunner.class)
public class TarefaResponsabilizadorTest {
 
  @Mock
  private TarefasService tarefasService;
 
  @Test
  public void atribuiResponsabilidadeTodasTarefasExistentes() {
    Sprint sprint = new Sprint();
    Usuario usuarioResponsavel = new Usuario();
    List<Tarefa> listaTarefas = Arrays.asList(new Tarefa[] {new Tarefa(), new Tarefa(), new Tarefa()});
 
    when(tarefasService.todas(sprint)).thenReturn(listaTarefas);
 
    TarefaResponsabilizador responsabilizador = new TarefaResponsabilizador(tarefasService);
    responsabilizador.atribuirResponsabilidadeTarefas(sprint, usuarioResponsavel);
 
    assertThat(listaTarefas, everyItem(hasProperty("responsavel", equalTo(usuarioResponsavel))));
  }
 
}
