package com.codingblocks.codequiz.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by championswimmer on 21/12/16.
 */
public class Question {

    String question;
    ArrayList<Option> options;
    ArrayList<String> tags;

    class Option {
        String answer;
        Boolean correct;
    }

}
