package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.FilmeDAO;
import model.Filme;

public class FilmeListagem extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3009297287500918380L;
	private JTable tabela;
    private DefaultTableModel modeloTabela;

    public FilmeListagem() {
        setTitle("Listagem de Filmes");
        setSize(791, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria o modelo de tabela com as colunas necessárias
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Ano");
        modeloTabela.addColumn("Gênero");
        // Adicione mais colunas conforme necessário

        // Recupera os filmes do banco de dados
        FilmeDAO filmeDAO = new FilmeDAO();
        for (Filme filme : filmeDAO.listarFilmes()) {
            modeloTabela.addRow(new Object[] { filme.getId(), filme.getTitulo(), filme.getAno(), filme.getGenero() });
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
        	private int exitOnClose;

			public void actionPerformed(ActionEvent e) {
				
				FilmeForm filmeForm = new FilmeForm();
				filmeForm.setVisible(true);
				
        	}
        });
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(24, 11, 49, 33);
        getContentPane().add(btnNewButton);
    }

    public static void main(String[] args) {
    	FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new FilmeListagem().setVisible(true));
    }
}