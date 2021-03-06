/*Criando o banco de dados:*/
create database db_produtos;

/*Selecionando o banco de dados:*/
use db_produtos;

/*Criando a tabela do banco de dados:*/
create table produtos(
	id int primary key auto_increment,
	codigo int not null unique,
    nome varchar (50) not null,
	categoria varchar(50) ,
	valor float (10,2) not null ,
	quantidade int(2) not null 
);
/*Descrevendo os parametros das colunas da tabela:*/
describe produtos;

/*Selecionando a tabela:*/
select * from produtos;

/*Testando alimentação da tabela:*/
INSERT into produtos (codigo, nome, categoria, valor, quantidade) values (1000,'teste_nome','teste_categoria',5.5,4);

/*Listando as tabelas do banco de dados:*/
show tables;

/* TESTANDO OS MÉTODOS CRUD:*/

/* CRUD CREATE*/
insert into produtos(codigo,nome,categoria,valor,quantidade) values (1000,'teste2','teste3',50.65,100);

/* CRUD READ*/
select * from produtos;

/* COMANDO PARA LISTAR OS CONTATOS POR ORDEM ALFABÉTICA*/
select * from produtos order by nome;

/* SELECIONANDO UM CONTATO ESPECÍFICO*/
select * from produtos where id = 7;

/* CRUD UPDATE*/
update produtos set nome='desodorante' where id=7;
update produtos set nome='panela', categoria='cozinha', valor=80.50, quantidade=3 where id=7;

/* CRUD DELETE*/
delete from produtos where id = 7;

