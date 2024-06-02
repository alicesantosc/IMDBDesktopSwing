package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Avaliacao;
import model.Filme;
import model.Usuario;

public class AvaliacaoDAO {
	
	///metodos para acesso ao db
	
	public void adicionarAvaliacao(Avaliacao avaliacao){
		String sql = "INSERT INTO AVALIACAO(FILME_ID,USUARIO_ID,NOTA,COMENTARIO) values (?,?,?,?)";
		Usuario usuario = new Usuario();
		Filme filme = new Filme();
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, filme.getId());
			stmt.setInt(2,usuario.getId());
			stmt.setInt(3, avaliacao.getNota());
			stmt.setString(4, avaliacao.getComentario());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
