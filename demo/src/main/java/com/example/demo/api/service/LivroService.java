package com.example.demo.api.service;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.Livro;
import com.example.demo.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro listarLivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro cadastrarLivro(LivroDTO dto) {
        dto.setTitulo(dto.getTitulo());
        dto.setIsbn(dto.getIsbn());
        dto.setAutor(dto.getAutor());
        dto.setCategoria(dto.getCategoria());

        Livro livro = Livro.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(dto.getAutor())
                .categoria(dto.getCategoria())
                .build();

        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, LivroDTO dto) {
        Livro livro = listarLivroById(id);

        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setAutor(dto.getAutor());
        livro.setCategoria(dto.getCategoria());

        return livroRepository.save(livro);
    }

    public ResponseEntity<Livro> deletarLivro(Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
