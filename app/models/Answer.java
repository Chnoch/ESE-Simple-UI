package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Answer extends Contribution {

	@ManyToOne
	private Question question;
	
	public Answer(String content, Question question, User owner) {
		super(content, owner);
		this.save();
	}
}
