
/*Cria��o Banco de dados "Biblioteca": */
CREATE DATABASE Biblioteca;

USE Biblioteca;


/*Cria��o das tabelas: */
CREATE TABLE  Categoria  (
   id  int not null identity,
   nome  varchar (50),
   PRIMARY KEY  ( id )
);

CREATE TABLE  Editora  (
   id  int not null identity,
   nome  varchar (50),
   PRIMARY KEY  ( id )
);

CREATE TABLE  Livro  (
   ISBN  int not null identity,
   fk_id_categoria  int not null,
   fk_id_autor  int not null,
   fk_id_editora  int not null,
   titulo  varchar (100) not null,
   ano  varchar (4) not null,
  FOREIGN KEY ( fk_id_categoria ) REFERENCES  Categoria ( id ),
  FOREIGN KEY ( fk_id_editora ) REFERENCES  Editora ( id ),
  PRIMARY KEY  ( ISBN ),
  
);

CREATE TABLE  Autor  (
   id  int not null identity,
   nome  varchar (100),
   nacionalidade  varchar (100),
  PRIMARY KEY  ( id )
);

CREATE TABLE  Escreve  (
   id  int not null identity,
   fk_autor  int not null,
   fk_livro  int not null,
  FOREIGN KEY ( fk_autor ) REFERENCES  Autor ( id ),
  FOREIGN KEY ( fk_livro ) REFERENCES  Livro ( ISBN ),
  PRIMARY KEY  ( id ),
 
);

/*Inserindo os dados na tabela "Categoria": */
INSERT into Categoria (nome) values ('Literatura Juvenil');
INSERT into Categoria (nome) values ('Fic��o Cient�fica');
INSERT into Categoria (nome) values ('Humor');


select * from Categoria;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados na tabela "Editora": */
INSERT into Editora (nome) values ('Rocco');
INSERT into Editora (nome) values ('Wmf Martins Fontes');
INSERT into Editora (nome) values ('Casa da Palavra');
INSERT into Editora (nome) values ('Belas Letras');
INSERT into Editora (nome) values ('Matrix');

select * from Editora;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados na tabela "Autor/Nacionalidade": */
INSERT into Autor (nome, nacionalidade) values ('J. K. Rowling', 'Inglaterra');
INSERT into Autor (nome, nacionalidade) values ('Clive Staples Lewis', 'Inglaterra');
INSERT into Autor (nome, nacionalidade) values ('Affonso Solano', 'Brasil');
INSERT into Autor (nome, nacionalidade) values ('Marcos Piangers', 'Brasil');
INSERT into Autor (nome, nacionalidade) values ('Ciro Botelho - Tiririca', 'Brasil');
INSERT into Autor (nome, nacionalidade) values ('Bianca M�l', 'Brasil');

select * from Autor;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*Inserindo os dados na tabela "Livro": */
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (1,1,1,'Harry Potter e a Pedra Filosofal', 2000);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (1,2,2,'As Cr�nicas de N�rnia', 2009);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (2,3,3,'O Espadachim de Carv�o', 2013);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (3,4,4,'O Papai � Pop', 2015);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (3,5,5,'Pior que t� n�o Fica', 2015);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (1,6,1,'Garota Desdobr�vel', 2015);
INSERT into Livro (fk_id_categoria, fk_id_autor, fk_id_editora, titulo, ano) values (1,1,1,'Harry Potter e o Prisioneiro de Azkaban', 2000);

select * from Livro;
/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
7.	Crie uma consulta para relacionar todos os dados dispon�veis de todos 
os livros existentes na biblioteca em ordem alfab�tica de t�tulo; */


SELECT Livro.ISBN AS 'ISBN',
Livro.titulo AS 'T�tulo',
Livro.ano AS 'Ano',
Editora.nome AS 'Editora',
Autor.nome AS 'Autor',
Autor.nacionalidade AS 'Nacionalidade',
Categoria.nome AS 'Categoria'


FROM Livro, Categoria, Editora, Autor

WHERE Livro.fk_id_categoria = Categoria.id
AND Livro.fk_id_editora = Editora.id
AND Livro.fk_id_autor = Autor.id


/* Ordenando a tabela em ordem alfab�tica de nome: */

ORDER BY Livro.titulo;

/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
8.	Crie uma consulta para relacionar todos os dados dispon�veis de todos
os livros existentes na biblioteca em ordem alfab�tica de autor; */

SELECT Livro.ISBN AS 'ISBN',
Livro.titulo AS 'T�tulo',
Livro.ano AS 'Ano',
Editora.nome AS 'Editora',
Autor.nome AS 'Autor',
Autor.nacionalidade AS 'Nacionalidade',
Categoria.nome AS 'Categoria'


FROM Livro, Categoria, Editora, Autor

WHERE Livro.fk_id_categoria = Categoria.id
AND Livro.fk_id_editora = Editora.id
AND Livro.fk_id_autor = Autor.id


/* Ordenando a tabela em ordem alfab�tica de autor: */

ORDER BY Autor.nome;


/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
9.	Crie uma consulta para relacionar todos os dados dispon�veis
dos livros da categoria de literatura Juvenil em ordem de ano:*/

SELECT Livro.ISBN AS 'ISBN',
Livro.titulo AS 'T�tulo',
Livro.ano AS 'Ano',
Editora.nome AS 'Editora',
Autor.nome AS 'Autor',
Autor.nacionalidade AS 'Nacionalidade',
Categoria.nome AS 'Categoria'


FROM Livro, Categoria, Editora, Autor

WHERE Livro.fk_id_categoria = Categoria.id
AND Livro.fk_id_editora = Editora.id
AND Livro.fk_id_autor = Autor.id


/* Filtrando os livros de humor e fic��o cient�fica: */

AND Categoria.nome = 'Literatura Juvenil'


/* Ordenando a tabela em ordem do ano: */

ORDER BY Livro.ano;

/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */

/*
10.	Crie uma consulta para relacionar todos os dados dispon�veis 
dos livros de humor ou fic��o cient�fica com ano entre 2000 e 2010:*/

SELECT Livro.ISBN AS 'ISBN',
Livro.titulo AS 'T�tulo',
Livro.ano AS 'Ano',
Editora.nome AS 'Editora',
Autor.nome AS 'Autor',
Autor.nacionalidade AS 'Nacionalidade',
Categoria.nome AS 'Categoria'


FROM Livro, Categoria, Editora, Autor

WHERE Livro.fk_id_categoria = Categoria.id
AND Livro.fk_id_editora = Editora.id
AND Livro.fk_id_autor = Autor.id


/* Filtrando os livros da categoria "humor" e "fic��o cient�fica": */

AND Categoria.nome in('Humor' , 'Fic��o Cient�fica')



/* Filtrando para os dados entre os anos de 2000 e 2010: */

AND Livro.ano between 2000 AND 2020

ORDER BY Livro.titulo;

/*- - - - - - - - - - - - - - - - - - - - - - - - - - - */