package models;

import play.db.jpa.Model;

public abstract class Vote extends Model {
	
	public Contribution contribution; 
	public User owner;
	
	public Vote(User owner, Contribution contribution) {
		this.owner = owner;
		this.contribution = contribution;
	}
}
