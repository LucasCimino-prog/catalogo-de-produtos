package com.lucasprog.catalogo_de_produtos.repository;

import com.lucasprog.catalogo_de_produtos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
