package models;

public class DownVote extends Vote {

	public DownVote(User owner, Contribution contribution) {
		super(owner, contribution);
		contribution.addDownVote(this);
		this.save();
	}
}
