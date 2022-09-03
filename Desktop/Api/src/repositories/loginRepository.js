const pool = require('./dbconnection')
const loginRepository = {}

loginRepository.getAll = (user,password) =>{
    const context = pool()
    return context.query('select * from where user=$1,password=$2',[user,password])
}