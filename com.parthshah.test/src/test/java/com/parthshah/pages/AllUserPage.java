package com.parthshah.pages;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parthshah.testcases.LoginPageTest;
import com.parthshah.testcases.TestRunner;
import com.parthshah.utilities.BrowserFactory;
import com.parthshah.utilities.DeleteAPIData;
import com.parthshah.utilities.GetAPIData;
import com.parthshah.utilities.ReadUserInput;

import junit.framework.Assert;

public class AllUserPage 
{
		
	public static WebDriver driver=TestRunner.driver;
	public static WebDriverWait wait=TestRunner.wait;
	
	//WebElemets on All User Page
	static WebElement allUserPageTitle=driver.findElement(By.xpath("//h1[contains(text(),'All User')]"));
	 static List<WebElement> recordId=driver.findElements(By.xpath("//div[@class='span6 offset3']//tbody/tr"));
	 static List<WebElement> recordUsername=driver.findElements(By.xpath("//div[@class='span6 offset3']//tbody/tr/td[1]"));
	 static List<WebElement> recordEmail=driver.findElements(By.xpath("//div[@class='span6 offset3']//tbody/tr/td[2]"));
	 static List<WebElement> recordPassword=driver.findElements(By.xpath("//div[@class='span6 offset3']//tbody/tr/td[3]"));
	 static WebElement btnNewUser=driver.findElement(By.xpath("//a[@class='btn btn-default']"));
	 

	public static void verifyAllUserPageTitle()
	{
		wait.until(ExpectedConditions.titleContains("All User"));
		assertTrue(driver.getTitle().equalsIgnoreCase("All User"),"New User not added successfully");
		System.out.println("All User Page Opened Successfully!");
	}
	
	public static void getAllUserId()
	{
		System.out.println("Total Number of Records: "+(recordId.size()));
		System.out.println("-----User ID List-----");
		for (WebElement userId:recordId)
		{
			System.out.println(userId.getAttribute("id"));
		}	
	}
	
	public static void getAllUserName()
	{
		System.out.println("-----User Name List-----");
		for (WebElement userName:recordUsername)
		{
			System.out.println(userName.getText());
		}
	}
	
	
	public static void getAllUserEmail()
	{
		System.out.println("-----User Email List-----");
		for (WebElement userEmail:recordEmail)
		{
			System.out.println(userEmail.getText());
		}
	}
	
	public static void getAllUserPassword()
	{
		System.out.println("-----User Password List-----");
		for (WebElement userPassword:recordPassword)
		{
			System.out.println(userPassword.getText());
		}
	}
	
	public static void navigateToLoginPage()
	{
		btnNewUser.click();
		wait.until(ExpectedConditions.titleContains("New User"));
		assertTrue(driver.getTitle().equalsIgnoreCase("New User"),"Navigate Back to Login Page failed!");
		System.out.println("Back to New User Page...");
	}

	public boolean isUserNamePresent(String Uname)
	{
		boolean isPresent=false;
		for (WebElement userName1:recordUsername)
		{
			if(userName1.getText().equals(Uname))
			{
				isPresent=true;
				break;
			}
		}
		return isPresent;
	}
	
	public static void verifyNewUserNameUI() throws IOException, Exception
	{
		AllUserPage ap = new AllUserPage();
		String uName=ReadUserInput.getUsername();
		boolean uNamePresent=ap.isUserNamePresent(uName);
		if(uNamePresent)
		{
			System.out.println(uName+" username is visible on Page");
		}
		else
		{
			System.out.println(uName+" username not found on Page");
		}
	}
	
	public static void verifyNoUserFound()
	{
		WebElement lbNoUser=driver.findElement(By.xpath("//td[@colspan='3']"));
		wait.until(ExpectedConditions.titleContains("All User"));
		if(lbNoUser.isDisplayed())
		{
			System.out.println("No Users Found!!!");
		}
		else
		{
			System.out.println("Users still exists !!!");
		}
	}
/*
	public void verifyAllUserPage_AllRecord() throws InterruptedException
	{
		
		verifyAllUserPageTitle();
		getAllUserId();
		getAllUserName();
		getAllUserEmail();
		getAllUserPassword();
		navigateToLoginPage();
	}
	
	public static void verifyAllUserPage_NoRecord() throws InterruptedException
	{
		verifyAllUserPageTitle();
		getAllUserId();
		getAllUserName();
		getAllUserEmail();
		getAllUserPassword();
		verifyNoUserFound();
		navigateToLoginPage();
	}
	*/
	
}
