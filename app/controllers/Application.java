package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {
	public static List<Contribution> questions;
	public static List<User> users;

	@Before
	public static void setup() {
		questions = new ArrayList<Contribution>();
		users = new ArrayList<User>();
	}

	public static void index() {
		render(questions);
	}

	public static void form() {
		render();
	}

	public static void addQuestion(String owner, String content) {
		User user = new User(owner);
		if (users.contains(user)) {
			Iterator<User> it = users.iterator();
			while (it.hasNext() && !it.next().equals(user)) {
			}
			user = it.next();
		}
		user.postQuestion(content);
		index();
	}

	public static void addAnswer(long questionId, String username,
			String content) {
		Question question = Question.findById(questionId);
		User user = User.find("byName", username).first();
		question.addAnswer(content, user);
		show(questionId);
	}

	public static void show(Long id) {
		Question question = Question.findById(id);
		render(question, question.answers);
	}
}