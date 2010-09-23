package models;

import java.util.List;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {

	public String name;
	
	@ManyToOne
	public Vote votes;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	public List<Contribution> contributions;

	public User(String name) {
		this.name = name;
		this.save();
	}
	
	public void deleteUser() {
		deleteVotes();
		deleteAnswers();
		this.delete();
	}

	private void deleteAnswers() {
		for (Contribution contribution : this.contributions){
			contribution.delete();
		}
	}

	private void deleteVotes() {
		List<Vote> votesList = this.votes.find("byName", this.name).fetch();
		for (Vote vote : votesList) {
			vote.delete();
		}
		
	}
}
