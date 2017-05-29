const express = require('express');

const app = express();
const routes = {
    api: require('./routes/api')
}

app.use('/api/v1', routes.api);

app.listen(8080, function () {
    console.log("Server started on http://localhost:8080");
});