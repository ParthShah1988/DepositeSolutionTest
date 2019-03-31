/**
 * 
 */
package com.parthshah.utilities;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Parth Shah
 *
 */

public class BrowserFactory 
{
	static WebDriver driver;
	
	
	public static WebDriver startBrowser(String browserName, String URL)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "E:\\Parth\\Selenium Practice\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
}
