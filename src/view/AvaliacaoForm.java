package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.AvaliacaoDAO;
import dao.FilmeDAO;
import dao.UsuarioDAO;
import model.Avaliacao;
import model.Filme;

public class AvaliacaoForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3483132610652697496L;
	private JTextField txtDeixeSeuComentrio;
	private JTextField txtUsuario;
	private JTextField txtEmail_1;

	public AvaliacaoForm() {
		setSize(500,500);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuário");
		txtUsuario.setBounds(60, 61, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setText("Email");
		txtEmail_1.setBounds(167, 61, 181, 20);
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
		
		JComboBox avaliacaoComboBox = new JComboBox();
		avaliacaoComboBox.setBounds(60, 107, 193, 22);
		panel.add(avaliacaoComboBox);
		carregarFilmes(avaliacaoComboBox);
		
		JLabel lblNewLabel = new JLabel("Avalie um filme");
		lblNewLabel.setBounds(182, 24, 181, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nota:");
		lblNewLabel_1.setBounds(60, 140, 46, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox notaComboBox = new JComboBox();
		notaComboBox.addItem(1);
		notaComboBox.addItem(2);
		notaComboBox.addItem(3);
		notaComboBox.addItem(4);
		notaComboBox.addItem(5);
		
		notaComboBox.setBounds(134, 136, 61, 22);
		panel.add(notaComboBox);
		
		txtDeixeSeuComentrio = new JTextField();
		txtDeixeSeuComentrio.setText("Deixe seu comentário....");
		txtDeixeSeuComentrio.setBounds(61, 188, 263, 109);
		panel.add(txtDeixeSeuComentrio);
		txtDeixeSeuComentrio.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Avaliar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filmeSelecionado = (Filme) avaliacaoComboBox.getSelectedItem();
				
				String nomeUsuario = txtUsuario.getText();
				String emailUsuario = txtEmail_1.getText();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
                int idUsuario = usuarioDAO.buscarIdUsuario(nomeUsuario, emailUsuario);
                if (idUsuario != -1) {
                    System.out.println("Usuario ID: " + idUsuario); // Debugging print
                
                    
                }
				Avaliacao avaliacao = new Avaliacao();
				
				avaliacao.setusuarioId(idUsuario);
				avaliacao.setfilmeId(filmeSelecionado.getId());
				
				avaliacao.setComentario(txtDeixeSeuComentrio.getText());
				
				avaliacao.setfilmeId(filmeSelecionado.getId());
				 if (notaComboBox.getSelectedItem() != null) {
			            // Obtém a nota selecionada
			            int notaSelecionada = (int) notaComboBox.getSelectedItem();
			            avaliacao.setNota(notaSelecionada);

			            // Adiciona a avaliação à tabela
			            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
			            avaliacaoDAO.adicionarAvaliacao(avaliacao);

			            // Atualiza a tabela de avaliações
			            //atualizarTabelaAvaliacoes();
			        } else {
			            JOptionPane.showMessageDialog(btnNewButton_1, "Por favor, selecione uma nota.");
			        }
				 
				 
				 JOptionPane.showMessageDialog(btnNewButton_1, "Avaliacao feita com sucesso");
			}
			    
			});
		
				
			
				
			
		
		btnNewButton_1.setBounds(60, 367, 264, 23);
		panel.add(btnNewButton_1);
		
		
		
		
		btnNewButton_2.setBounds(358, 60, 89, 23);
		panel.add(btnNewButton_2);
		
		
	}

	public void carregarFilmes(JComboBox avaliacaoComboBox) {
		FilmeDAO filmeDAO = new FilmeDAO();
		List<Filme> filmes = filmeDAO.listarFilmes();
		for (Filme filme : filmes) {
			avaliacaoComboBox.addItem(filme);
		}

	}

	public static void main(String[] args) {
		FlatDarkLaf.setup();
		SwingUtilities.invokeLater(() -> new AvaliacaoForm().setVisible(true));
	}
}
