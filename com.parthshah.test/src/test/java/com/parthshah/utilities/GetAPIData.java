package com.parthshah.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.parthshah.testcases.LoginPageTest;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

public class GetAPIData 
{
	static String sURL="http://85.93.17.135:9000/user/all/json";
	public static Response resp=get(sURL);
	static String sResponseData;
	public static JsonPath jsonPathEvaluator=resp.jsonPath();
	
	
	public static void getAllUserStatusCode()
	{
		int iStatusCode=resp.getStatusCode();
		System.out.println("Status code is: " +iStatusCode);
		assertEquals(iStatusCode, 200);
	}
		
	public static void getAllUserResponseData()
	{ 
		
		sResponseData=resp.body().asString();
	
		System.out.println("All Users are as follows:\n " +sResponseData);
		
	}
	
	public static boolean verifyUserPresent(String Username)
	{
		List<String> name= jsonPathEvaluator.getList("name");
		boolean status = false;
		for(String name1:name)
		{
			//System.out.println(name1);//Displaying names present in the list
			
			if(name1.equals(Username))
			{
				//System.out.println(Username+" is an existing user");
				status=true;
				break;
			}
		}
		return status;
	}
	
	public static boolean verifyEmailPresent(String EmailId)
	{
		List<String> email= jsonPathEvaluator.getList("email");
		boolean status = false;
		for(String email1:email)
		{
			//System.out.println(email1);//Displaying email present in the list
			
			if(email1.equals(EmailId))
			{
				//System.out.println(EmailId+" is an existing emailid");
				status=true;
				break;
			}
		}
		return status;
	}
	
	public static boolean verifyPasswordPresent(String Password)
	{
		List<String> pass= jsonPathEvaluator.getList("password");
		boolean status = false;
		for(String pass1:pass)
		{
			System.out.println(pass1);//Displaying password present in the list
			
			if(pass1.equals(Password))
			{
				//System.out.println(Password+" is an existing Password");
				status=true;
				break;
			}
		}
		return status;
	}
		
	public static void getAllUserResponseTime()
	{
		long lResponseTime=resp.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time for this API in Milliseconds: "+ lResponseTime);
	}
	
	
}
