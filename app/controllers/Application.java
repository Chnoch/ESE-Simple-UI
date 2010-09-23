package controllers;

import models.*;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
//        Contribution question = Question.find("order by timestamp desc").first();
        Contribution question = new Question("Dies ist eine Frage", new User("Hans"));
        render(question);
    }

}