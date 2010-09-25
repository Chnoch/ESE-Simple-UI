package controllers;

import java.util.List;

import models.*;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        List<Contribution> questions = Question.find("order by timestamp desc").fetch();
        render(questions);
    }
    
    public static void form() {
        render();
    }
    
    public static void addQuestion(String username, String content) {
        List<User> users = User.find("find by name", username).fetch();
        User user;
        if (users.size()==0) {
            user = new User(username); 
        } else {
            user = users.get(0);
        }
        user.postQuestion(content);
        index();
    }
    
    public static void addAnswer(long questionId, 
            String username, String content) {
        Question question = Question.findById(questionId);
        User user = User.find("order by name desc", username).first();
        question.addAnswer(content, user);
        show(questionId);
    }
    
    public static void show(Long id) {
        Question question = Question.findById(id);
        render(question);
    }
}