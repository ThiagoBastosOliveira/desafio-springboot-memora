package com.example.demo.api.dto;

import com.example.demo.api.model.Autor;
import com.example.demo.api.model.Categoria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Autor autor;
    private Categoria categoria;
}
