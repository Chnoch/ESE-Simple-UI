package models;

import java.util.ArrayList;
import java.util.List;

import play.db.jpa.Model;

public class User extends Model {

	public String name;
	
	public List<Vote> votes;
	
	public List<Contribution> contributions;

	public User(String name) {
		this.name = name;
		this.contributions = new ArrayList<Contribution>();
	}
	
	public void postQuestion(String content) {
	    Question question = new Question(content, this);
	    contributions.add(question);
	}
	
	public void deleteUser() {
		deleteVotes();
		deleteAnswers();
	}

	private void deleteAnswers() {
		for (Contribution contribution : this.contributions){
			contribution.delete();
		}
	}

	private void deleteVotes() {
		for (Vote vote : this.votes) {
			vote.delete();
		}
	}
	
	public boolean equals(User user) {
	    return this.name.equals(user.name);
	}
}
