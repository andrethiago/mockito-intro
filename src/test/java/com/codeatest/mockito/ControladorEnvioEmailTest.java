package com.codeatest.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorEnvioEmailTest {
	
	@Mock
	private EmailService emailService;
	
	@InjectMocks
	private ControladorEnvioEmail controlador;
	
	@Test
	public void todosDestinatariosRecebemEmail() {
		Mensagem mensagem = new Mensagem();
		String remetente = "bob@codeatest.com";
		String[] destinatarios = new String[] {"john@provedor.com", "liz@provedor.com", "mary@provedor.com"};
		StatusOperacao status = controlador.envia(mensagem, remetente, destinatarios);
		assertTrue(status.isSucesso());
		assertEquals(ControladorEnvioEmail.E_MAIL_ENVIADO_COM_SUCESSO, status.getMensagem());
		verify(emailService, times(3)).envia(Mockito.any(Mensagem.class), Mockito.anyString(), Mockito.anyString());
	}
	
	@Test
	public void destinatarioComEmailInvalidoNaoRecebeEmail() {
		Mensagem mensagem = new Mensagem();
		String remetente = "bob@codeatest.com";
		String[] destinatarios = new String[] {"john@provedor.com", "liz@provedor", "mary@provedor.com"};
		
		doThrow(EmailInvalidoException.class).when(emailService).envia(mensagem, remetente, "liz@provedor");
		
		StatusOperacao status = controlador.envia(mensagem, remetente, destinatarios);
		assertFalse(status.isSucesso());
		assertEquals(String.format(ControladorEnvioEmail.NAO_FOI_POSSIVEL_ENVIAR_TODOS, "liz@provedor"), status.getMensagem());
		verify(emailService, times(3)).envia(Mockito.any(Mensagem.class), Mockito.anyString(), Mockito.anyString());
	}

}
