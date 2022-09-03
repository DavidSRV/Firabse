const { Routers ,Router} = require('express');
const router = Router();
const loginController = require('../controllers/controllerLogin')

router.get('/User/:id', loginController.getAll)

module.exports = router;

 