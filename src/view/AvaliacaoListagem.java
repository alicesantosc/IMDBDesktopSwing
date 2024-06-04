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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.AvaliacaoDAO;
import dao.FilmeDAO;
import model.Avaliacao;

public class AvaliacaoListagem extends JFrame {
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JTextField txtDigiteOId;
    private JTextField txtId;

    public AvaliacaoListagem() {
        setTitle("Listagem de Avaliações");
        setSize(791, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("ID_FILME");
        modeloTabela.addColumn("ID_USUARIO");
        modeloTabela.addColumn("NOTA");
        modeloTabela.addColumn("COMENTARIO");

        carregarAvaliacao();
        getContentPane().setLayout(null);

        tabela = new JTable(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0, 51, 765, 377);
        getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel("Avaliações");
        lblNewLabel.setBounds(250, 0, 389, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("<<");
        btnNewButton.setBounds(24, 11, 49, 33);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AvaliacaoForm avaliacaoForm = new AvaliacaoForm();
                avaliacaoForm.setVisible(true);
            }
        });
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setForeground(Color.BLACK);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Adicionar Avaliação");
        btnNewButton_2.setBounds(83, 11, 157, 33);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AvaliacaoForm avaliacaoForm = new AvaliacaoForm();
                avaliacaoForm.setVisible(true);
            }
        });
        btnNewButton_2.setForeground(Color.BLACK);
        btnNewButton_2.setBackground(Color.GRAY);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Remover Avaliação");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	int idDigitado = Integer.parseInt(txtId.getText());
        	
        	AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        	avaliacaoDAO.deletarAvaliacao(idDigitado);
        	carregarAvaliacao();
        	}	
        });
        btnNewButton_1.setBounds(37, 462, 145, 23);
        getContentPane().add(btnNewButton_1);
        
        txtId = new JTextField();
        txtId.setText("id");
        txtId.setBounds(199, 463, 86, 20);
        getContentPane().add(txtId);
        txtId.setColumns(10);
        
        JButton btnNewButton_3 = new JButton("Média de Avaliações");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RelatorioAvaliacaoMedia relatorioAvaliacaoMedia = new RelatorioAvaliacaoMedia();
        		relatorioAvaliacaoMedia.setVisible(true);
        		
        	}
        });
        btnNewButton_3.setBounds(312, 462, 177, 23);
        getContentPane().add(btnNewButton_3);
    }
    
    public void carregarAvaliacao() {
    	modeloTabela.setRowCount(0);
    	 AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
         for (Avaliacao avaliacao : avaliacaoDAO.listarAvaliacoes()) {
             modeloTabela.addRow(new Object[] {
                 avaliacao.getId(),
                 avaliacao.getfilmeId(),
                 avaliacao.getusuarioId(),
                 avaliacao.getNota(),
                 avaliacao.getComentario()
             });
         }
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new AvaliacaoListagem().setVisible(true));
    }
}

   