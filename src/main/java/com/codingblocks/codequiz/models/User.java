package com.codingblocks.codequiz.models;

/**
 * Created by piyush0 on 27/12/16.
 */
public class User {

    private String name;
    private String image_url;
    private String email;
    private Integer score;
    private Integer unique_id;

    public User(String name, Integer score, String email, Integer unique_id) {
        this.name = name;
        this.score = score;
        this.email = email;
        this.unique_id = unique_id;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getEmail() {
        return email;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getUnique_id() {
        return unique_id;
    }
}
