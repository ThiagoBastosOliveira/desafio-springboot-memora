package com.example.demo.api.dto;

import com.example.demo.api.model.Livro;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {

    private String nome;
    private List<Livro> livros;
}
