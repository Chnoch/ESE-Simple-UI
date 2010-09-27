package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.db.jpa.Model;

public abstract class Contribution extends Model {

	public User owner;
	public Date timestamp;
	public String content;
	public List<Vote> upVotes;
	public List<Vote> downVotes;
	
	public Contribution(String content, User owner) {
		this.timestamp = new Date();
		this.owner = owner;
		this.content = content;
		this.upVotes = new ArrayList<Vote>();
		this.downVotes = new ArrayList<Vote>();
	}
	
	public void addUpVote(Vote vote) {
	    this.upVotes.add(vote);
	    this.save();
	}
	
	public int getUpVotes() {
	    return this.upVotes.size();
	}
	
	public void addDownVote(Vote vote) {
	    this.downVotes.add(vote);
	    this.save();
	}
	
	public int getDownVotes() {
	    return this.downVotes.size();
	}
}
