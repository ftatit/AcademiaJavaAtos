package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;//Esse recurso é responsavel em executar um comando MySQL a partir do Java.
import java.sql.ResultSet; //Faz parte do JDBC e ele é usado para armazenar o retorno do banco de dados temporariamente em um objeto. 
import java.util.ArrayList;

public class DAO {

	/** CLASSE DAO É A RESPONSÁVEL PARA SE COMUNICAR COM O BD**/

	// Parametros de conexao com o BD:
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/db_produtos?useTimezone=True&serverTimezone=UTC";
	private String user = "root";
	private String password = "1a2b3c4d5e";

	// Metodo de Conexao
	private Connection conectar() {
		Connection con = null; 
		// Criamos o objeto con para estabelecer uma conexao com o banco de dados
		
		try {
			Class.forName(driver); // essa classe vai ler o nome no banco de dados
			
			con = DriverManager.getConnection(url, user, password);
			// "con" estabelece uma secao com o BD. 
			// "DriverManager", irá gerenciar o driver e
			// ".getConnection" ira estabelecer os parametros da conexao
			
			return con; // ou seja, estabeleça a conexao.
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// -----CRUD CREATE (Método de inserção de contatos)---------:

	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos (codigo,nome,categoria,valor,quantidade) values(?,?,?,?,?)";
		try {
			
			// 1º abrir a conexao com o banco de dados:
			Connection con = conectar();
			
			// Proximo passo é preparar a query para ser utilizada, ou seja, o Java vai
			// executar uma instrução no banco de dados MySQL, para isso, utiliza o seguinte 
			// recurso do JDBC classe "PreparedStatement" do JDBC
			// Preparar a query para execução no banco de dados:
		
			PreparedStatement pst = con.prepareStatement(create);
			// classe modelo "pst" = con.metodo(create);

			// Substituir os parametros (?) pelo conteudo das variáveis Javabeans:
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setFloat(4, produto.getValor());
			pst.setInt(5, produto.getQuantidade());

			// Executar a query:
			pst.executeUpdate();
			// esse é metodo que executa a inserção desses dados no banco de dados.

			
			con.close();// Encerrar a conexao com o banco de dados ( se voce nao encerrar 
			// a conexao com o BD vc pode ter problemas de performance e de seguranca.

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * // teste de conexao (para isso o metodo precisa ser publico). 
	 * public void testeConexao() {
	 * usando a palavra void é um metodo sem retorno e sempre
	 * que irá conectar com o BD, precisa usar Try Catch:
	 * 
	 * try { Connection con = conectar();
	 * Usando como modelo a classe "Connection", criamos o obj "con" e
	 * esse objeto executa o metodo "conectar()" 
	 * 
	 * System.out.println(con);//imprime o obj con que tras a String de conexao.
	 * 
	 * con.close(); } catch (Exception e)
	 * 
	 *  { System.out.println(e); } }
	 */

	
	// ---------- CRUD READ ------- Para fazer a listagem de todos os produtos
	// do banco de dados, Criar um metodo com retorno, usando como referencia,
	// um vetor dinâmico:

	public ArrayList<JavaBeans> listarProdutos() {

		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();

		String read = "select * from produtos order by id";
		
		
		// Sempre que trabalhamos com banco de dados, 
		// precisamos do Try & Catch:
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			// JDBC:
			ResultSet rs = pst.executeQuery();

			// Utilizando um laço de repetição para mostrar o resultado:
			// O laço abaixo será executado enquanto houver produtos:
			// O metodo responsavel ira executar um select no banco de dados
			while (rs.next()) {
				
				// variaveis de apoio que recebem os dados do banco:
				int id = rs.getInt(1);
				int codigo = rs.getInt(2);
				String nome = rs.getString(3);
				String categoria = rs.getString(4);
				float valor = rs.getFloat(5);
				int quantidade = rs.getInt(6);
				
				// AInda dentro do laco, armazenar tudo do banco no vetor 
				// dinâmico, que é referenciado por esse metodo pela classe 
				// JavaBeans populando o ArrayList:
				
				produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
				// traduzindo, o objeto PRODUTOS, irá setar as variáveis da classe
				// JavaBeans com a listagem dos produtos

			}
			con.close();//Para finalizar o método, precisamos encerrar a conexao:
			return produtos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// CRUD UPDATE - Precisa de 2 métodos, um para selecionar o produto e outro para
	// efetivamente, alterar o produto.
	
	// Metodo que seleciona o produto:
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where id = ?";
		try {
			Connection con = conectar();// conectando com o BD
			PreparedStatement pst = con.prepareStatement(read2);
			// executando a query para ser executada no BD
			
			pst.setInt(1, produto.getId()); //O método responsável pela seleção do 
			// produto a ser editado requisita da classe JavaBeans o id do produto;
			
			ResultSet rs = pst.executeQuery();//Tendo o id do produto o método executa
			// um select do produto específico no banco de dados;
			
			while (rs.next()) {
				//setar as variaveis JavaBeans com os dados do produto:
				produto.setId(rs.getInt(1));
				produto.setCodigo(rs.getInt(2));
				produto.setNome(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setValor(rs.getFloat(5));
				produto.setQuantidade(rs.getInt(6));
			}
			
			//Para finalizar o método, precisamos encerrar a conexao:
			con.close();
			
		} catch (Exception e) {
			System.out.println();
		}
	}

	//METODO ALTERAR PRODUTO (recebendo os valores da classe JavaBeans):
	public void alterarProduto(JavaBeans produto) {
				
		String create ="update produtos set codigo=?, nome=?, categoria=?, valor=?, quantidade=? where id =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setFloat(4, produto.getValor());
			pst.setInt(5, produto.getQuantidade());
			pst.setInt(6, produto.getId());
			pst.executeUpdate();// Tendo obtido os dados do produto, o método executa o update no banco de dados.
			// ondE os dados sao alterados no banco de dados.
			con.close(); //Para finalizar o método,
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//CRUD DELETE
	public void excluirProduto(JavaBeans produto) {
		String delete = "delete from produtos where id=?";
		try {
			Connection con = conectar(); //abrindo a conexão do banco de dados
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, produto.getId()); //Requisitando da classe JavaBeans o id do produto
			pst.executeUpdate();//O BD retorna o produto ao método
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
