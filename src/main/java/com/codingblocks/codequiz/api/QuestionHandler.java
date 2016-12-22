package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.models.Question;
import com.google.gson.Gson;
import com.sun.media.jfxmedia.logging.Logger;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.undertow.predicate.Predicate;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;
import io.undertow.server.handlers.PathHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by championswimmer on 21/12/16.
 */
public class QuestionHandler extends RoutingHandler {

    public QuestionHandler() {
        super();
        this.get("/archive", this::GET_archive);
        this.get("/today", this::GET_today);
        this.setFallbackHandler(this::GET_archive);
    }


    private void GET_today(HttpServerExchange exchange) throws Exception {

    }

    private void GET_archive(HttpServerExchange exchange) throws Exception {
        EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .minCollectionSize(3).maxCollectionSize(5)
                .build();
        ArrayList<Question> questions = random.objects(Question.class, 10)
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList<Question>::new));
        Gson gson = new Gson();

        exchange.getResponseSender().send(gson.toJson(questions));

    }



}
