/**
 * Created by piyush0 on 29/05/17.
 */

let dummyQuestions = [
    {
        id: 1,
        question: "What is x?",
        options: [
            {
                answer: "x is 2",
                correct: false
            },
            {
                answer: "x is 21342",
                correct: true
            },
            {
                answer: "x is 0",
                correct: true
            },
            {
                answer: "x is 10",
                correct: false
            }
        ],
        date_added: "monday",
        tags: [
            {
                name: "Java"
            },
            {
                name: "Python"
            }
        ]
    },


    {
        id: 2,
        question: "What is y?",
        options: [
            {
                answer: "y is 2",
                correct: true
            },
            {
                answer: "y is 32",
                correct: true
            },
            {
                answer: "y is 0",
                correct: false
            },
            {
                answer: "y is 10",
                correct: false
            }
        ],
        date_added: "21/10/16",
        tags: [
            {
                name: "JavaScipt"
            },
            {
                name: "Android"
            }
        ]
    }

];

module.exports = dummyQuestions;