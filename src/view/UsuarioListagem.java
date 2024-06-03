package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatDarkLaf;

import dao.UsuarioDAO;
import model.Usuario;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioListagem extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8897238676831157124L;
	private JTable table;
	private JTextField textField;

	    public UsuarioListagem() {
	        setTitle("Lista de Usuários");
	        setSize(1000, 1000);
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        initComponents();
	        listarUsuarios();
	    }

	    private void initComponents() {
	        getContentPane().setLayout(null);
	        table = new JTable();
	       
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setLocation(0, 0);
	        scrollPane.setSize(984,575);
	        getContentPane().add(scrollPane);
	        
	        JButton btnNewButton = new JButton("Remover por ID");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		int userId = Integer.parseInt(textField.getText());
	        		UsuarioDAO usuarioDAO = new UsuarioDAO();
	        		usuarioDAO.deletarPorIdUsuario(userId);
	        		listarUsuarios();
	        		JOptionPane.showMessageDialog(btnNewButton, "Tabela atualizada com sucesso");
	        		
	        	}
	        });
	        btnNewButton.setBounds(114, 647, 137, 23);
	        getContentPane().add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("New button");
	        btnNewButton_1.setBounds(263, 611, 166, 23);
	        getContentPane().add(btnNewButton_1);
	        
	        textField = new JTextField();
	        textField.setBounds(20, 648, 86, 20);
	        getContentPane().add(textField);
	        textField.setColumns(10);
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


