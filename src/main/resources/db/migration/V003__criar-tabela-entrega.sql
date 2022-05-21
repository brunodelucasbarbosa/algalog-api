CREATE TABLE entrega (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT not null,
    taxa DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) not null,
    data_pedido DATETIME not null,
    data_finalizacao DATETIME,

    destinatario_nome VARCHAR(60) NOT NULL,
    destinatario_logradouro VARCHAR(255) NOT NULL,
    destinatario_numero VARCHAR(30) NOT NULL,
    destinatario_complemento VARCHAR(60) NOT NULL,
    destinatario_bairro VARCHAR(30) NOT NULL,

    primary key (id)
);

ALTER TABLE entrega add constraint fk_entrega_cliente
FOREIGN KEY (cliente_id) references cliente (id);