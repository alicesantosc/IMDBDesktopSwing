package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.DiretorDAO;
import dao.FilmeDAO;
import model.Diretor;
import model.Filme;

public class BuscarFilmeView extends JFrame {

    public BuscarFilmeView() {
        setSize(700, 700);
        ///setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable suaTabela = new JTable();
        JPanel panel = new JPanel(); // Usando BorderLayout
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel topPanel = new JPanel(); // Painel para os componentes superiores
        topPanel.setBounds(0, 0, 684, 33);
        panel.add(topPanel);
        topPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Buscar Filme");
        lblNewLabel.setBounds(77, 9, 87, 14);
        topPanel.add(lblNewLabel);
        
        
       

        JLabel lblNewLabel_1 = new JLabel("Por diretor");
        lblNewLabel_1.setBounds(341, 9, 102, 14);
        topPanel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(411, 5, 102, 23);
        topPanel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane(suaTabela); // Adicionando a tabela em um JScrollPane
        scrollPane.setBounds(0, 33, 684, 628);
        panel.add(scrollPane);
        
 //////
        
        JComboBox diretorcomboBox = new JComboBox();
        diretorcomboBox.setBounds(200, 5, 121, 22);
        diretorcomboBox.addItem("Selecione um diretor");
        topPanel.add(diretorcomboBox);
        carregarDiretores(diretorcomboBox);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Diretor diretorSelecionado = (Diretor) diretorcomboBox.getSelectedItem();
            	
                FilmeDAO filmeDAO = new FilmeDAO();
                List<Filme> filmes = filmeDAO.buscarFilmeporDiretor(diretorSelecionado.getNome());
              

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("ID");
                tableModel.addColumn("Título");
                tableModel.addColumn("Ano");
                tableModel.addColumn("Gênero");
                
                
                for (Filme filme : filmes) {
                    Object[] row = {
                        filme.getId(),
                        filme.getTitulo(),
                        filme.getAno(),
                        filme.getGenero()
                    };
                    tableModel.addRow(row);
                }

                suaTabela.setModel(tableModel);
                JOptionPane.showMessageDialog(btnNewButton, "Busca concluída");

            }
        });
    }
    
    
    public void carregarDiretores(JComboBox diretorcomboBox) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	List<Diretor> diretores = diretorDAO.listarDiretores();
    	for(Diretor diretor : diretores) {
    		diretorcomboBox.addItem(diretor);
    		
    	}
    	
    }

    public static void main(String[] args) {
    	 FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new BuscarFilmeView().setVisible(true));
       
    }
}
