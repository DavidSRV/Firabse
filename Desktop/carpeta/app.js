import {Servidor} from './servidor/Servidor.js'

import 'dotenv/config'

//PARA UTILIZAR UNA CALSE LA DEBO INSTANCIAR
//PARA USAR UNA LCASE DEBO CREAR UN OBJETO(VARIABLE)
// PARA UAS UNA CLASE LE DEBO SACAR COPIA

let servidConfama = new Servidor();

servidConfama.encenderServidor();