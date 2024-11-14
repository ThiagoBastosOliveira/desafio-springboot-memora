package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.Categoria;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Categoria>> listarTodos() {
        List<Categoria> listaCategoriaes = categoriaService.listarCategoriaes();
        return ResponseEntity.ok(listaCategoriaes);
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<Categoria> listarById(@PathVariable("id") Long id) {
        Categoria categoria = categoriaService.listarCategoriaById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<List<CategoriaDTO>> cadastrarCategoria(@RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.cadastrarCategoria(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable("id") Long id, @RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.atualizarCategoria(id, dto);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Categoria> deletarCategoria(@PathVariable("id") Long id) {
        Categoria categoria = categoriaService.deletarCategoria(id).getBody();
        return ResponseEntity.ok().body(categoria);
    }
}
