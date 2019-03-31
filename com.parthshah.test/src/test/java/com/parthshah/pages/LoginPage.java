package com.parthshah.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parthshah.testcases.LoginPageTest;
import com.parthshah.testcases.TestRunner;
import com.parthshah.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage
{
 
	public WebDriver driver=LoginPageTest.driver;
	public WebDriverWait wait=LoginPageTest.wait;

	//WebElemets on LoginPage
	WebElement loginPageTitle=driver.findElement(By.xpath("//h1[contains(text(),'New User')]"));
	WebElement userName=driver.findElement(By.id("name"));
	WebElement userEmail=driver.findElement(By.id("email"));
	WebElement userPassword=driver.findElement(By.id("password"));
	WebElement userConfirmPassword=driver.findElement(By.id("confirmationPassword"));
	WebElement btnAllUser=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
	WebElement btnSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
	
	public void verifyPageTitle()
	{
		String sPageTitleExpected="New User";
		String sPageTitleActual;
		sPageTitleActual=loginPageTitle.getText();
		assertEquals(sPageTitleExpected, sPageTitleActual, "Page Title does not match!");
		System.out.println("New User Page Opened Successfully!");
	}
	
	public void enterUserName(String sUName)
	{
		userName.clear();
		userName.sendKeys(sUName);
	}
	
	public void enterUserEmail(String sUEmail)
	{
		userEmail.clear();
		userEmail.sendKeys(sUEmail);
	}
	
	public void enterUserPassword(String sUPassword)
	{
		userPassword.clear();
		userPassword.sendKeys(sUPassword);
	}
	
	public void enterUserConfirmPassword(String sUConfirmPassword)
	{
		userConfirmPassword.clear();
		userConfirmPassword.sendKeys(sUConfirmPassword);
	}
	
	public void clickSubmitButton() throws InterruptedException
	{
		btnSubmit.click();
		
		//usernameFieldValidation();
		//emailFieldValidation();
		//passwordFieldValidation();
		//confirmPasswordFieldValidation();
	}
	
	public void addNewUser(String sUserName, String sEmail, String sPass, String sConfirmPass) throws InterruptedException
	{
		wait.until(ExpectedConditions.titleContains("New User"));
		enterUserName(sUserName);
		enterUserEmail(sEmail);
		enterUserPassword(sPass);
		enterUserConfirmPassword(sConfirmPass);
		clickSubmitButton();
	}
	
	public void navigateToAllUserPage()
	{
		wait.until(ExpectedConditions.titleContains("New User"));
		if(driver.getTitle().equalsIgnoreCase("New User"))
		{
			btnAllUser.click();
			wait.until(ExpectedConditions.titleContains("All User"));
		}
	}
	
	public void usernameFieldValidation() throws InterruptedException
	{
		Thread.sleep(3000);

		WebElement userValidation=driver.findElement(By.xpath("//p[@id='user.name.error']"));
		
		if(userValidation.getText().contains("Required"))
		{
			System.out.println("Username is required");
		}
		else if(userValidation.getText().contains("Must be unique"))
		{
			System.out.println("Username is already present");
		}
	}
	
	public void emailFieldValidation() throws InterruptedException
	{
		
		Thread.sleep(3000);

		WebElement emailValidation=driver.findElement(By.xpath("//p[@id='user.email.error']"));
		
		if(emailValidation.getText().contains("Required"))
		{
			System.out.println("EmailID is required");
		}
		else if(emailValidation.getText().contains("Must be unique"))
		{
			System.out.println("EmailID is already present");
		}
		else if(emailValidation.getText().contains("Invalid email address"))
		{
			System.out.println("Entered invalid EmailId");
		}
	}
	
		public void passwordFieldValidation() throws InterruptedException
		{	
			Thread.sleep(3000);

			WebElement passwordValidation=driver.findElement(By.xpath("//p[@id='user.password.error']"));
			
			if(passwordValidation.getText().contains("Required"))
			{
				System.out.println("Password is required");
			}
			else if(passwordValidation.getText().contains("Minimum size is 6"))
			{
				System.out.println("Minimum size is 6 for Password");
			}
		
		}
		
		public void confirmPasswordFieldValidation() throws InterruptedException
			{
				
				Thread.sleep(3000);

				WebElement passwordValidation=driver.findElement(By.xpath("//p[@id='user.confirmationPassword.error']"));
			
				if(passwordValidation.getText().contains("passwords are not the same"))
				{
					System.out.println("Cofirm Password is not matching");
				}
				
			}
}
