

/*Criação Banco de dados "Dinossauros": */
CREATE DATABASE Dinossauros;

USE Dinossauros;


/*Criação das tabelas: */
CREATE TABLE Grupo(
id int not null identity,
nome varchar (50) not null,
PRIMARY KEY (id)
);


CREATE TABLE Era (
  id int not null identity,
  nome varchar (50) not null,
  Ano_de_inicio int not null,
  Ano_de_fim int not null,
  PRIMARY KEY (id)
);

CREATE TABLE Descobridor (
  id int not null identity,
  nome varchar (50) not null,
  PRIMARY KEY (id)
);

CREATE TABLE Pais (
  id int not null identity,
  nome varchar (50) not null,
  PRIMARY KEY (id)
);


CREATE TABLE Dinossauro (
  id int not null identity,
  id_grupo int not null,
  id_era int not null,
  id_descobridor int not null,
  id_pais int not null,
  nome varchar (50) not null,
  ano_descoberta int not null,
  toneladas int not null,
  PRIMARY KEY (id),
  FOREIGN KEY (id_grupo) REFERENCES Grupo(id),
  FOREIGN KEY (id_era) REFERENCES Era(id),
  FOREIGN KEY (id_descobridor) REFERENCES Descobridor(id),
  FOREIGN KEY (id_pais) REFERENCES Pais(id)
);

/*Inserindo os dados de "Era" da tabela: */
INSERT into Era ( nome, Ano_de_inicio, Ano_de_fim) values ('Cretaceo',145,66);
INSERT into Era ( nome, Ano_de_inicio, Ano_de_fim) values ('Jurassico',201,145);

select * from Era;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados de "Grupo" da tabela: */
INSERT INTO Grupo (nome) values ( 'Anquilossauros');
INSERT INTO Grupo (nome) values ( 'Ceratopsídeos');
INSERT INTO Grupo (nome) values ( 'Estegossauros');
INSERT INTO Grupo (nome) values ( 'Terápodes');
INSERT INTO Grupo (nome) values ( 'Anquilossauros');

SELECT * FROM Grupo;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados de "Descobridor" da tabela: */
INSERT INTO Descobridor (nome) values ('Maryanska');
INSERT INTO Descobridor (nome) values ('John Bell Hatcher');
INSERT INTO Descobridor (nome) values ('Cientistas Alemães');
INSERT INTO Descobridor (nome) values ('Museu Americano de História Natural');
INSERT INTO Descobridor (nome) values ('Othniel Charles Marsh');
INSERT INTO Descobridor (nome) values ('Barnum Brown');


SELECT * FROM Descobridor;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados de "País" da tabela: */
INSERT INTO Pais (nome) values ('Mongólia');
INSERT INTO Pais (nome) values ('Canadá');
INSERT INTO Pais (nome) values ('Tanzânia');
INSERT INTO Pais (nome) values ('China');
INSERT INTO Pais (nome) values ('América do Norte');
INSERT INTO Pais (nome) values ('USA');


SELECT * FROM Pais;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados de "Dinossauro" da tabela: */
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (1,1, 1, 1, 'Saichania', 1977, 4);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (2, 1, 2, 2, 'Tricerátops', 1887, 6);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (3, 2, 3,3, 'Kentrossauro', 1909, 2);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (1, 1, 4, 4, 'Pinacossauro', 1999, 6);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (4, 2, 5, 5, 'Alossauro', 1877, 3);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (2, 1, 2, 6, 'Torossauro', 1891, 8);
INSERT INTO Dinossauro (id_grupo, id_era, id_descobridor, id_pais, nome, ano_descoberta, toneladas) values (1, 1, 6, 5, 'Anquilossauro', 1906, 8);
SELECT * FROM Dinossauro;

/*Comando para deletar os dados da tabela:
	DELETE FROM Dinossauro
	*/

/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*7. Crie uma consulta para relacionar todos os dados disponíveis de todos os dinossauros
existentes no catalogo em ordem alfabética de nome: */

