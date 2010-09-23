package models;

import java.util.Date;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public abstract class Contribution extends Model {

	@ManyToOne
	protected User owner;
	protected Date timestamp;
	@Lob
	protected String content;
	protected Vote vote;
	
	public Contribution(String content, User owner) {
		this.timestamp = new Date();
		this.owner = owner;
	}
}
