package com.codeatest.mockito;

public class Tarefa {

	private String nome;
	
	private Usuario responsavel;
	
	public void defineResponsavel(Usuario usuarioResponsavel) {
		this.responsavel = usuarioResponsavel;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}
	
}
