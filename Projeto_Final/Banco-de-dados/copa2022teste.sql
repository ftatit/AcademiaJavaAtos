/*Criando o banco de dados:*/
create database copa2022teste;

/*Selecionando o banco de dados:*/
use copa2022teste;

/*Descrevendo os parametros das colunas da tabela:*/
describe jogos;
describe usuario;
describe bolao;
describe papel;
describe usuario_papel;
describe jogos_bolao;


/*Selecionando as tabelas:*/
select * from jogos;
select * from usuario;
select * from papel;
select * from usuario_papel;
select * from bolao;

/*Testando alimentação da tabela:*/
INSERT into tb_copa2022 (idJogo, Grupo, Time1, GolsTime1, x, GolsTime2, Time2, DataJogo) values ('Jogo 01','A','Senegal',1,'x',4, 'Holanda', '2022-11-21 07:00:00');
INSERT into tb_copa2022 (idJogo, Grupo, Time1, GolsTime1, x, GolsTime2, Time2, DataJogo) values ('Jogo 02','B','Inglaterra',1,'x',1, 'Iran', '2022-11-21 10:00:00');
INSERT into tb_copa2022 (idJogo, Grupo, Time1, GolsTime1, x, GolsTime2, Time2, DataJogo) values ('Jogo 03','A','Qatar',2,'x',2, 'Equador', '2022-11-21 13:00:00');

/*Deixando usuário ativo:*/
update usuario set ativo = true where id =3 ;

/*Alterando o usuário de id 3 para ADM:*/
update usuario_papel set papel_id = 1 where usuario_id = 3;

/*Deletando tabela criada:*/
drop table jogos;
drop table usuario;
drop table papel;
drop table usuario_papel;
drop table jogos_bolao;
drop table bolao;
