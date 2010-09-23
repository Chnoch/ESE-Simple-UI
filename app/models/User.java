package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {

	public String name;
	
	public Vote votes;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	public Contribution contributions;

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
		List<Contribution> contributionList = this.contributions.find("byName", this.name).fetch();
		for (Contribution  contribution : contributionList){
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
