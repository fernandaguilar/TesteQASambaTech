package com.sambatech.java.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sambatech.java.config.Configuration;

public class MonetizacaoPage {
	
	private WebDriver driver;
	
	//elementos pagina
	private WebElement botaoCriarCampanha;
	private WebElement linkCampanha;
	private WebElement linhaCampanha;
	private WebElement botaoExpandirMenu;
	private WebElement menuOpcoesCampanha;
	private WebElement linkEditarCampanha;
	private WebElement linkExcluirCampanha;
	private WebElement modalConfirmacaoExcluir;
	private WebElement linkModalConfirmacaoExcluir;
	
	public MonetizacaoPage(WebDriver driver){
		this.driver = driver;
	}
	
	//metodo que acessa a pagina de monetizacao
	public void visita(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean usuarioLogado = wait.until(ExpectedConditions.urlContains("dashboard"));
		if (usuarioLogado) {
			driver.get(Configuration.urlAplicacao + "/ui#monetization");
		}
	}	
	
	//metodo que acessa a tela de campanha atraves do botao de criar campanha
	public void criarCampanhaComSucesso(){
		//Encontrando Elementos 
		WebDriverWait wait = new WebDriverWait(driver, 15);
		botaoCriarCampanha = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-campaign")));
		botaoCriarCampanha.click();
	}
	
	//metodo que verifica se a campanha existe
	public boolean verificarCampanhaExistente(String nomeCampanha) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		boolean campanhaCriada = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("list-campaigns"), nomeCampanha));
		
		return campanhaCriada;
	}
	
	//metodo que abre o menu no no registro especifico da campanha
	private WebElement abrirMenuCampanha(String nomeCampanha) {
		//Encontrando Elementos 
		WebDriverWait wait = new WebDriverWait(driver, 60);
		linkCampanha = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("list-campaigns"), By.linkText(nomeCampanha)));

		linhaCampanha = linkCampanha.findElement(By.xpath("../../../.."));
		botaoExpandirMenu = linhaCampanha.findElement(By.className("dropdown-toggle"));
		botaoExpandirMenu.click();
		
		return botaoExpandirMenu.findElement(By.xpath(".."));
	}
	
	//metodo que redireciona para a edicao da campanha
	public void editarCampanha(String nomeCampanha){
		//Encontrando Elementos 
		menuOpcoesCampanha = abrirMenuCampanha(nomeCampanha);
		
		WebDriverWait waitLinkEditar = new WebDriverWait(driver, 20);
		linkEditarCampanha = waitLinkEditar.until(ExpectedConditions.presenceOfNestedElementLocatedBy(menuOpcoesCampanha, By.linkText("Editar campanha")));
		linkEditarCampanha.click();
	}
	
	//metodo que executa a exclusao da campanha
	public void excluirCampanha(String nomeCampanha) {
		menuOpcoesCampanha = abrirMenuCampanha(nomeCampanha);
		
		WebDriverWait waitLinkExcluir = new WebDriverWait(driver, 20);
		linkExcluirCampanha = waitLinkExcluir.until(ExpectedConditions.presenceOfNestedElementLocatedBy(menuOpcoesCampanha, By.linkText("Excluir campanha")));
		linkExcluirCampanha.click();
		
		modalConfirmacaoExcluir = waitLinkExcluir.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.tagName("body"), By.id("modalContainer")));
		linkModalConfirmacaoExcluir = modalConfirmacaoExcluir.findElement(By.className("btn-danger"));
		linkModalConfirmacaoExcluir.click();
	}
}
