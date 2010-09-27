package models;

import java.util.ArrayList;
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
		this.contributions = new ArrayList<Contribution>();
		this.save();
	}
	
	public void postQuestion(String content) {
	    Question question = new Question(content, this);
	    contributions.add(question);
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
	
	public boolean equals(User user) {
	    return this.name.equals(user.name);
	}
}
