package com.lucasprog.catalogo_de_produtos.mapper;

import com.lucasprog.catalogo_de_produtos.dto.request.ProdutoRequest;
import com.lucasprog.catalogo_de_produtos.dto.response.ProdutoResponse;
import com.lucasprog.catalogo_de_produtos.model.*;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequest request, Categoria categoria) {
        Produto produto = new Produto();
        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPreco(request.preco());
        produto.setCategoria(categoria);
        return produto;
    }

    public ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }

}
