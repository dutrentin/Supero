package br.com.avaliacao.supero;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	private HttpServer server;
	
	@Before
	public void startaServidor(){
		server = Servidor.inicializaServidor();
	}
	
	@After
	public void mataServidor(){
		server.stop();
	}

	@Test
	public void testaQueAConexaoComOServidorFunciona() {
	    Client client = ClientBuilder.newClient();
	    WebTarget target = client.target("http://localhost:8080");
	    String conteudo = target.path("/carrinhos").request().get(String.class);
	    System.out.println(conteudo);
//	    Assert.assertTrue(conteudo.contains("Rua Vergueiro 3185"));
	}
}
