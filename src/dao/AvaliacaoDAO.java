package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.Filme;
import model.Usuario;

public class AvaliacaoDAO {

	/// metodos para acesso ao db

	public void adicionarAvaliacao(Avaliacao avaliacao) {
		String sql = "INSERT INTO AVALIACAO(FILME_ID,USUARIO_ID,NOTA,COMENTARIO) values (?,?,?,?)";
		Usuario usuario = new Usuario();
		Filme filme = new Filme();
		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, filme.getId());
			stmt.setInt(2, usuario.getId());
			stmt.setInt(3, avaliacao.getNota());
			stmt.setString(4, avaliacao.getComentario());
			stmt.executeUpdate();
			System.out.println("Avaliação feita");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/// fazendo a lista das avaliações

	public List<Avaliacao> listarAvaliacoes() {
		String sql = "SELECT * FROM Avaliacao";
		List<Avaliacao> avaliacoes = new ArrayList<>();

		try (Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(rs.getInt("id"));
				avaliacao.setfilmeId(rs.getInt("filme_id"));
				avaliacao.setusuarioId(rs.getInt("usuario_id"));
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setComentario(rs.getString("comentario"));
				avaliacoes.add(avaliacao);
				/// stmt.executeUpdate(sql);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return avaliacoes;

	}

	public void deletarAvaliacao(int id) {
		String sql = "DELETE FROM Avaliacao WHERE id = ?";
		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
