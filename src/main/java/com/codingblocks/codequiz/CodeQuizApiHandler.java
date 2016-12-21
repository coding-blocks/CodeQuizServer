package com.codingblocks.codequiz;

import com.codingblocks.codequiz.api.QuestionHandler;
import io.undertow.server.handlers.PathHandler;

/**
 * Created by championswimmer on 21/12/16.
 */
public class CodeQuizApiHandler extends PathHandler {

    private static CodeQuizApiHandler cqh;
    private CodeQuizApiHandler () {
        //For singleton
    }

    public static CodeQuizApiHandler getInstance () {
        if (cqh == null) {
            cqh = new CodeQuizApiHandler();
            cqh.addPrefixPath("/questions", new QuestionHandler());
        }
        return cqh;
    }
}
