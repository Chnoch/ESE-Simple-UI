package models;

import java.util.ArrayList;
import java.util.List;

public class Question extends Contribution {

	public List<Answer> answers;
	
	public Question(String content, User owner) {
		super(content, owner);
		answers = new ArrayList<Answer>();
		this.save();
	}
	
	public void addAnswer(String content, User owner) {
		Answer answer = new Answer(content, this, owner);
		this.answers.add(answer);
		this.save();
	}
	
	public void removeAnswer(Answer answer) {
		answers.remove(answer);
		answer.delete();
		this.save();
	}

}