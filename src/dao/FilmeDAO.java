package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Filme;

public class FilmeDAO {
	
	public void adicionarFilme(Filme filme) {
		String sql = "INSERT INTO FILME (titulo, ano, genero, diretor_id) VALUES (?,?,?,?)";
		 try (Connection conn = ConectarDB.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, filme.getTitulo());
	            stmt.setInt(2, filme.getAno());
	            stmt.setString(3, filme.getGenero());
	            stmt.setInt(4, filme.getDiretorId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	public List<Filme> listarFilmes(){
		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM Filme";
		
		
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt. executeQuery()) {
			
			while(rs.next()) {
				Filme filme = new Filme();
				filme.setId(rs.getInt("id"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setAno(rs.getInt("ano"));
				filme.setGenero(rs.getString("genero"));
				filme.setDiretorId(rs.getInt("diretor_id"));
				filmes.add(filme);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filmes;
		
		
	}
	
	
	public void atualizarFilme(Filme filme) {
		String sql = "UPDATE Filme SET titulo = ?, ano = ?, genero = ?, diretor_id = ? WHERE id = ?";
		try (Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, filme.getTitulo());
			stmt.setInt(2, filme.getAno());
			stmt.setString(3, filme.getGenero());
			stmt.setInt(4, filme.getDiretorId());
			stmt.setInt(5, filme.getId());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		 public void deletarFilme(int id) {
		        String sql = "DELETE FROM Filme WHERE id = ?";
		        try (Connection conn = ConectarDB.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {
		            stmt.setInt(1, id);
		            stmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		
	}
		 
	

}
