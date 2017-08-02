package com.sambatech.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sambatech.java.config.Configuration;

public class Driver {
	public static WebDriver driver;
	
	//metodo que cria instancia do driver somente uma vez
	public static WebDriver getInstance() {
		if (driver == null) {
			//define propriedade de ambiente no SO para localizacao do driver
			System.setProperty("webdriver.gecko.driver", Configuration.caminhoProjeto + "\\lib\\drivers\\geckodriver.exe");
			System.out.println(Configuration.caminhoProjeto + "\\lib\\drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
	//metodo que fecha o browser
	public static void close() {
		driver.close();
	}
}
