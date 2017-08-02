package com.sambatech.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sambatech.java.config.Configuration;
import com.sambatech.java.framework.pageobjects.CampanhaPage;
import com.sambatech.java.framework.pageobjects.LoginPage;
import com.sambatech.java.framework.pageobjects.MonetizacaoPage;
import com.sambatech.java.utils.Driver;

public class MonetizacaoPageScripts {
	
	private MonetizacaoPage monetizacao;
	private CampanhaPage criaCampanha;
	private static WebDriver driver;
	
	@BeforeClass
	public static void setupTeste() {
		driver = Driver.getInstance();
	}
	
	@Before
	public void inicializaTeste() {
		monetizacao = new MonetizacaoPage(driver);
		criaCampanha = new CampanhaPage(driver);
		LoginPage login = new LoginPage(driver);
		login.visita();
		login.preencherCampos(Configuration.usuario, Configuration.senha);
		monetizacao.visita();
	}
	
	@AfterClass
	public static void finalizaTeste(){
		Driver.close();
	}
	
	@Test
	public void deveCriarCampanha(){
		String caminhoVideo = Configuration.caminhoProjeto + "\\videos\\video-redbull.mp4";

		monetizacao.criarCampanhaComSucesso();

		criaCampanha.preencherCamposDaCampanha("Teste Campanha", caminhoVideo, 
												"PREROLL","https://", "www.google.com", "GENDER", "15/08/2017", "25/08/2017",
												"COST_PER_CLICK", "10", "PERIOD","5.50");
		
		assertTrue(monetizacao.verificarCampanhaExistente("Teste Campanha"));
	}
	
	@Test
	public void deveEditarCampanha(){
		monetizacao.editarCampanha("Teste Campanha");

		criaCampanha.preencherCamposDaCampanha("Teste Campanha Editada", "C:\\Users\\Fernanda\\Downloads\\Redbull te da Asas.mp4", 
												"PREROLL","https://", "www.google.com", "GENDER", "15/08/2017", "25/08/2017",
												"COST_PER_CLICK", "10", "PERIOD","5.50");
		
		assertTrue(monetizacao.verificarCampanhaExistente("Teste Campanha Editada"));
	}
	
	@Test
	public void deveExcluirCampanha(){
		monetizacao.excluirCampanha("Teste Campanha Editada");
		
		assertFalse(monetizacao.verificarCampanhaExistente("Teste Campanha Editada"));
	}
}