SELECT Dinossauro.nome AS 'Dinossauro',
Grupo.nome AS 'Grupo',
Dinossauro.toneladas AS 'Toneladas',
Dinossauro.ano_descoberta AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.id AS 'Era',
Era.Ano_de_fim AS 'Inicio (milhões)',
Era.Ano_de_fim AS 'Fim (milhões)',
Pais.id AS 'País'

FROM Dinossauro, Grupo, Pais, Descobridor, Era
WHERE Dinossauro.id_grupo = Grupo.id
AND Dinossauro.id_pais = Pais.id
AND Dinossauro.id_descobridor = Descobridor.id
AND Dinossauro.id_era = Era.id

/* Ordenando a tabela em ordem alfabética de nome: */
ORDER BY Dinossauro.nome;


/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */


/*
8.	Crie uma consulta para relacionar todos os dados disponíveis de todos os dinossauros 
existentes em ordem alfabética de Descobridor:  */

SELECT Dinossauro.nome AS 'Dinossauro',
Grupo.nome AS 'Grupo',
Dinossauro.toneladas AS 'Toneladas',
Dinossauro.ano_descoberta AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.id AS 'Era',
Era.Ano_de_fim AS 'Inicio (milhões)',
Era.Ano_de_fim AS 'Fim (milhões)',
Pais.id AS 'País'

FROM Dinossauro, Grupo, Pais, Descobridor, Era
WHERE Dinossauro.id_grupo = Grupo.id
AND Dinossauro.id_pais = Pais.id
AND Dinossauro.id_descobridor = Descobridor.id
AND Dinossauro.id_era = Era.id

/* Ordenando a tabela em ordem alfabética do Descobridor: */
ORDER BY Descobridor.nome;


/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
9.Crie uma consulta para relacionar todos os dados disponíveis dos dinossauros do grupo
anquilossauros em ordem de ano de descoberta:  */

SELECT Grupo.nome AS 'Grupo',
Dinossauro.nome AS 'Dinossauro',
Dinossauro.ano_descoberta AS 'Ano Descoberta',
Dinossauro.toneladas AS 'Toneladas',
Descobridor.nome AS 'Descobridor',
Era.id AS 'Era',
Era.Ano_de_fim AS 'Inicio (milhões)',
Era.Ano_de_fim AS 'Fim (milhões)',
Pais.id AS 'País'

FROM Dinossauro, Grupo, Pais, Descobridor, Era
WHERE Dinossauro.id_grupo = Grupo.id
AND Dinossauro.id_pais = Pais.id
AND Dinossauro.id_descobridor = Descobridor.id
AND Dinossauro.id_era = Era.id

/* Filtrando para o grupo de dinossauros "Anquilossauros": */
AND Grupo.nome = 'Anquilossauros'

/* Ordenando a tabela em relação a ordem de descoberta: */
ORDER BY Dinossauro.ano_descoberta


/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
10.	Crie uma consulta para relacionar todos os dados disponíveis 
dos dinossauros Ceratopsídeos ou anquilossauros com ano de descoberta
entre 1900 e 1999: */

SELECT Dinossauro.nome AS 'Dinossauro',
Grupo.nome AS 'Grupo',
Dinossauro.toneladas AS 'Toneladas',
Dinossauro.ano_descoberta AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.id AS 'Era',
Era.Ano_de_fim AS 'Inicio (milhões)',
Era.Ano_de_fim AS 'Fim (milhões)',
Pais.id AS 'País'

FROM Dinossauro, Grupo, Pais, Descobridor, Era
WHERE Dinossauro.id_grupo = Grupo.id
AND Dinossauro.id_pais = Pais.id
AND Dinossauro.id_descobridor = Descobridor.id
AND Dinossauro.id_era = Era.id

/* Filtrando para o grupo de dinossauros "Anquilossauros": */
AND Grupo.nome = 'Anquilossauros'

/* Filtrando para os dados entre os anos 1900-1999: */
AND Dinossauro.ano_descoberta between 1900 AND 1999

/* Organizando pelo ano de descoberta dentro dos filtrod utilizado: */
ORDER BY Dinossauro.ano_descoberta;

/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */
