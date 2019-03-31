package com.parthshah.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

public class ReadUserInput 
{
	static String path="./UserDetails.properties";
	public static String getUsername() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String uname=prop.getProperty("sUsername");
				//System.out.print(uname+" ");
				
				return uname;
		}
	
	public static String getUserEmailID() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String emailid=prop.getProperty("sEmail");
				//System.out.print(emailid+" ");
				
				return emailid;
		}
	
	public static String getUserPassword() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String password=prop.getProperty("sPassword");
				//System.out.print(password+" ");
				
				return password;
		
	}
	
	public static String getUserConfirmPassword() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String cPassword=prop.getProperty("sConPassword");
				//System.out.print(cPassword+"\n");
				
				return cPassword;
		
	}
}
