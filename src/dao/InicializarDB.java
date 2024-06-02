package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializarDB {
	public static void initialize() {
		try (Connection conn = ConectarDB.getConnection(); Statement stmt = conn.createStatement()) {

			String sqlDiretor = "CREATE TABLE IF NOT EXISTS Diretor (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "nome TEXT NOT NULL," + "data_nascimento date)";
			stmt.execute(sqlDiretor);

			String sqlFilme = "CREATE TABLE IF NOT EXISTS Filme (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "titulo TEXT NOT NULL, " + "ano INTEGER NOT NULL, " + "genero TEXT NOT NULL, "
					+ "diretor_id INTEGER, " + "FOREIGN KEY (diretor_id) REFERENCES Diretor (id))";
			stmt.execute(sqlFilme);

			String sqlAtor = "CREATE TABLE IF NOT EXISTS Ator (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "nome TEXT NOT NULL," + "data_nascimento date)";
			stmt.execute(sqlAtor);

			String sqlElenco = "CREATE TABLE IF NOT EXISTS Elenco (" + "id INTEGER  PRIMARY KEY AUTOINCREMENT, "
					+ "filme_id INTEGER, " + "ator_id INTEGER, " + "papel text , "
					+ "FOREIGN KEY (filme_id) REFERENCES Filme (id), " + "FOREIGN KEY (ator_id) REFERENCES Ator (id))";
			stmt.execute(sqlElenco);

			String sqlUsuario = " CREATE TABLE IF NOT EXISTS Usuario (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "nome text not null," + "email text)";
			stmt.execute(sqlUsuario);

			String sqlAvaliacao = "CREATE TABLE IF NOT EXISTS Avaliacao (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "filme_id INTEGER, " + "usuario_id integer, " + "nota INTEGER NOT NULL, " + "comentario TEXT, "
					+ "FOREIGN KEY (filme_id) REFERENCES Filme (id), "
					+ "FOREIGN KEY (usuario_id) REFERENCES Usuario (id))";
			stmt.execute(sqlAvaliacao);

			System.out.println("Tabelas criadas com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
