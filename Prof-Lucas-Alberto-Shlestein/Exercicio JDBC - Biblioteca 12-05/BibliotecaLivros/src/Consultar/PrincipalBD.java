package Consultar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrincipalBD {

	public static void main(String[] args) throws SQLException {
		// Cria��o da Classe BancoDados
		BancoDados bd = new BancoDados();

		// Endere�o para conex�o ao BD
		String urlBD = "jdbc:mysql://localhost:3306/bibliotecalivros?user=root&password=";

		// Driver utilizado para acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";

		// ResultSet "Tabela" com os valores retornados da Busca
		ResultSet resultado = null;

		// Conex�o ao BD
		System.out.println(bd.conectar(urlBD, driver));
		resultado = bd.consultar("select * from livro");

		// Verifica se o resultado retornada da pesquisa junto ao BD n�o � vazio, sen�o
		// for exibe no console
		if (resultado != null)
			while (resultado.next()) {
				System.out.println(/*"id: " + resultado.getString("id") +*/ "\t isbn: " + resultado.getString("isbn")
						+ "\t titulo: " + resultado.getString("titulo") + "\t ano: " + resultado.getString("ano"));
			}

	}

}
