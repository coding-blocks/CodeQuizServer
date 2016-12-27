package com.codingblocks.codequiz.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by championswimmer on 21/12/16.
 */
public class Question {

    Integer id;
    String question;
    ArrayList<Option> options;
    ArrayList<String> tags;
    Date date_added;
}
