package com.codeatest.mockito;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class ControladorEnvioEmail {
	
	static final String E_MAIL_ENVIADO_COM_SUCESSO = "E-mail enviado com sucesso!";
	static final String NAO_FOI_POSSIVEL_ENVIAR_TODOS = "Os seguintes e-mails não receberam a mensagem: %s";
	private EmailService emailService;
	
	public StatusOperacao envia(Mensagem mensagem, String remetente, String... destinatarios) {
		List<String> emailsInvalidos = new ArrayList<>();
		for(String destinatario : destinatarios) {
			try {
				emailService.envia(mensagem, remetente, destinatario);
			} catch (EmailInvalidoException e) {
				emailsInvalidos.add(destinatario);
			}
		}
		StatusOperacao status = new StatusOperacao(E_MAIL_ENVIADO_COM_SUCESSO, true);
		if(CollectionUtils.isNotEmpty(emailsInvalidos)) {
			status = new StatusOperacao(String.format(NAO_FOI_POSSIVEL_ENVIAR_TODOS, StringUtils.join(emailsInvalidos, ",")), false);
		}
		return status;
	}

}
