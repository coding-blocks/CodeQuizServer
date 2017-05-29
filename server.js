const express = require('express')

const app = express();

app.get('/', function (req, res) {
    res.send("Hello server");
})

app.listen(8080, function () {
    console.log("Server started on http://localhost:8080");
})