package models;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class UpVote extends Vote {
	
	public UpVote(User owner, Contribution contribution) {
		super(owner, contribution);
	}

}
