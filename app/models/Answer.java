package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Answer extends Contribution {

	@ManyToOne
	public Question question;
	
	public Answer(String content, Question question, User owner) {
		super(content, owner);
		this.save();
	}
}
