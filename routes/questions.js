/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');
const bodyParser = require('body-parser');

const route = express.Router();

route.use(bodyParser.json());
route.use(bodyParser.urlencoded({extended: true}));

let questions = require('../dummy_data/DummyQuestion');

route.get('/today', function (req, res) {
    res.send(questions[questions.length - 1]);
});

route.get('/archive', function (req, res) {
    res.send(questions);
});

route.get('/archive/:quesId', function (req, res) {
    let found = false;
    for (let i = 0; i < questions.length; i++) {
        if (questions[i].id == req.params.quesId) {
            found = true;
            res.send(questions[i]);
        }
    }
    if (!found) {
        res.send("Wrong id");
    }
});

route.post('/add', function (req, res) {
    //TODO:
});

route.post('/archive', function (req, res) {
    let filters = req.body.filters;
    let sortBy = req.body.sortBy;

    let filteredQuestions = getQuestionsBasedOnFilters(filters,sortBy);
    res.send(filteredQuestions);
});

function getQuestionsBasedOnFilters(filters, sortBy) {
    //TODO: Make this better
    console.log(filters);
    console.log(sortBy);
    return questions;
}

module.exports = route;