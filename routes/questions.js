/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');

const route = express.Router();

route.get('/today', function (req, res) {
    let questions = require('../dummy_data/DummyQuestion');
    res.send(questions[questions.length - 1]);
});

module.exports = route;