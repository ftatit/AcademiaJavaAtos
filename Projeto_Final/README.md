# Academia Java Atos / UFN

Academia de JAVA (Abril/2022 - Julho/2022)

Projeto Final: "Copa do Mundo 2022"

-------------------------------------------------------------------------
INTRODUÇÃO:

O projeto utilizar os conhecimentos absorvidos durante a Academia Java -
Atos e UFN(abril/22 – julho/22), onde é proposto a construção de um sistema
utilizando a linguagem Java, com a utilização de ferramentas como Spring Boot,
Thymeleaf, Spring Security, MySQL Driver, conexão com banco de dados, 
autenticação de usuário, validação de dados, JPA e conceitos de orientação
a objetos. O front-end do sistema foi desenvolvido com HTML, CSS e foi
utilizado o framework Bootstrap v5.1.3.

-------------------------------------------------------------------------
OBJETIVO:

Como estamos em ano de Copa do Mundo, o projeto em questão trata se de um 
sistema onde os usuários poderão acompanhar as informações sobre a Copa do
Mundo do Qatar 2022 que será realizada entre os dias 21 de novembro e 
18 de dezembro. 

Os usuários do sistema terão acesso os grupos formados, datas dos jogos,
locais das partidas, resultados dos jogos, além de poder participar de um Bolão. 

-------------------------------------------------------------------------
INFORMAÇÕES TÉCNICAS:

Linguagem do sistema: 	Java (Back-end); HTML, CSS, (front-end)
Frameworks:		Bootstrap v5.1.3
Prototipação: 		Marvel (www.marvelapp.com)
Métodos utilizados:	Spring Boot, Thymeleaf, Spring Security, MySQL Driver,
IDE utilizadas: 	Eclipse Ide for Enterprise Java and Web Developers – 2022 -03
Banco de Dados: 	MySQL Workbench

-------------------------------------------------------------------------
PASSO-A-PASSO PARA UTILIZAÇÃO DA APLICAÇÃO:

Para o funcionamento correto do sistema, basta importar o projeto no Eclipse, como "Existing Maven Projects".
Ao rodar a aplicação, ela criará o banco de dados no MySQL Workbench. O banco possui o nome "copa2022teste" 
e cinco tabelas desenvolvidas. 

-----------------------------------------------------------------------------
INFORMAÇÕES SOBRE O BANCO DE DADOS:

Para alimentação das tabelas criadas, após início da aplicação, está disponibilizado todas elas já preenchidas, na pasta "Banco-de-dados", para 
facilitar e agilizar a utilização do sistema desenvolvido. 

A seguir, informações referente as tabelas criadas no banco de dados: 

Tabela de nome: "usuario", 
Arquivo:	copa2022teste_usuario.csv
Descrição:	Importando o arquivo .csv na tabela do banco de dados, já irá adicionar as informações dos usuários e dos administradores
		cadastrados no sistema.

		Usuários administradores cadastrados no arquivo .csv e ativos no sistema:
			-Login: flavio	Senha:flavio
			-Login: admin	Senha:admin

		Usuários comuns cadastrados no arquivo .csv e ativos no sistema:
			-Login: user	Senha:123
			-Login: user2	Senha:123
			-Login: user3	Senha:123
			-Login: user4	Senha:123

Tabela de nome: "jogos":
Arquivo: 	copa2022teste_jogos.csv;
Descrição:	Importando o arquivo .csv na tabela do banco de dados, já irá adicionar as informações dos 64 jogos da copa do mundo, com 
		informações dos times, horário dos jogos, local da partida, grupos, entre outras informações.
		

Tabela de nome: "papel": 
Arquivo:	copa2022teste_papel.csv
Descrição:	Importando o arquivo .csv na tabela do banco de dados, já irá adicionar as informações sobre os possíveis papeis dos usuários,

Tabela de nome: "usuario_papel": 
Arquivo:	copa2022teste_usuario_papel.csv
Descrição:	Importando o arquivo .csv na tabela do banco de dados, já irá adicionar as informações sobre o papel dos usuários cadastrados,
		sendo eles administradores (id=1, papel=admin) ou usuários (id=2,papel=user).

Tabela de nome: "jogos_bolao":
arquivo:	copa2022teste_bolao.csv
Descrição:	Importando o arquivo .csv na tabela do banco de dados, já irá adicionar as informações de 4 usuários participantes do bolão,
		com os palpites dos 64 jogos da copa do mundo.


-----------------------------------------------------------------------------

Documentação completa do sistema disponibilizada no arquivo: 
"Projeto-Final-Copa-do-Mundo.pdf"

Apresentação disponível no documento:
"Apresentacao-Copa-do-Mundo"
