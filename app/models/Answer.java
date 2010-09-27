package models;

public class Answer extends Contribution {

	public Question question;
	
	public Answer(String content, Question question, User owner) {
		super(content, owner);
		this.question = question;
		this.save();
	}
}
