package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.dummy_utils.DummyChallenge;
import com.codingblocks.codequiz.dummy_utils.DummyQuestions;
import com.codingblocks.codequiz.models.*;
import com.codingblocks.codequiz.utils.ReadQuery;
import com.google.gson.*;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;

import java.util.ArrayList;

/**
 * Created by piyush0 on 30/12/16.
 */
public class ChallengeHandler extends RoutingHandler {

    public ChallengeHandler() {
        super();
        this.post("/create", this::POST_createChallenge);
        this.get("/{challengeId}", this::getChallengeQuestions);
        this.post("/submit/{challengeId}", this::POST_submitChallenge);
        this.get("/{challengeId}/result", this::GET_challengeResult);
        this.get("/me", this::GET_myChallenges);
    }

    private void GET_myChallenges(HttpServerExchange exchange) throws Exception {
        ArrayList<ChallengeSmall> challengeSmall = DummyChallenge.getDummyChallengeSmalls();
        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(challengeSmall));
    }

    private void GET_challengeResult(HttpServerExchange exchange) throws Exception {
        int id = Integer.valueOf(exchange.getQueryParameters().get("challengeId").getFirst());

        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(getChallenge(id)));
    }

    private Challenge getChallenge(Integer id) {

        //TODO: Make this better.
        return DummyChallenge.getDummyChallenges().get(0);
    }

    private void POST_submitChallenge(HttpServerExchange exchange) throws Exception {
        if (exchange.isInIoThread()) {
            exchange.dispatch(this::POST_createChallenge);
            return;
        }
        Gson gson = new Gson();

        JsonElement object = new JsonParser().parse(ReadQuery.read(exchange));
        Submission submission = gson.fromJson(object, Submission.class);
        Integer id = Integer.valueOf(exchange.getQueryParameters().get("challengeId").getFirst());
        registerSubmissionInDb(id, submission);
    }

    private void registerSubmissionInDb(Integer challengeId, Submission submission) {
        //TODO:
    }

    private void getChallengeQuestions(HttpServerExchange exchange) throws Exception {

        int id = Integer.valueOf(exchange.getQueryParameters().get("challengeId").getFirst());

        ArrayList<Question> questions = getChallengeQuestions(id);
        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(questions));
    }

    private ArrayList<Question> getChallengeQuestions(Integer challengeId) {
        return DummyQuestions.getDummyQuestions();
    }

    private void POST_createChallenge(HttpServerExchange exchange) throws Exception {
        if (exchange.isInIoThread()) {
            exchange.dispatch(this::POST_createChallenge);
            return;
        }
        Gson gson = new Gson();
        JsonObject object = (JsonObject) new JsonParser().parse(ReadQuery.read(exchange));

        Integer numQues = gson.fromJson(object.get("numQues"), Integer.class);
        ArrayList<Integer> users = getUsers(object.getAsJsonArray("users"), gson);
        String topic = gson.fromJson(object.get("topic"), String.class);

        int cId = getChallengeId(users, numQues, topic);
        System.out.println(cId);

        exchange.getResponseSender().send(gson.toJson(cId));

    }

    private ArrayList<Integer> getUsers(JsonArray users, Gson gson) {
        ArrayList<Integer> retVal = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            Integer u = gson.fromJson(users.get(i), Integer.class);
            retVal.add(u);
        }

        return retVal;
    }

    private int getChallengeId(ArrayList<Integer> users, Integer numQues, String topic) {
        return 1; // TODO: Make this better.
    }

}
