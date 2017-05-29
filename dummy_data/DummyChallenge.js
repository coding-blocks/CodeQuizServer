/**
 * Created by piyush0 on 29/05/17.
 */
let question = require('./DummyQuestion');
let users = require('./DummyUser');

let challenges = [
    {
        usersInGame: [
            {
                name: "xyz",
                image_url: "www.google.com",
                email: "xyz@abc.com",
                score: 10,
                unique_id: 1
            },
            {
                name: "qwe",
                image_url: "www.fb.com",
                email: "qwe@saf.com",
                score: 40,
                unique_id: 2
            }
        ],
        scores: [
            30.4, 12.2
        ],
        statuses: [
            true, false
        ],
        date: new Date(),
        topic: "Java",
        challenge_id: 1,
        questions: question
    },

    {
        usersInGame: users,
        scores: [
            30.4, 12.2, 55.4
        ],
        statuses: [
            true, false, true
        ],
        date: new Date(),
        topic: "C++",
        challenge_id: 2,
        questions: question
    }

];

module.exports = challenges;