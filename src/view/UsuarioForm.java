package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2560248226035150795L;
	private JTextField textField;
	private JTextField textField_1;

	public UsuarioForm() {

		setTitle("Adicionar Usuario");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 67, 469, 14);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 387, 469, 14);
		panel.add(separator_1);

		textField = new JTextField();
		textField.setBounds(163, 164, 165, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(UsuarioForm.class.getResource("/Imagem/Captura de tela 2024-06-01 190325.png")));
		lblNewLabel.setBounds(191, 11, 137, 45);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Crie uma conta");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(152, 92, 220, 34);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(162, 139, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(163, 203, 46, 14);
		panel.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(163, 226, 165, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Junte-se a nós");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancio objeto, set e get do textfield
				
				Usuario usuario = new Usuario();
				usuario.setNome(textField.getText());
				usuario.setEmail(textField_1.getText());
				
				new UsuarioDAO().adicionarUsuario(usuario);
				JOptionPane.showMessageDialog(btnNewButton, "Seja bem vindo");
				/// teste pra saber se ta funfando 
				System.out.println(usuario.getNome());
				
			}
		});
		btnNewButton.setBounds(163, 304, 180, 23);
		panel.add(btnNewButton);
		
		//futuramente tirarei esse botão
		
		JButton btnNewButton_1 = new JButton("Listar Usuarios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(163, 357, 180, 23);
		panel.add(btnNewButton_1);
		
		
		
		
		
	}

	public static void main(String[] args) {
		FlatDarkLaf.setup();

		SwingUtilities.invokeLater(() -> new UsuarioForm().setVisible(true));
	}

}
