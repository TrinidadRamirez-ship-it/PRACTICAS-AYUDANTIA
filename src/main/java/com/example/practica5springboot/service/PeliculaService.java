package com.example.practica5springboot.service;

import com.example.practica5springboot.entity.Pelicula;
import com.example.practica5springboot.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;


    public List<Pelicula> obtenerTodas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return peliculaRepository.findById(id);
    }


    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }


    public Pelicula actualizar(Long id, Pelicula peliculaActualizada) {

        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));

        pelicula.setTitulo(peliculaActualizada.getTitulo());
        pelicula.setDirector(peliculaActualizada.getDirector());
        pelicula.setAnioLanzamiento(peliculaActualizada.getAnioLanzamiento());
        pelicula.setGenero(peliculaActualizada.getGenero());
        pelicula.setSinopsis(peliculaActualizada.getSinopsis());

        return peliculaRepository.save(pelicula);
    }

    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }
}