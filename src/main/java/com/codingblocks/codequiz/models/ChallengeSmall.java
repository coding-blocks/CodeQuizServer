package com.codingblocks.codequiz.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by piyush0 on 30/12/16.
 */
public class ChallengeSmall {

    private Integer challengeId;
    private String topic;
    private Date date;
    private ArrayList<String> userNames;

    public ChallengeSmall(Integer challengeId, String topic, Date date, ArrayList<String> userNames) {
        this.challengeId = challengeId;
        this.topic = topic;
        this.date = date;
        this.userNames = userNames;
    }

}
