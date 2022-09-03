const express = require('express')
const morgan = require('morgan')
const cors = require('cors')
const app = express();
const config = require('./config');

app.use(morgan('dev'));
app.use(express.json())
app.use(cors());


app.listen(config.port, ()=>{
    console.log(`funcionando pa ${config.port}`)
})

