package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public String name;
	
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
