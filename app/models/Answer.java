package models;

import javax.persistence.*;
import play.db.jpa.*;


@Entity
public class Answer extends Contribution {

	@ManyToOne
	private Question question;
	
	public Answer(String content, Question question, User owner) {
		super(content, owner);
		this.save();
	}
}
