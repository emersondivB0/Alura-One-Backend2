package com.alura.controller;

import java.util.List;
import java.util.Optional;

import com.alura.modelo.topico.DatosListadoTopico;
import com.alura.modelo.topico.DatosRespuestaTopico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.modelo.topico.Topico;
import com.alura.modelo.topico.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping("lista")
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("get")
    public ResponseEntity<String> obtenerTopicosHtml() {
        String mensajeHTML = "<html><body><h1>Prueba de conexión exitosa</h1></body></html>";
        return ResponseEntity.ok().body(mensajeHTML);
    }

    @GetMapping("/{id}")
    public Topico obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.orElse(null);
    }

    @PostMapping
    public void crearTopico(@RequestBody String parametro) {
        System.out.println("Hay Request joven");
        System.out.println(parametro);
    }
    //public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
    //    System.out.println("Hay conexión");
    //    Topico nuevoTopico = topicoRepository.save(topico);
    //    return ResponseEntity.ok(nuevoTopico);
    //}
/*
    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isPresent()) {
            topico.setId(id);
            return topicoRepository.save(topico);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }

 */
}
