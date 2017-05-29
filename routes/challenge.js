/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');
const bodyParser = require('body-parser');

const route = express.Router();
const questions = require('../dummy_data/DummyQuestion');
const challenges = require('../dummy_data/DummyChallenge');
const challengesSmall = require('../dummy_data/DummySmallChallenge');

route.use(bodyParser.json());
route.use(bodyParser.urlencoded({extended: true}));

route.get('/me', function (req, res) {
    /*User will be in headers*/
    //TODO fetch challenges of current user and send
    res.send(challengesSmall);
});

route.get('/:challengeId/result', function (req, res) {
    let id = req.params.challengeId;
    //TODO fetch challenge from db based on Id
    res.send(challenges[0]);
});

route.post('/submit/:challengeId', function (req, res) {
    let id = req.params.challengeId;
    let submission = req.body;

    /* User submitting this will be in headers*/
    //TODO: Store submission in db and send success back
    let success = true; // This will depend on Db
    res.send(success);
});

route.get('/:challengeId', function (req, res) {
    let id = req.params.challengeId;
    res.send(getChallengeQuestions(id));
});

route.post('/create', function (req, res) {
    let numQues = req.body.numQues;
    let users = req.body.users;
    let topic = req.body.topic;
    res.send(getChallengeId(users, numQues, topic));
});

function getChallengeQuestions(challengeId) {
    return questions;
    //TODO: make this better
}

function getChallengeId(users, numQues, topic) {
    return 1;
    // TODO: Register a challenge in DB with given params and return the challengeId.
}


module.exports = route;