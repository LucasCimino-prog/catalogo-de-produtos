package com.lucasprog.catalogo_de_produtos.service;

import com.lucasprog.catalogo_de_produtos.dto.request.ProdutoRequest;
import com.lucasprog.catalogo_de_produtos.dto.response.ProdutoResponse;
import com.lucasprog.catalogo_de_produtos.mapper.ProdutoMapper;
import com.lucasprog.catalogo_de_produtos.model.Categoria;
import com.lucasprog.catalogo_de_produtos.model.Produto;
import com.lucasprog.catalogo_de_produtos.repository.CategoriaRepository;
import com.lucasprog.catalogo_de_produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;

    @Transactional
    public ProdutoResponse criar(ProdutoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + request.categoriaId()));

        Produto produto = produtoMapper.toEntity(request, categoria);
        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoMapper.toResponse(produtoSalvo);
    }

    @Transactional(readOnly = true)
    public ProdutoResponse buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        return produtoMapper.toResponse(produto);
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponse> listar() {
        return produtoRepository.findAll().stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    @Transactional
    public ProdutoResponse atualizar(Long id, ProdutoRequest request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + request.categoriaId()));

        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPreco(request.preco());
        produto.setCategoria(categoria);

        Produto produtoAtualizado = produtoRepository.save(produto);
        return produtoMapper.toResponse(produtoAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        produtoRepository.delete(produto);
    }
}