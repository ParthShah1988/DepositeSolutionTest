/**
 * 
 */
package com.parthshah.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parthshah.pages.AllUserPage;
import com.parthshah.pages.LoginPage;
import com.parthshah.utilities.BrowserFactory;
import com.parthshah.utilities.DeleteAPIData;
import com.parthshah.utilities.GetAPIData;
import com.parthshah.utilities.ReadUserInput;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Parth Shah
 *
 */

public class LoginPageTest 
{


	public static WebDriver driver=BrowserFactory.startBrowser("chrome", "http://85.93.17.135:9000/user/new");
	public static WebDriverWait wait = new WebDriverWait(driver,3);
	
	@Test
	@Order(1)
	public void verifyLoginPage() throws IOException, Exception
	{
		LoginPage login = new LoginPage();
		login.verifyPageTitle();
	}
	
	@Test
	@Order(2)
	public void addNewUserSuccessful() throws IOException, Exception
	{
		String sUsername=ReadUserInput.getUsername();
		String sEmail=ReadUserInput.getUserEmailID();
		String sPassword=ReadUserInput.getUserPassword();
		String sConPassword=ReadUserInput.getUserConfirmPassword();
		
		LoginPage login = new LoginPage();
		login.addNewUser(sUsername,sEmail,sPassword,sConPassword);
		//wait.until(ExpectedConditions.titleContains("New User"));
		//assertTrue(driver.getTitle().equalsIgnoreCase("All User"),"New User not added successfully");
		
		if(driver.getTitle().equalsIgnoreCase("All User"))
		{
			System.out.println("Data Added successfully!");
		}
		else if(driver.getTitle().equalsIgnoreCase("New User"))
		{
			System.out.println("Data not added successfully!!!!!!!!!!!");
		}
	}
	
	@Test
	@Order(3)
	public void verifyNewUserAPI_Username() throws IOException, Exception
	{
		String sUsername=ReadUserInput.getUsername();
		System.out.println("----------Verifying username in API before deleting records-----------");
		
		GetAPIData.getAllUserResponseData();
		boolean userStatus;
		userStatus=GetAPIData.verifyUserPresent(sUsername);
		if(userStatus)
		{
			System.out.println(sUsername+" username is present in API");
		}
		else
		{
			System.out.println(sUsername+" username not found in API");
		}
		GetAPIData.getAllUserStatusCode();
		GetAPIData.getAllUserResponseTime();
	}
	
	@Test
	@Order(4)
	public void verifyNewUserAPI_Email() throws IOException, Exception
	{
		String sEmail=ReadUserInput.getUserEmailID();
		System.out.println("----------Verifying emailid in API before deleting records-----------");
		
		GetAPIData.getAllUserResponseData();
		boolean emailStatus;
		emailStatus=GetAPIData.verifyEmailPresent(sEmail);
		if(emailStatus)
		{
			System.out.println(sEmail+" EmailID is present in API");
		}
		else
		{
			System.out.println(sEmail+" EmailID not found in API");
		}
		GetAPIData.getAllUserStatusCode();
		GetAPIData.getAllUserResponseTime();
	}
	
	@AfterAll
	public static void closingSessionWindow()
	{
		BrowserFactory.closeBrowser();
	}
	
}
