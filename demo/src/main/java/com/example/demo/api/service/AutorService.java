package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.model.Autor;
import com.example.demo.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Autor listarAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor cadastrarAutor(AutorDTO dto) {
        dto.setNome(dto.getNome());
        dto.setNacionalidade(dto.getNacionalidade());
        dto.setLivros(dto.getLivros());

        Autor autor = Autor.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .livros(dto.getLivros())
                .build();

        return autorRepository.save(autor);
    }

    public Autor atualizarAutor(Long id, AutorDTO dto) {
        Autor autor = listarAutorById(id);

        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor.setLivros(dto.getLivros());

        return autorRepository.save(autor);
    }

    public ResponseEntity<Autor> deletarAutor(Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
