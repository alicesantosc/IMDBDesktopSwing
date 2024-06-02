package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.AtorDAO;
import model.Ator;

public class AtorForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2327341345975998258L;
	private JTextField txtNome;
	private JTextField txtDataDeNascimento;
	public AtorForm() {
		
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Ator");
		lblNewLabel.setBounds(210, 40, 262, 14);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(70, 77, 151, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtDataDeNascimento = new JTextField();
		txtDataDeNascimento.setText("data de nascimento");
		txtDataDeNascimento.setBounds(70, 124, 151, 20);
		panel.add(txtDataDeNascimento);
		txtDataDeNascimento.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//intancio ator e set e get
				Ator ator = new Ator();
				ator.setNome(txtNome.getText());
				ator.setData_nascimento(LocalDate.parse(txtDataDeNascimento.getText()));
				
				new AtorDAO().adicionarAtor(ator);
				JOptionPane.showMessageDialog(btnNewButton, "Ator adicionado com sucesso");
				
				
				}
		});
		btnNewButton.setBounds(67, 213, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar Atores");
		btnNewButton_1.setBounds(179, 213, 116, 23);
		panel.add(btnNewButton_1);
	}
	
	public static void main(String[] args) {
		FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new AtorForm().setVisible(true));
	}
}
