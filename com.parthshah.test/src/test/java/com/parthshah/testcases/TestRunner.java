/**
 * 
 */
package com.parthshah.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
public class TestRunner 
{
	public static String sBrowser="chrome";
	public static String sURL="http://85.93.17.135:9000/users/all";
	public static WebDriver driver=BrowserFactory.startBrowser(sBrowser, sURL);
	public static WebDriverWait wait = new WebDriverWait(driver,3);
	
	@Test
	@Order(1)
	public void verifyAllUserPage_AllRecord() throws IOException, Exception
	{		
		AllUserPage.verifyAllUserPageTitle();
		AllUserPage.getAllUserId();
		AllUserPage.getAllUserName();
		AllUserPage.getAllUserEmail();
		AllUserPage.getAllUserPassword();
		AllUserPage.verifyNewUserNameUI();
		AllUserPage.navigateToLoginPage();
	}
	
	@Test
	@Order(2)
	public void deleteAllUsersAPI() throws IOException, Exception
	{
		System.out.println("----------Deleting all records-----------");
		DeleteAPIData.deleteAllUser();
	}
	
	/*
	@Test
	@Order(3)
	public void verifyNewUserAPIAgain() throws IOException, Exception
	{
		String sUsername=ReadUserInput.getUsername();
		System.out.println("\n----------Verifying username in API after deleting records-----------");
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
*/

	/*	
	@Test
	@Order(6)
	public void verifyAllUserPage_NoRecordUI() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(3000);
		AllUserPage.verifyNoUserFound();
	}
	
*/
	
	
	@AfterAll
	public static void closingSessionWindow()
	{
		BrowserFactory.closeBrowser();
	}
}
