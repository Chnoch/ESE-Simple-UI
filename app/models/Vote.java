package models;

import javax.persistence.*;
import play.db.jpa.*;

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
