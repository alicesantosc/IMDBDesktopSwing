package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatDarkLaf;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioListagem extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8897238676831157124L;
	private JTable table;

	    public UsuarioListagem() {
	        setTitle("Lista de Usuários");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        initComponents();
	        listarUsuarios();
	    }

	    private void initComponents() {
	        table = new JTable();
	        JScrollPane scrollPane = new JScrollPane(table);
	        getContentPane().add(scrollPane, BorderLayout.CENTER);
	    }

	    private void listarUsuarios() {
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        List<Usuario> usuarios = usuarioDAO.listarUsuario();
	       

	        // Define as colunas da tabela
	        String[] colunas = {"ID", "Nome", "Email"};
	        DefaultTableModel model = new DefaultTableModel(colunas, 0);

	        // Preenche a tabela com os dados dos usuários
	        for (Usuario usuario : usuarios) {
	            Object[] rowData = {usuario.getId(), usuario.getNome(), usuario.getEmail()};
	            model.addRow(rowData);
	        }

	        table.setModel(model);
	    }

	    public static void main(String[] args) {
	    	FlatDarkLaf.setup();
	        SwingUtilities.invokeLater(() -> new UsuarioListagem().setVisible(true));
	    }
	}


