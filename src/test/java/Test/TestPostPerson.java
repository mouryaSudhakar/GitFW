package Test;

import static org.testng.Assert.assertNotNull;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServiceHelper;

public class TestPostPerson {
	public PersonServiceHelper personServicehelper;

	@BeforeClass
	public void init() {
		personServicehelper = new PersonServiceHelper();

	}

	@Test
	public void testPostCreatPerson() {
		String id = personServicehelper.createPerson().jsonPath().getString("id");
		System.out.println(id);
		assertNotNull(id, "Person id is not null");
	}

}