package com.codingblocks.codequiz;

import com.codingblocks.codequiz.api.QuestionHandler;
import com.codingblocks.codequiz.api.TipHandler;
import com.codingblocks.codequiz.api.UserHandler;
import io.undertow.server.handlers.PathHandler;

/**
 * Created by championswimmer on 21/12/16.
 */
class CodeQuizApiHandler extends PathHandler {

    CodeQuizApiHandler() {
        super();
        this.addPrefixPath("/questions", new QuestionHandler());
        this.addPrefixPath("/users", new UserHandler());
        this.addPrefixPath("/tips", new TipHandler());
    }
}
