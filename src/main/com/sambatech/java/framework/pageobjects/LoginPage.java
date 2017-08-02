package com.sambatech.java.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sambatech.java.config.Configuration;

public class LoginPage {

	private WebDriver driver;
	
	//elementos pagina
	private WebElement campoEmailUsuario;
	private WebElement campoSenhaUsuario;
	private WebElement linkLogout;
	private WebElement linkRecuperarSenha;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}	
	
	//metodo que acessa a pagina de login
	public void visita(){
		driver.get(Configuration.urlAplicacao + "/auth/login");
	}
	
	//metodo que preenche os campos da pagina de login
	public void preencherCampos(String email, String senha){
		
		//Encontrando os elementos na tela de Login
		campoEmailUsuario = driver.findElement(By.id("inputEmail"));
		campoSenhaUsuario = driver.findElement(By.id("inputPassword"));
		
		// Digitando nos campos da tela
		campoEmailUsuario.sendKeys(email);
		campoSenhaUsuario.sendKeys(senha);
		
		//Clicando para logar no sistema
		campoEmailUsuario.submit();
	}
	
	//metodo que verifica se o login foi realizado com sucesso
	public boolean verificarLoginComSucesso(String url){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		boolean usuarioLogado = wait.until(ExpectedConditions.urlContains(url));
		//boolean usuarioLogado = driver.getPageSource().contains(nomeUsuario);
		return usuarioLogado;
	}
	
	//metodo que verifica se o login foi realizado sem sucesso
	public boolean verificarLoginSemSucesso(String mensagemErro, String url){
		boolean mensagemExiste = driver.getPageSource().contains(mensagemErro) && 
								 driver.getCurrentUrl().contains(url);	
		return mensagemExiste;	
	}
	
	//metodo que que executa a saida do sistema
	public void sairDoSistema(String nomeUsuario, String idLink){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement linkUsuario = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(nomeUsuario)));
		linkUsuario.click();
		
		linkLogout = driver.findElement(By.id("logout"));
		linkLogout.click();
	}
	
	//metodo que executa o clique no link de recuperacao de senha
	public void recuperarSenha(){
		linkRecuperarSenha = driver.findElement(By.id("forgot-pwd-link"));
		linkRecuperarSenha.click();
	}
	
	//metodo que verifica se o usuario foi redirecionado para a pagina de recuperacao de senha
	public boolean verificarSenha(String url){
		boolean recuperaSenha = driver.getCurrentUrl().contains(url);
		return recuperaSenha;
	}
}
