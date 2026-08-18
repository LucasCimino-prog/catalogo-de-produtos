package com.lucasprog.catalogo_de_produtos.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank String nome,
        String descricao,
        @NotNull @Positive BigDecimal preco,
        @NotNull Long categoriaId
) {}