package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Diretor;

public class DiretorDAO {
	
	public void adicionarDiretor(Diretor diretor) {
		String sql = " INSERT INTO DIRETOR(nome, data_nascimento) VALUES (?,?) ";
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, diretor.getNome());
			stmt.setDate(2,Date.valueOf(diretor.getData_nascimento()));
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Diretor> listarDiretores(){
		List<Diretor> diretores = new ArrayList<>();
		String sql = " SELECT * FROM Diretor";
		
		try (Connection conn = ConectarDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			
			while(rs.next()) {
				Diretor diretor = new Diretor();
				diretor.setId(rs.getInt("id"));
				diretor.setNome(rs.getString("nome"));
				//perceba como jdbc é fdp com localdate
				diretor.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
				diretores.add(diretor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return diretores;
		
	}

}
