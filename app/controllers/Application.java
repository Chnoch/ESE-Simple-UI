package controllers;

import java.util.Iterator;
import java.util.List;

import models.*;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        List<Contribution> questions = Question.find("").fetch();
        render(questions);
    }
    
    public static void form() {
        render();
    }
    
    public static void addQuestion(String owner, String content) {
        List<User> users = User.find("byName").fetch();
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
    
    public static void addAnswer(long questionId, 
            String username, String content) {
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