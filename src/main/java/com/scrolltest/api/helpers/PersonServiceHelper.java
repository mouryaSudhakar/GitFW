package com.scrolltest.api.helpers;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.scrolltest.api.constants.EndPoints;
import com.scrolltest.api.model.Person;
import com.scrolltest.api.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PersonServiceHelper {																																																														

private static final String BASE_URL = ConfigManager.getInstance().getString( "base_url");
//private static final String ss = ConfigManager.getInstance().getString(null);	



public PersonServiceHelper() {
	RestAssured.baseURI = BASE_URL;
	//RestAssured.port = Integer.parseInt(PORT);
	RestAssured.useRelaxedHTTPSValidation();
	
}
	
	public List<Person> getAllPerson(){
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON).
				get(EndPoints.GET_ALL_PERSON).
				andReturn();
		
	Type type = new TypeReference<List<Person>>(){}.getType();
	
	assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"OK");
	
	List<Person> personList = response.as(type);
	return personList;
	}
	
	public Response createPerson() {
		
		Person person=new Person();
		person.setId(4); 
		person.setFirstName("Sudhakar");
		person.setLastName("Mourya");
		person.setContactNo("9733884444");
		person.setAddress("Mumbai");
		
		
		Response response=RestAssured.given().
				contentType(ContentType.JSON).
				when().
				body(person).
				post(EndPoints.CREATE_PERSON).
				andReturn();
		
assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED,"CREATED");
		
  return response;
		
	}
	 
	
	
}
