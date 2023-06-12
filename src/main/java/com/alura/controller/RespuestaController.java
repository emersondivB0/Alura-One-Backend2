package com.alura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.modelo.Respuesta;
import com.alura.repositorios.RespuestaRepository;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public List<Respuesta> obtenerTodasLasRespuestas() {
        return respuestaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Respuesta obtenerRespuestaPorId(@PathVariable Long id) {
        Optional<Respuesta> respuesta = respuestaRepository.findById(id);
        return respuesta.orElse(null);
    }

    @PostMapping
    public Respuesta crearRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @PutMapping("/{id}")
    public Respuesta actualizarRespuesta(@PathVariable Long id, @RequestBody Respuesta respuesta) {
        Optional<Respuesta> respuestaExistente = respuestaRepository.findById(id);
        if (respuestaExistente.isPresent()) {
            respuesta.setId(id);
            return respuestaRepository.save(respuesta);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarRespuesta(@PathVariable Long id) {
        respuestaRepository.deleteById(id);
    }
}
