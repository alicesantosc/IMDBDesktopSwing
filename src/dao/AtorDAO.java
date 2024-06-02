package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ator;

public class AtorDAO {
	//metodos para acessar o db e realizar operations
	
	public void adicionarAtor(Ator ator) {
		//primeiro string sql
		String sql = "INSERT INTO ATOR(NOME,DATA_NASCIMENTO) VALUES (?,?)";
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			//setando os stmt
			
			stmt.setString(1, ator.getNome());
			stmt.setDate(2,Date.valueOf(ator.getData_nascimento()));
			//executar o update
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Ator> listarAtores(){
		//crio o array
		List<Ator> atores = new ArrayList<>();
		///string sql
		String sql = "SELECT * FROM ATORES";
		try(Connection conn = ConectarDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();){
			///faço o loop e instacio e set e get neles
			while(rs.next()) {
				Ator ator = new Ator();
				ator.setId(rs.getInt("id"));
				ator.setNome(rs.getString("nome"));
				ator.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
				atores.add(ator);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return atores;
		
		
	}

}
