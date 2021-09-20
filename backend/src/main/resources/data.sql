INSERT INTO tb_produto (nome,preco,descricao,imagem)
VALUES ('Geladinho de Paçoca',3.0,'Paçoca',
'https://github.com/Carla-Wasovicz/Projeto-delivery/blob/main/assets/Geladinho_Paoca.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Ninho e Nutella',3.0,'Ninho com Nutella','https://github.com/Carla-Wasovicz/Projeto-delivery/blob/main/assets/Geladinho_ninho_nutella.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Laka',3.0,'Chocolate branco','https://github.com/Carla-Wasovicz/Projeto-delivery/blob/main/assets/Geladinho_Paoca.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Leite',3.0,'Leite','https://github.com/Carla-Wasovicz/Projeto-delivery/blob/main/assets/Geladinho_Paoca.jpg');
INSERT INTO tb_Produto (nome,preco,descricao,imagem)
VALUES ('Geladinho Chocolate',3.0,'Chocolate ','https://github.com/Carla-Wasovicz/Projeto-delivery/blob/main/assets/Geladinho_Paoca.jpg');

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
INSERT INTO tb_entregador (cpf,nome,telefone)
VALUES ('123456789-11','Vinicios Lima','(67) 99952-2526');
INSERT INTO tb_entregador (cpf,nome,telefone)
VALUES ('895623741-22','Mario Fernandes','(67) 99999-8569');
INSERT INTO tb_entregador (cpf,nome,telefone)
VALUES ('5896321478','Fernando Ferraz','(67) 99999-5821');