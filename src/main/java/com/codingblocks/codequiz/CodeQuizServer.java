package com.codingblocks.codequiz;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import static io.undertow.Handlers.path;

/**
 * Created by championswimmer on 21/12/16.
 */
public class CodeQuizServer {

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .setIoThreads(4)
                .addHttpListener(6969, "localhost")
                .setHandler(path()
                        .addPrefixPath("/api/v1", new CodeQuizApiHandler())
                        .addPrefixPath("/", new DefaultHttpHandler()))
                .build();

        server.start();
        System.out.println("Server started at http://localhost:6969");
    }

    static class DefaultHttpHandler implements HttpHandler {

        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
            exchange.getResponseSender().send("Code Quiz API Server");
        }
    }
}
