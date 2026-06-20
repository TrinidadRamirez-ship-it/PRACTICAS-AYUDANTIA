package com.example.practica5springboot.controller;

import com.example.practica5springboot.entity.Pelicula;
import com.example.practica5springboot.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return peliculaService.obtenerTodas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPorId(@PathVariable Long id) {

        Optional<Pelicula> pelicula = peliculaService.obtenerPorId(id);

        return pelicula.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id,
                               @RequestBody Pelicula pelicula) {

        return peliculaService.actualizar(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        peliculaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}