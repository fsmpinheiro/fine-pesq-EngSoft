--Insira a area com esse SQL
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências Biológicas', 'Área que tem como objetivo estudar todos os tipos de vida: flora, fauna, seres humanos e animais.', 8);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências da Saúde', 'São as áreas de estudo relacionadas com a vida, a saúde e a doenças', 10);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências Agrárias', 'Compôem uma área multidisciplinar de estudos envolvendo campos e que visa a busca do aprimoramento técnico, o aumento produtivo e melhorias no manejo e preservação dos recursos naturais.',7);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências Exatas', 'São as ciências que têm a Matemática, a Química e a Física como peças fundamentais dos seus estudos.',8);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Engenharias e Computação', '',10);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências Humanas', 'Um ramo das ciências, distinto das humanidades, que estuda os aspectos sociais do mundo humano, ou seja, a vida social de indivíduos e grupos humanos.',2);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Ciências Sociais Aplicadas', 'A área de Ciências Sociais Aplicadas reúne campos de conhecimento interdisciplinares, voltados para os aspectos sociais das diversas realidades humanas.',2);
INSERT INTO areasDePesquisa (nome, descricao, relevanciaEconomica) VALUES ('Linguagens e Artes', '',2);

CREATE TABLE areasDePesquisa(
	codigo INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	descricao VARCHAR(255),
	relevanciaEconomica VARCHAR(255),
	PRIMARY KEY(codigo)
);
