package com.parthshah.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAPIData 
{
	static String sURL="http://85.93.17.135:9000/user/all";
	public static Response response=get(sURL);
	
	public static void deleteAllUser()
	{
		RequestSpecification request= RestAssured.given();
		response=request.delete(sURL);
		System.out.println("All user records deleted successfully!!!");
		
		int iStatusCode=response.getStatusCode();
		System.out.println("Status code for delete is: " +iStatusCode);
		assertEquals(iStatusCode, 200);
		
		long lResponseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time for delete API in Milliseconds: "+ lResponseTime);
		
	}
}
