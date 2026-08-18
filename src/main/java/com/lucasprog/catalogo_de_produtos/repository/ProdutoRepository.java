package com.lucasprog.catalogo_de_produtos.repository;

import com.lucasprog.catalogo_de_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
