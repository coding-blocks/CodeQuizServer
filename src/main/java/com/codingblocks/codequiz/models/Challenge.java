package com.codingblocks.codequiz.models;

import com.codingblocks.codequiz.dummy_utils.DummyQuestions;
import com.codingblocks.codequiz.dummy_utils.DummyUser;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by piyush0 on 30/12/16.
 */
public class Challenge {

    private ArrayList<User> usersInGame;
    private ArrayList<Double> score;
    private ArrayList<Boolean> statuses;
    private Date date;
    private String topic;
    private Integer challenge_Id;
    private ArrayList<Question> questions;



    public Challenge(ArrayList<User> usersInGame,
                     ArrayList<Double> score, ArrayList<Boolean> pendingList, Date date,
                     String topic, Integer challenge_Id, ArrayList<Question> questions) {
        this.usersInGame = usersInGame;
        this.score = score;
        this.statuses = pendingList;
        this.date = date;
        this.topic = topic;
        this.challenge_Id = challenge_Id;
        this.questions = questions;
    }


}
