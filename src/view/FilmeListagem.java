package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.FilmeDAO;
import model.Filme;
import javax.swing.JTextField;

public class FilmeListagem extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3009297287500918380L;
	private JTable tabela;
	private DefaultTableModel modeloTabela;
	private JTextField txtDigiteOId;

	public FilmeListagem() {
		setTitle("Listagem de Filmes");
		setSize(791, 550);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cria o modelo de tabela com as colunas necessárias
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Título");
		modeloTabela.addColumn("Ano");
		modeloTabela.addColumn("Gênero");
		modeloTabela.addColumn("Diretor_ID");

		// Adicione mais colunas conforme necessário

		// Recupera os filmes do banco de dados
		FilmeDAO filmeDAO = new FilmeDAO();
		for (Filme filme : filmeDAO.listarFilmes()) {
			modeloTabela.addRow(new Object[] { filme.getId(), filme.getTitulo(), filme.getAno(), filme.getGenero(),
					filme.getDiretorId() });
			// Adicione mais colunas conforme necessário
		}
		getContentPane().setLayout(null);

		// Cria a tabela e define o modelo de tabela
		tabela = new JTable(modeloTabela);

		// Adiciona a tabela a um painel de rolagem
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(0, 51, 765, 377);
		getContentPane().add(scrollPane);

		JLabel lblNewLabel = new JLabel("Catálogo de Filmes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(123, 1, 389, 43);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FilmeForm filmeForm = new FilmeForm();
				filmeForm.setVisible(true);

			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(24, 11, 49, 33);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Buscar Filme");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				BuscarFilmeView buscarFilmeView = new BuscarFilmeView();
				buscarFilmeView.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(365, 11, 110, 29);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Adicionar Filme");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FilmeForm filmeForm = new FilmeForm();
				filmeForm.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(22, 455, 160, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Deletar Filme");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filmeId = 0;
				try {
					filmeId = Integer.parseInt(txtDigiteOId.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnNewButton_3, "Digite um ID");
				}

				FilmeDAO filmeDAO = new FilmeDAO();
				filmeDAO.deletarFilme(filmeId);
				JOptionPane.showMessageDialog(btnNewButton_3, "Filme deletado");

				filmeDAO.listarFilmes();

			}
		});
		btnNewButton_3.setBounds(209, 455, 146, 23);
		getContentPane().add(btnNewButton_3);

		txtDigiteOId = new JTextField();
		txtDigiteOId.setText("digite o id");
		txtDigiteOId.setBounds(365, 456, 86, 20);
		getContentPane().add(txtDigiteOId);
		txtDigiteOId.setColumns(10);
	}

	public static void main(String[] args) {
		FlatDarkLaf.setup();
		SwingUtilities.invokeLater(() -> new FilmeListagem().setVisible(true));
	}
}