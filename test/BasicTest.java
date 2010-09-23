import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	User fritz;
	Question question;

	@Before
	public void setup() {
		Fixtures.deleteAll();
		fritz = new User("Fritz").save();
		question = new Question("How tall is George Clooney", fritz).save();
	}
	
    @Test
    public void testUserName() {
    	assertNotNull(User.find("byName", fritz));
    	assertEquals("Fritz", User.find("byName",fritz));
    }
    
    @Test
    public void testQuestionOwnedByUser() {
    	assertEquals(fritz,Question.find("byOwner",question));
    }

}