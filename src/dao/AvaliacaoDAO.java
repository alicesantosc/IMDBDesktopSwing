package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.MediaFilme;

public class AvaliacaoDAO {

	/// metodos para acesso ao db

	public void adicionarAvaliacao(Avaliacao avaliacao) {
		String sql = "INSERT INTO AVALIACAO(filme_id ,usuario_id,NOTA,COMENTARIO) values (?,?,?,?)";
		
		
		try (Connection conn = ConectarDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, avaliacao.getfilmeId());
			stmt.setInt(2, avaliacao.getusuarioId());
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
		List<Avaliacao> avaliacoes = new ArrayList<>();

		String sql = "SELECT * FROM Avaliacao";
		
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
	
	
	
	
	
	public List<MediaFilme> calcularMediaAvaliacoesFilme() {
	    List<MediaFilme> mediaAvaliacoesPorFilme = new ArrayList<>();
	    String sql = "SELECT f.titulo, AVG(a.nota) AS media " +
	                 "FROM Avaliacao a " +
	                 "JOIN Filme f ON a.filme_id = f.id " +
	                 "GROUP BY f.titulo";

	    try (Connection conn = ConectarDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery();) {
	        while (rs.next()) {
	            String tituloFilme = rs.getString("titulo");
	            double media = rs.getDouble("media");
	            mediaAvaliacoesPorFilme.add(new MediaFilme(tituloFilme, media));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return mediaAvaliacoesPorFilme;
	}
}
