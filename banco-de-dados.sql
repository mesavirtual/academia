-- Criação do banco de dados
-- CREATE DATABASE academia;
USE academia;

-- Tabela usuario
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Tabela aluno
CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(200),
    telefone VARCHAR(20),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Tabela professor
CREATE TABLE professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    especializacao VARCHAR(100),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Tabela treino
CREATE TABLE treino (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao TEXT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    aluno_id BIGINT,
    professor_id BIGINT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);

-- Tabela ficha_acompanhamento
CREATE TABLE ficha_acompanhamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    percentual_gordura DOUBLE NOT NULL,
    data_medicao DATE NOT NULL,
    aluno_id BIGINT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

-- Inserção de dados de exemplo
-- Usuários
INSERT INTO usuario (username, password, role) VALUES
('admin', '$2a$10$YourHashedPasswordHere', 'ADMIN'),
('professor1', '$2a$10$YourHashedPasswordHere', 'PROFESSOR'),
('aluno1', '$2a$10$YourHashedPasswordHere', 'ALUNO');

-- Alunos
INSERT INTO aluno (nome, cpf, data_nascimento, endereco, telefone, usuario_id) VALUES
('João Silva', '123.456.789-00', '1990-05-15', 'Rua A, 123', '(11) 9999-8888', 3);

-- Professores
INSERT INTO professor (nome, cpf, especializacao, usuario_id) VALUES
('Carlos Souza', '987.654.321-00', 'Musculação', 2);

-- Treinos
INSERT INTO treino (descricao, data_inicio, data_fim, aluno_id, professor_id) VALUES
('Treino de musculação para iniciantes', '2023-10-01', '2023-12-31', 1, 1);

-- Fichas de Acompanhamento
INSERT INTO ficha_acompanhamento (peso, altura, percentual_gordura, data_medicao, aluno_id) VALUES
(70.5, 1.75, 15.0, '2023-10-01', 1);