const {Pool} = require('pg');
const config = require('../config');

const pool = new Pool({
    user: config.dbUser,
    host: config.dbServer,
    password: config.dbDatabase,
    port: config.dbPort,
    ssl:{
        rejectUnauthorized:false,
    }
})

const getConnectin = () =>{
    try {
        const conn = pool.query('SELECT NOW()')
        if(conn!==null){
            return pool;
        }
    } catch (error) {
        console.error(error)
        
    }
}