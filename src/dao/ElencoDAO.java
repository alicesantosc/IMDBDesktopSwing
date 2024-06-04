package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Elenco;

public class ElencoDAO {
	
	public void adicionarElenco(Elenco elenco) {
		String sql = "INSERT INTO ELENCO(filme_id, ator_id, papel) VALUES (?,?,?)";
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
				
				stmt.setInt(1, elenco.getFilmeID());
				stmt.setInt(2, elenco.getAtorID());
				stmt.setString(3, elenco.getPapel());
				stmt.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Elenco> listarElenco(){
		List<Elenco> elencos = new ArrayList<>();
		String sql = "SELECT * FROM Elenco";
		try(Connection conn = ConectarDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			while(rs.next()) {
				Elenco elenco = new Elenco();
				elenco.setId(rs.getInt("ID"));
				elenco.setFilmeID(rs.getInt("filme_id"));
				elenco.setAtorID(rs.getInt("ator_id"));
				elenco.setPapel(rs.getString("papel"));
				elencos.add(elenco);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return elencos;
	}

}
