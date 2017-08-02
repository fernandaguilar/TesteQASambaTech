package com.sambatech.java;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sambatech.java.config.Configuration;
import com.sambatech.java.framework.pageobjects.LoginPage;
import com.sambatech.java.utils.Driver;

public class LoginPageScripts {
	
	private LoginPage login;
	private static WebDriver driver;

	@BeforeClass
	public static void setupTeste() {
		driver = Driver.getInstance();
	}
	
	@Before
	public void inicializaTeste() {
		login = new LoginPage(Driver.getInstance());
		login.visita();
	}
	
	@AfterClass
	public static void finalizaTeste(){
		Driver.close();
	}
	
	@Test
	public void deveTestarLoginValido(){
		login.preencherCampos(Configuration.usuario, Configuration.senha);
		assertTrue(login.verificarLoginComSucesso("dashboard"));
		login.sairDoSistema(Configuration.nomeUsuario, "logout");
	}

	@Test
	public void deveTestarLoginInvalido(){
		login.preencherCampos("avaliacao@sambatech.com", "123456");
		assertTrue(login.verificarLoginSemSucesso("Email ou senha incorretos.", "login"));
	}
	
	@Test
	public void deveTestarEsqueciSenha(){
		login.recuperarSenha();
		assertTrue(login.verificarSenha("Password"));
	}
}
