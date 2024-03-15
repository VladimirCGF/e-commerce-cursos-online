INSERT INTO tb_usuario(nome, data, email, telefone) VALUES ('Bob', '1969-02-12', 'bob@gmail.com', '(63) 91111-1111');
INSERT INTO tb_usuario(nome, data, email, telefone) VALUES ('Thomas', '1967-02-12', 'thomas@gmail.com', '(63) 91111-1111');

INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, usuario_id) VALUES ('JAVA', 'Curso de Java', 50, 39.99, 1);
INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, usuario_id) VALUES ('JAVA SCRIPT', 'Curso de JS', 30, 29.99, 2);

INSERT INTO tb_matricula(cursos_id, data_matricula, usuario_id) VALUES (1,'2023-12-01', 1);
