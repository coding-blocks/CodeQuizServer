/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');

const route = express.Router();

route.get('/todayTip', function (req, res) {
    let tips = require('../dummy_data/DummyTip');
    res.send(tips[tips.length - 1]);
});

module.exports = route;