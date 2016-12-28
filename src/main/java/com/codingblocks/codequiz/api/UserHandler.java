package com.codingblocks.codequiz.api;

import com.codingblocks.codequiz.dummy_utils.DummyUser;
import com.codingblocks.codequiz.models.User;
import com.google.gson.Gson;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;

import java.util.ArrayList;

/**
 * Created by piyush0 on 27/12/16.
 */
public class UserHandler extends RoutingHandler {

    public UserHandler() {
        super();
        this.get("/list", this::GET_users);
        this.get("/{userId}", this::GET_usersById);
    }

    private void GET_users(HttpServerExchange exchange) throws Exception {
        ArrayList<User> users = DummyUser.getUsers();

        Gson gson = new Gson();
        exchange.getResponseSender().send(gson.toJson(users));
    }

    private void GET_usersById(HttpServerExchange exchange) throws Exception {
        ArrayList<User> users = DummyUser.getUsers();
        User response = null;
        Integer id = (Integer.valueOf(exchange.getQueryParameters().get("userId").getFirst()));

        for (User u : users) {
            if (u.getUnique_id().equals(id)) {
                response = u;
                break;
            }
        }

        Gson gson = new Gson();
        exchange.getResponseSender().send(gson.toJson(response));
    }
}
