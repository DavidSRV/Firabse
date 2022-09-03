import express from "express";


//LLamamos a los rutas

import { routers } from "../routers/routes.js";



 export class Servidor {
  constructor() {
    this.application = express(); // Atributo una variable 
    this.atenderPeticiones() // Atiendo las peticiones del usuario1
  }

  atenderPeticiones() {
    this.application.use("/",rutas);
  }

  encenderServidor() {
    this.application.listen(3000, () => {
      console.log("Servidor ON");
    });
  }
}

