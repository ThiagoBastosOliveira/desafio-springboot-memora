package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.Autor;
import com.example.demo.api.model.Livro;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Autor>> listarTodos() {
        List<Autor> listaAutores = autorService.listarAutores();
        return ResponseEntity.ok(listaAutores);
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<Autor> listarById(@PathVariable("id") Long id) {
        Autor autor = autorService.listarAutorById(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<List<AutorDTO>> cadastrarAutor(@RequestBody AutorDTO dto) {
        Autor autor = autorService.cadastrarAutor(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autor.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable("id") Long id, @RequestBody AutorDTO dto) {
        Autor autor = autorService.atualizarAutor(id, dto);
        return ResponseEntity.ok().body(autor);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Autor> deletarAutor(@PathVariable("id") Long id) {
        Autor autor = autorService.deletarAutor(id).getBody();
        return ResponseEntity.ok().body(autor);
    }
}
