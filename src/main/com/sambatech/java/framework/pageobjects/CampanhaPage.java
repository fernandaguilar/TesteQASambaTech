package com.sambatech.java.framework.pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CampanhaPage {

	private WebDriver driver;
	
	//elementos pagina
	private WebElement campoNovaCampanha;
	private List<WebElement> checkAnuncio;
	private Select comboProtocolo;
	private WebElement campoUrl;
	private List<WebElement> checkSegmentacao;
	private WebElement botaoAdicionarSegmentacao;
	private WebElement campoDataInicio;
	private WebElement campoDataFim;
	private List<WebElement> checkVeiculacao;
	private WebElement campoMeta;
	private Select comboGarantia;
	private WebElement campoPreco;
	private WebElement botaoCriarCampanha;
	private WebElement campoArquivo; 
	
	public CampanhaPage(WebDriver driver){
		this.driver = driver;
	}	
	
	//metodo que preenche os campos da pagina
	public void preencherCamposDaCampanha(String novaCampanhaVal, String caminhoArquivoVal, 
										  String checkAnuncioVal, String urlVal, String urlCaminhoVal,
										  String checkSegmentacaoVal, String dataInicioVal, String dataFimVal,
										  String chekVeiculacaoVal, String metaVal, String garantiaVal, 
										  String precoVal){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//Encontrando elementos na tela de campanha
		campoNovaCampanha = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		
		checkAnuncio = driver.findElements(By.name("position"));
		comboProtocolo = new Select(driver.findElement(By.name("ctProtocol")));
		
		campoUrl = driver.findElement(By.name("urlClickThrough"));
		
		checkSegmentacao = driver.findElements(By.name("tagType"));
		botaoAdicionarSegmentacao = driver.findElement(By.id("select-existing-channels"));
		
		campoDataInicio = driver.findElement(By.name("start"));
		campoDataFim = driver.findElement(By.name("end"));
		
		checkVeiculacao = driver.findElements(By.name("isImpression"));
		
		campoMeta = driver.findElement(By.name("target"));
		
		comboGarantia = new Select(driver.findElement(By.name("isUniform")));
		
		campoPreco = driver.findElement(By.name("grossValue"));
		botaoCriarCampanha = driver.findElement(By.className("form-actions")).findElement(By.className("btn-primary"));
		
		
		//preenchendo campos na pagina
		campoNovaCampanha.sendKeys(novaCampanhaVal);
		
		try {
			enviarArquivo(caminhoArquivoVal);
		} catch (NoSuchElementException e) {
			System.out.println("Upload não foi encontrado. Provavelmente em modo de edição.");
		} catch (AWTException e) {
			System.out.println("Ocorreu um erro ao tentar enviar o arquivo: " + e.getMessage());
		}

		if(checkAnuncio.get(0).getAttribute("value").equalsIgnoreCase(checkAnuncioVal)){
			checkAnuncio.get(0).click();
		} else {
			checkAnuncio.get(1).click();
		}
		comboProtocolo.selectByValue(urlVal);
		campoUrl.sendKeys(urlCaminhoVal);
		
		if(checkSegmentacao.get(0).getAttribute("value").equalsIgnoreCase(checkSegmentacaoVal)){
			checkSegmentacao.get(0).click();
		} else {
			checkSegmentacao.get(1).click();
		}
		
		botaoAdicionarSegmentacao.click();
		
		campoDataInicio.sendKeys(dataInicioVal);
		campoDataFim.sendKeys(dataFimVal);
		
		if(checkVeiculacao.get(0).getAttribute("value").equalsIgnoreCase(chekVeiculacaoVal)){
			checkVeiculacao.get(0).click();
		} else {
			checkVeiculacao.get(1).click();
		}
		
		campoMeta.sendKeys(metaVal);
		comboGarantia.selectByValue(garantiaVal);
		campoPreco.sendKeys(precoVal);
		botaoCriarCampanha.click();
	}
	
	//metodo que faz upload de arquivo para o sistema
	public void enviarArquivo(String caminhoArquivoVal) throws AWTException{
		campoArquivo = driver.findElement(By.id("upload"));
		
		campoArquivo.click();
		
		StringSelection ss = new StringSelection(caminhoArquivoVal);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.delay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, 300); //5min
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.className("upload-container"), By.tagName("figure")));
	}
}
