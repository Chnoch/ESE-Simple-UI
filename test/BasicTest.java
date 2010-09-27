
import org.junit.Before;
import org.junit.Test;

import models.*;
import play.test.*;

public class BasicTest extends UnitTest {

	User fritz;
	Question question;
	Answer answer;
	Vote upVote, downVote;
	
	@Before
	public void setup() {
	    fritz = new User("Fritz").save();
	    question = new Question("How tall is George Clooney", fritz).save();
	    answer = new Answer("Tall", question, fritz);
	    downVote = new DownVote(fritz, question);
	    
	}

    @Test
    public void testUserName() {
    	assertNotNull(User.find("byName", "Fritz").first());
    	User user = User.find("byName", "Fritz").first();
    	assertEquals("Fritz", user.name);
    }
    
    @Test
    public void testQuestionOwnedByUser() {
        Question question = Question.find("byOwner", fritz).first();
    	assertEquals(fritz , question.owner);
    }
    
    @Test
    public void testContributionContent() {
        Question newQuestion = Question.find("byContent","How tall is George Clooney").first();
        Answer newAnswer = Answer.find("byContent","Tall").first();
        assertNotNull(newQuestion);
        assertNotNull(newAnswer);
        assertEquals("How tall is George Clooney", newQuestion.content);
        assertEquals("Tall", newAnswer.content);
    }
    
    @Test
    public void testContributionTimestamp() {
        Question newQuestion = Question.find("byContent","How tall is George Clooney").first();
        Answer newAnswer = Answer.find("byContent","Tall").first();
        assertNotNull(newQuestion.timestamp);
        assertNotNull(newAnswer.timestamp);
    }
    
    @Test
    public void testAnswerBelongsToQuestion() {
        Answer answered = Answer.find("byQuestion", question).first();
        assertNotNull(answered);
        assertEquals(answered.question, question);
    }
    
    @Test
    public void testContributionVoting() {
        assertEquals(1, question.downVotes.size());
    }

}
