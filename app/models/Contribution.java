package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public abstract class Contribution extends Model {

	@ManyToOne
	public User owner;
	public Date timestamp;
	public String content;
	@OneToMany
	public List<Vote> upVotes;
	@OneToMany
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
