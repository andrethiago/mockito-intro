package com.codeatest.mockito;

public class StatusOperacao {
	
	private boolean sucesso = true;
	private String mensagem = "";

	public StatusOperacao(String mensagem, boolean sucesso) {
		this.mensagem = mensagem;
		this.sucesso = sucesso;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
