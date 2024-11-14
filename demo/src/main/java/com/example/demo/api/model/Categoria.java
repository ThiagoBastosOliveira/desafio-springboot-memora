package com.example.demo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TBL_CATEGORIAS")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @JsonIgnoreProperties("categoria")
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

}
