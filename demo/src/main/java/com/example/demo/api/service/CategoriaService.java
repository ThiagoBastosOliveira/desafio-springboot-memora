package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.Categoria;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategoriaes() {
        return categoriaRepository.findAll();
    }

    public Categoria listarCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria cadastrarCategoria(CategoriaDTO dto) {
        dto.setNome(dto.getNome());
        dto.setLivros(dto.getLivros());

        Categoria categoria = Categoria.builder()
                .nome(dto.getNome())
                .livros(dto.getLivros())
                .build();

        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Long id, CategoriaDTO dto) {
        Categoria categoria = listarCategoriaById(id);

        categoria.setNome(dto.getNome());
        categoria.setLivros(dto.getLivros());

        return categoriaRepository.save(categoria);
    }

    public ResponseEntity<Categoria> deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
