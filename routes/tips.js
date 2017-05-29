/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');

const route = express.Router();

route.get('/todayTip', function (req, res) {
    res.send("Put semicolon at the end")
});


module.exports = route;