package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.models.Question;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/**
 * Created by championswimmer on 21/12/16.
 */
public class QuestionHandler implements HttpHandler {

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {

        EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .minCollectionSize(3).maxCollectionSize(5)
                .build();
        Question q = random.nextObject(Question.class);

        exchange.getResponseSender().send(q.toString());
    }
}
