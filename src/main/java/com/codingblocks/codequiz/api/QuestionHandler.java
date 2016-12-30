package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.dummy_utils.DummyQuestions;
import com.codingblocks.codequiz.models.Question;
import com.codingblocks.codequiz.models.Topic;
import com.codingblocks.codequiz.models.User;
import com.codingblocks.codequiz.utils.ReadQuery;
import com.google.gson.*;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


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
        this.post("/archive", this::POST_questionByFilter);

    }

    private void POST_questionByFilter(HttpServerExchange exchange) throws Exception {
        if (exchange.isInIoThread()) {
            exchange.dispatch(this::POST_questionByFilter);
            return;
        }

        JsonObject object = (JsonObject) new JsonParser().parse(ReadQuery.read(exchange));

        Gson gson = new Gson();

        ArrayList<Question> questions = getQuestionsBasedOnFilter(getFilters
                        (object.getAsJsonArray("filters"), gson),
                gson.fromJson(object.get("sortBy"), String.class));


        exchange.getResponseSender().send(gson.toJson(questions));

    }

    private ArrayList<String> getFilters(JsonArray filters, Gson gson) {

        ArrayList<String> retVal = new ArrayList<>();

        for (int i = 0; i < filters.size(); i++) {
            String topic = gson.fromJson(filters.get(i), String.class);
            retVal.add(topic);
        }

        return retVal;
    }

    private ArrayList<Question> getQuestionsBasedOnFilter(ArrayList<String> filters, String sortBy) {
        return DummyQuestions.getDummyQuestions();
    }

    private void GET_today(HttpServerExchange exchange) throws Exception {
        Question question = DummyQuestions.getDummyQuestions().get(DummyQuestions.getDummyQuestions().size() - 2);
        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(question));
    }

    private void GET_questionById(HttpServerExchange exchange) throws Exception {

        int id = Integer.valueOf(exchange.getQueryParameters().get("quesId").getFirst());
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
