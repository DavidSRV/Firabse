const loginController = {};
const Course = require("../models/login");
const loginRepository = require("../repositories/loginRepository");

loginRepository.getAll = (req, res) => {
  loginRepository.getAll()
    .then((users) => {
      if (users.rows.length == 0) {
        res.status(400).send("Not Found");
      }
      res.json(users.rows);
    })
    .catch((error) => {
      res.status(500).send(error.stack);
    });
};
