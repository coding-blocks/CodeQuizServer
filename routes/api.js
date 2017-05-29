/**
 * Created by piyush0 on 29/05/17.
 */
const express = require('express');

const route = express.Router();
const routes = {
    tips: require('./tips'),
    questions: require('./questions')
};


route.use('/tips', routes.tips);
route.use('/questions', routes.questions);

module.exports = route;