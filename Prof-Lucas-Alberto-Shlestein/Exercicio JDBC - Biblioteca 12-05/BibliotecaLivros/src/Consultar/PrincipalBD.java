package Consultar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrincipalBD {

	public static void main(String[] args) throws SQLException {
		// Criação da Classe BancoDados
		BancoDados bd = new BancoDados();

		// Endereço para conexão ao BD
		String urlBD = "jdbc:mysql://localhost:3306/bibliotecalivros?user=root&password=";

		// Driver utilizado para acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";

		// ResultSet "Tabela" com os valores retornados da Busca
		ResultSet resultado = null;

		// Conexão ao BD
		System.out.println(bd.conectar(urlBD, driver));
		resultado = bd.consultar("select * from livro");

		// Verifica se o resultado retornada da pesquisa junto ao BD não é vazio, senão
		// for exibe no console
		if (resultado != null)
			while (resultado.next()) {
				System.out.println(/*"id: " + resultado.getString("id") +*/ "\t isbn: " + resultado.getString("isbn")
						+ "\t titulo: " + resultado.getString("titulo") + "\t ano: " + resultado.getString("ano"));
			}

	}

}
