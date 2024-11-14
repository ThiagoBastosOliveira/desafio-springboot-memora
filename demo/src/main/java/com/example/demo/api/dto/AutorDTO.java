package com.example.demo.api.dto;

import com.example.demo.api.model.Livro;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorDTO {

    private Long id;
    private String nome;
    private String nacionalidade;
    private List<Livro> livros;
}
