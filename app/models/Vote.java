package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public abstract class Vote extends Model {
	
	public Contribution contribution; 
	public User owner;
	
	public Vote(User owner, Contribution contribution) {
		this.owner = owner;
		this.contribution = contribution;
	}
}
