package Inserir;

import java.sql.SQLException;

public class PrincipalBD {

	public static void main(String[] args) throws SQLException {
		// Cria��o da Classe BancoDados
		BancoDados bd = new BancoDados();
		
		// Endere�o para conex�o ao BD
		String urlBD = "jdbc:mysql://localhost:3306/bibliotecalivros?user=root&password=";
		
		// Driver utilizado para acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Conex�o ao BD
		System.out.println(bd.conectar(urlBD, driver));
		
		
	    //Inserindo dados no Banco de dados:	
		
		String isbn = "32512062";
		String titulo = "Harry Potter e o Prisioneiro de Azkaban";
		String ano = "2000";
		System.out.println(bd.inserirAlterarExcluir("INSERT INTO livro (isbn, titulo, ano) values ('"+isbn+"', '"+titulo+"', '"+ano+"')"));

	}

}
