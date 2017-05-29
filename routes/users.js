/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');

const route = express.Router();
const users = require('../dummy_data/DummyUser');

route.get('/list', function (req, res) {
    res.send(users);
});

route.get('/:userId', function (req, res) {
    // TODO: fetch user based on id
    res.send(users[0]);

});

module.exports = route;