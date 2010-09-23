package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public abstract class Contribution extends Model {

	@ManyToOne
	protected User owner;
	protected Date timestamp;
	@Lob
	protected String content;
	@ManyToOne
	protected Vote vote;
	
	public Contribution(String content, User owner) {
		this.timestamp = new Date();
		this.owner = owner;
	}
}
