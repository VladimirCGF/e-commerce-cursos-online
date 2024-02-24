INSERT INTO tb_professor(nome) VALUES ('Bob');
INSERT INTO tb_professor(nome)VALUES ('Thomas');

INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, professor_id) VALUES ('JAVA', 'Curso de Java', 50, 39.99, 1);
INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, professor_id) VALUES ('JAVA SCRIPT', 'Curso de JS', 30, 29.99, 2);

INSERT INTO tb_aluno(nome, email, telefone) VALUES ('Ana Silva', 'ana.silva@email.com', '(11) 9999-8888');
INSERT INTO tb_aluno(nome, email, telefone) VALUES ('João Souza','joao.souza@email.com','(22) 7777-6666');
INSERT INTO tb_aluno(nome, email, telefone) VALUES ('Maria Oliveira', 'maria.oliveira@email.com', '(33) 5555-4444');

INSERT INTO tb_matricula(cursos_id, data_matricula, alunos_id) VALUES (1,'2023-12-01', 1);
