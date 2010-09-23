package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public abstract class Vote extends Model {
	
	@ManyToOne
	public Contribution contribution; 
	@ManyToOne
	public User owner;
	
	public Vote(User owner, Contribution contribution) {
		this.owner = owner;
		this.contribution = contribution;
		this.save();
	}
}
