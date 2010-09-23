package models;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class DownVote extends Vote {

	public DownVote(User owner, Contribution contribution) {
		super(owner, contribution);
	}
}
