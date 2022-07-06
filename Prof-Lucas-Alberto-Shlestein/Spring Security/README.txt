Aluno: Flavio Henrique Rosa Tatit Junior

Professor: Lucas Schlestein

Atividade: Exercício Spring Boot + Security + Rest + JPA

https://github.com/ftatit/AcademiaJavaAtos/

Enunciado:

Este exercício tem por objetivo revisar e avaliar os conhecimentos absorvidos até o momento atual do curso de Java Web e também servir como motivação para o projeto final do curso. Os professores Herysson Figueiredo e Lucas Schlestein vão ajudar os alunos durante o processo de desenvolvimento do mesmo.
Requisitos:
Elaborar um aplicação web, para manter o cadastro de pessoas (usuários) de um portfólio da Empresa JUsers.

São requisitos desse cadastro, cadastrar novos usuário, visualizar os usuários já cadastrados, excluir usuários e também alterar usuários já cadastrados.
Também, as regras de negócio, para visualização, cadastro, edição e exclusão de pessoas, deverão ser desenvolvidas.
Os usuários a serem mantidos devem ter as seguintes informações: nome do usuário, email, senha, e grupo de usuário (Role).
Informações sobre os usuários serem mantidos:
•	Seu nome deve ser único e seu preenchimento é obrigatório para o cadastro. Serão considerados nomes de até 50 caracteres.
•	O email do usuário, deverá ser único e também deverá ter uma validação mínima ex: (aaa@aaa.aaa, bbb@bbb.bb). Serão admitidos emails de até de até 50 caracteres.
•	Todo usuário, deverá ter uma função (role) atrelada a ele. As roles são: (ADMIN, e USER).

Para a navegação o sistema deve possuir:
•	Uma página home onde o usuário possa escolher o que se deseja fazer (cadastrar, visualizar, alterar ou deletar um usuário),
•	Uma página para login.
•	Uma página de cadastro de usuários;
•	Uma página de listagem de usuários com as opções de: 
o	○ Excluir um usuários
o	○ Alterar um usuário
•	Uma página para alteração de usuário.
Todas as páginas têm que possuir uma forma de redirecionamento para a página principal.
Para a segurança os requisitos são os seguintes:
•	O acesso a página home é irrestrito a qualquer acesso, seja esse logado ou não.
•	Usuários logados como USER, terão acesso somente a visualização dos usuários já cadastrados, não podendo acessar as demais páginas da aplicação.
•	Demais páginas, só serão acessadas por usuários logados com a função ADMIN, incluindo a visualização da lista de usuários cadastrados.
•	Enquanto logado, o usuário terá acesso a aplicação, respeitando seu nível de acesso (ADMIN ou USER).
•	O mesmo terá acesso até que faça logout na aplicação.
Roteiro:
Utilizando os conhecimentos (Banco de dados, Java OO, JPA, Thymeleaf, Spring Boot e, a arquitetura de software MVC …) desenvolver a aplicação web para atender os requisitos acima.
Criar um banco de dados chamado “usuarios” e criar a entidade abaixo dentro desta base de dados.
 

