package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO; //para o Servlet utilizar o metodo teste conexao, é necessário importar essa classe. E tbm precisamos criar um objeto
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
// Main é uma requisição que o Servlet irá trabalhar.
// /insert: A camada controller consegue receber os dados do formulário.

//CLASSE PRINCIPAL DO SERVLET:
public class Controller extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO(); // usando como modelo a classe DAO, criamos um objeto de nome DAO
	JavaBeans produto = new JavaBeans(); 
	// O objeto "produto", consegue acessar os métodos públicos da classe JavaBeans

	public Controller() {
		super();

	}

	// MÉTODO PRINCIPAL DO SERVLET:
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				

		String action = request.getServletPath();
		System.out.println(action); // Printando os testes

		
		if (action.equals("/main")) {
			produtos(request, response); // metodo "produtos"

			// se o conteudo da variável action for igual a /main.
			// Em Java quando queremos fazer uma comparação de strings utilizamos .equals
			// Se o metodo doGet receber a requesição /main ira redirecionar ao metodo
			// que irá trabalhar especificamente essa requesição.

		} else if (action.equals("/insert")) { 
			// Se o conteudo da variavel action agora for insert, vc irá
			// redirecionarao ao metodo responsavel por encaminhar essa requesicao a
			// camada model, vamos chamar de novoProduto:
			
			novoProduto(request, response); // metodo "novoProduto"

		}

		else if (action.equals("/select")) {
			listarProduto(request, response); // metodo "listarProduto"

		} else if (action.equals("/update")) {
			editarProduto(request, response); // metodo "editarProduto"

		} else if (action.equals("/delete")) {
			excluirProduto(request, response); // metodo "excluirProduto"

		} else {
			response.sendRedirect("index.html"); 
			// Se o servlet receber alguma requisição que ele nao conhece. 
			//Redireciona ele para o documento index.html
		}

		/*Fazendo o teste de conexao usando o objeto DAO: 
		  dao.testeConexao(); 
		  o metodo testeConexao irá imprimir a String de conexao se tudo
		  estiver ok. E se der algum problema ele mostrará qual será o erro.*/
	} 

	// METODO DE LISTAS PRODUTOS
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("produtos.jsp"); Criando um objeto que irá receber
		// os dados JavaBeans 
		
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		/* tendo como referencia a classe modelo "ArrayList",passando como parametro
		  a classe "JavaBeans", criar um objeto "lista", e esse objeto executa o
		  método "listarProdutos()", dentro da classe DAO. A "lista" é um vetor
		  dinamico que esta recebendo todos os dados do banco de dados.	*/
		
		
		// Encaminhando a "lista" ao documento "produtos.jsp"
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		// É uma classe modelo que trabalha com requisições e respostas no Servlet
		
		rd.forward(request, response); 
		/*A camada Controller redireciona a resposta para o documento produto.jsp.
		 * Esse documento irá gerar de forma dinâmica, uma tabela contendo os 
		 * dados de todos os produto armazenados no BD.*/
	}

	// MÉTODO DE CRIAR PRODUTOS
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		/* Fazendo um teste para verificar se o Servlet esta recebendo 
		 * os dados do formulário:
		 response.sendRedirect("produtos.jsp");
		
		ESSAS 5 PÁGINAS SÃO PARA TESTE DE CONEXÃO:
		System.out.println(request.getParameter("codigo"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("categoria"));
		System.out.println(request.getParameter("valor"));
		System.out.println(request.getParameter("quantidade"));*/

		
		//Setando as variáveis do JavaBeans:
		// O objeto produto, consegue atraves do metodo "setCodigo", armazenar na
		// variávl código o valor que ele está recebendo do formulário de produto.
		
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));

		produto.setNome(request.getParameter("nome"));

		produto.setCategoria(request.getParameter("categoria"));

		produto.setValor(Float.parseFloat(request.getParameter("valor").replaceAll(",", ".")));

		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		//CHAMANDO O METODO "inserirProduto" passando o objeto contato
		dao.inserirProduto(produto);

		// Para finalizar o método novoProduto, faz o redirecionar 
		// para o documento produtos.jsp:
		response.sendRedirect("main");
	}

	// DUAS ETAPAS PARA ALTERAR UM PRODUTO, LISTAR E ALTERAR.
	// MÉTODO LISTAR PRODUTO(1o envolve selecionar o contato que será alterado):
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recebimento do id do contato que será editado:
		int id = (Integer.parseInt(request.getParameter("id")));
		
		// Verifica se o botao "editar" esta mandando a requisição ao servlet:
		// System.out.println(id); (se o servlet esta recebendo o id do produto).

		// Setar a variável JavaBeans
		produto.setId(id);

		// Executar o metodo selecionarProduto(DAO):
		dao.selecionarProduto(produto);

	
		// O método seta as variáveis JavaBeans com os dados do produto:
		request.setAttribute("id", produto.getId()); 
		request.setAttribute("codigo", produto.getCodigo());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("valor", produto.getValor());
		request.setAttribute("quantidade", produto.getQuantidade());
		//A classe JavaBeans encaminha os dados do produto ao servlet ".getId()".

		// Encaminhando ao documento editar.jsp:		
		// O servlet redireciona esses dados ao documento editar.jsp.
		// Os campos desse formulário, são preenchidos automaticamente 
		// com os dados do produto que será editado;
		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	// MÉTODO EDITAR PRODUTO:
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// setar as variáveis Javabeans:
		produto.setId(Integer.parseInt(request.getParameter("id")));
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setValor(Float.parseFloat(request.getParameter("valor").replaceAll(",", ".")));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		// executar o método alterarProduto:
		dao.alterarProduto(produto);
		
		// Redirecionando para o documento produto.jsp (atualizando as alterações).
		response.sendRedirect("main");
	}

	// MÉTODO EXCLUIR PRODUTO:
	protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recebendo o id do produto a ser excluído(validador.js)
		int id = (Integer.parseInt(request.getParameter("id")));
		// testando:
		// System.out.println(id);
		
		produto.setId(id); 
		//o Servlet executa o método da classe DAO, responsável por fazer um 
		// select do produto que será excluido;

		// Executando o metodo excluirProduto(DAO) passando o objeto produto como
		// parametro:
		dao.excluirProduto(produto);

		// Redirecionando para o documento produto.jsp (atualizando as alterações).
		response.sendRedirect("main");

	}

}
