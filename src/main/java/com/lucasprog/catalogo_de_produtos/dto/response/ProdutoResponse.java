package com.lucasprog.catalogo_de_produtos.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        String nomeCategoria
) {}
