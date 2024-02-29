INSERT INTO tb_professor(cargo, nome, idade, email, telefone) VALUES (0, 'Bob', 40, 'bob@gmail.com', '(63) 91111-1111');
INSERT INTO tb_professor(cargo, nome, idade, email, telefone) VALUES (0, 'Thomas', 50, 'thomas@gmail.com', '(63) 92222-2222');

INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, professor_id) VALUES ('JAVA', 'Curso de Java', 50, 39.99, 1);
INSERT INTO tb_cursos(nome, descricao, carga_horaria, preco, professor_id) VALUES ('JAVA SCRIPT', 'Curso de JS', 30, 29.99, 2);

INSERT INTO tb_aluno(cargo, nome, idade, email, telefone) VALUES (1, 'Ana Silva', 18, 'ana.silva@email.com', '(11) 9999-8888');
INSERT INTO tb_aluno(cargo, nome, idade, email, telefone) VALUES (1, 'João Souza', 26, 'joao.souza@email.com','(22) 7777-6666');
INSERT INTO tb_aluno(cargo, nome, idade, email, telefone) VALUES (1, 'Maria Oliveira', 19, 'maria.oliveira@email.com', '(33) 5555-4444');

INSERT INTO tb_matricula(cursos_id, data_matricula, alunos_id) VALUES (1,'2023-12-01', 1);
