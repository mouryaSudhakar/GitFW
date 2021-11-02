package Test;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.scrolltest.api.model.Person;
import com.scrolltest.api.helpers.PersonServiceHelper;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;
import org.testng.annotations.BeforeClass;

public class TestGetPerson
{
	private PersonServiceHelper personServiceHelper;
	
@BeforeClass
public void init(){
	
personServiceHelper =new PersonServiceHelper();

}

@Test
public void TestGetAllPerson(){
	
List<Person>personList=personServiceHelper.getAllPerson();
assertNotNull(personList,"Person List is not Empty");
assertFalse(personList.isEmpty(),"Person List is not True");

   }

}