INSERT INTO tb_produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Laka',3.0,'Geladinho de chocolate branco',
'https://raw.githubusercontent.com/devsuperior/sds2/master/asses/pizza_bacon.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Laka',3.0,'Geladinho de chocolate branco','https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Laka',3.0,'Geladinho de chocolate branco','https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg');


INSERT INTO tb_pedido (status,latitude,longitude,endereco,hora) 
VALUES (0, -23.561680, -46.656139, 'Rua Piuna, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_pedido (status,latitude,longitude,endereco,hora)  
VALUES (1, -22.946779, -43.217753, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z');
INSERT INTO tb_pedido (status,latitude,longitude,endereco,hora)  
VALUES (0, -25.439787, -49.237759, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z');


INSERT INTO tb_pedido_produto (pedido_id, produto_id) VALUES (1 , 1);
INSERT INTO tb_pedido_produto (pedido_id, produto_id) VALUES (1 , 2);
INSERT INTO tb_pedido_produto (pedido_id, produto_id) VALUES (3 , 1);

INSERT INTO tb_entrega (preco_Entrega)
VALUES (5.0);

INSERT INTO tb_entregador (cpf,nome,telefone)
VALUES ('32165498-56','João Silva','(67) 99999-8888');