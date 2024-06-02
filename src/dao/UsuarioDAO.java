package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {

	/// na dao eu tenho a porra dos metodos
	public void adicionarUsuario(Usuario usuario) {

		/// primeiro string sql
		String sql = "INSERT INTO USUARIO(nome, email) VALUES (?,?)";
		// iniciando a droga da conexão

		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/// para lista crio um metodo de lista
	public List<Usuario> listarUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM USUARIO";
		// uso do resultset pq estou pegando um resultado da tabela
		try (Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			/// uso do while, instancio um objeto e faço os set get

			while (rs.next()) {
				int id = rs.getInt("Id");
				String nome = rs.getString("nome");
				String email = rs.getString("Email");
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setEmail(email);

				usuarios.add(usuario);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuarios;

	}

	public int buscarIdUsuario(String nome, String email) {
		int idUsuario = -1;
		String sql = "SELECT id from Usuario WHERE nome = ? AND email = ?";
		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, nome);
			stmt.setString(2, email);
			// no rs eu executo a Query
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				idUsuario = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idUsuario;

	}

	public int deletarPorIdUsuario(int id) {
		String sql = "DELETE FROM Usuario WHERE ID = ?";
		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Usuário com ID " + id + " removido com sucesso.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;

	}

}
