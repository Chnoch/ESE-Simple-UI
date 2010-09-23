package models;

import javax.persistence.Entity;

@Entity
public class UpVote extends Vote {
	
	public UpVote(User owner, Contribution contribution) {
		super(owner, contribution);
	}

}
