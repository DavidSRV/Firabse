import express from "express";

// Variable para personalizar las rutas (ENDPOINTS) de mis servicios
 export let routers =  express.Router();

// Escribo mis rutas (Cada ruta es un servicio)

routers.get('viajeconfama/v1/habitacion/id', (req, res) => {
    res.send(`Corriendo api`);
  });
routers.get('viajeconfama/v1/habitaciones/',(req, res) => {
    res.send(`Corriendo api`);
  });
routers.post('viajeconfama/v1/reserva',(req, res) => {
    res.send(`Corriendo api`);
  });
routers.put('viajeconfama/v1/reserva/id', (req, res) => {
    res.send(`Corriendo api`);
  });
routers.delete('viajeconfama/v1/habitaciones/id', (req, res) => {
    res.send(`Corriendo api`);
  });