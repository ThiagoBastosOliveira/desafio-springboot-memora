package com.example.demo.api.repository;

import com.example.demo.api.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

//    @PersistenceContext
//    private EntityManager entityManager;

//    public List<Livro> findAll() {
//        TypedQuery<Livro> query = entityManager.createQuery("""
//            SELECT
//                lv.id AS id_livro,
//                lv.titulo,
//                lv.isbn,
//                at.id AS id_autor,
//                at.nome AS nome_autor,
//                at.nacionalidade,
//                ct.id AS id_categoria,
//                ct.nome AS nome_categoria
//            FROM Livro lv
//                JOIN Autor at
//                JOIN Categoria ct
//        """, Livro.class);
//
//        return query.getResultList();
//    }

}
