CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    categoria_id BIGINT NOT NULL,

    CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);