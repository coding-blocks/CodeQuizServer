package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.dummy_utils.DummyQuestions;
import com.codingblocks.codequiz.models.Question;
import com.google.gson.Gson;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by championswimmer on 21/12/16.
 */
public class QuestionHandler extends RoutingHandler {

    public QuestionHandler() {
        super();
        this.get("/archive/{quesId}", this::GET_questionById);
        this.get("/archive", this::GET_archive);
        this.get("/today", this::GET_today);
        this.post("/add", this::POST_add);
    }


    private void GET_today(HttpServerExchange exchange) throws Exception {

    }

    private void GET_questionById(HttpServerExchange exchange) throws Exception {

        //TODO: Make this better
        int id = exchange.getRequestURL().charAt(exchange.getRequestURL().length() - 1) - 48;
        Question question = null;
        ArrayList<Question> questions = DummyQuestions.getDummyQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (id == questions.get(i).getId()) {
                question = questions.get(i);
            }
        }

        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(question));
    }


    private void GET_archive(HttpServerExchange exchange) throws Exception {

        ArrayList<Question> questions = DummyQuestions.getDummyQuestions();
        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(questions));
    }

    private void POST_add(HttpServerExchange exchange) throws Exception {

    }


}
