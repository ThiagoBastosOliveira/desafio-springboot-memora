package com.example.demo.api.controller;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.Livro;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Livro>> listarTodos() {
        List<Livro> listaLivro = livroService.listarLivros();
        return ResponseEntity.ok(listaLivro);
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<Livro> listarLivroById(@PathVariable("id") Long id) {
        Livro livro = livroService.listarLivroById(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<List<LivroDTO>> cadastrarLivro(@RequestBody LivroDTO dto) {
        Livro livro = livroService.cadastrarLivro(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable("id") Long id, @RequestBody LivroDTO dto) {
        Livro livro = livroService.atualizarLivro(id, dto);
        return ResponseEntity.ok().body(livro);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Livro> deletarLivro(@PathVariable("id") Long id) {
        Livro livro = livroService.deletarLivro(id).getBody();
        return ResponseEntity.ok().body(livro);
    }

}
