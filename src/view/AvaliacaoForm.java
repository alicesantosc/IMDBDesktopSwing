package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.UsuarioDAO;
import model.Avaliacao;

public class AvaliacaoForm extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3483132610652697496L;
	private JTextField txtDigiteOFilme;
	private JTextField txtDeixeSeuComentrio;
	private JTextField txtUsuario;
	private JTextField txtEmail_1;
	
	public AvaliacaoForm() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Avalie um filme");
		lblNewLabel.setBounds(182, 24, 181, 14);
		panel.add(lblNewLabel);
		
		txtDigiteOFilme = new JTextField();
		txtDigiteOFilme.setText("Digite o filme ....");
		txtDigiteOFilme.setBounds(60, 89, 255, 20);
		panel.add(txtDigiteOFilme);
		txtDigiteOFilme.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(325, 88, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nota:");
		lblNewLabel_1.setBounds(60, 140, 46, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 136, 30, 22);
		panel.add(comboBox);
		
		txtDeixeSeuComentrio = new JTextField();
		txtDeixeSeuComentrio.setText("Deixe seu comentário....");
		txtDeixeSeuComentrio.setBounds(61, 188, 263, 109);
		panel.add(txtDeixeSeuComentrio);
		txtDeixeSeuComentrio.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Avaliar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				;
				
			}
		});
		btnNewButton_1.setBounds(60, 367, 264, 23);
		panel.add(btnNewButton_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuário");
		txtUsuario.setBounds(60, 61, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setText("Email");
		txtEmail_1.setBounds(167, 61, 86, 20);
		panel.add(txtEmail_1);
		txtEmail_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Entrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario = txtUsuario.getText();
				String emailUsuario = txtEmail_1.getText();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
                int idUsuario = usuarioDAO.buscarIdUsuario(nomeUsuario, emailUsuario);
                if(idUsuario != -1) {
                	Avaliacao avaliacao = new Avaliacao();
                	avaliacao.setusuarioId(idUsuario);
                	JOptionPane.showMessageDialog(btnNewButton_2, "Você entrou na sua conta com sucesso!");
                }else {
                	UsuarioForm usuarioForm = new UsuarioForm();
                	usuarioForm.setVisible(true);
                }
			}
		});
		btnNewButton_2.setBounds(325, 60, 89, 23);
		panel.add(btnNewButton_2);
	}

	public static void main(String[] args) {
		FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new AvaliacaoForm().setVisible(true));
	}
}
