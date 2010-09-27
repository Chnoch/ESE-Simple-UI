package models;

public class UpVote extends Vote {
	
	public UpVote(User owner, Contribution contribution) {
		super(owner, contribution);
		contribution.addUpVote(this);
		this.save();
	}

}
