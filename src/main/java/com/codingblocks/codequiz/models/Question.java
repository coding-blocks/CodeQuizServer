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
    String date_added;
    ArrayList<Topic> tags;

    public Question(Integer id, String question, ArrayList<Option> options, String date_added, ArrayList<Topic> tags) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.date_added = date_added;
        this.tags = tags;
    }
    public Question(String question, ArrayList<Option> options, ArrayList<Topic> tags, String date, Integer id) {
        this.question = question;
        this.options = options;
        this.date_added = date;
        this.tags = tags;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public ArrayList<Topic> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Topic> tags) {
        this.tags = tags;
    }
}
