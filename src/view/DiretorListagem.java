package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.DiretorDAO;
import model.Diretor;

public class DiretorListagem extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9190246542548438540L;
	private DefaultTableModel modeloTabela;
	private JTable tabela;
	
	public DiretorListagem() {
		setTitle("Listagem de Diretores");
		setSize(791,550);
		///setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Data de Nascimento");
		
		
		///agora conectando com a DB
		
		DiretorDAO diretorDAO = new DiretorDAO();
		for(Diretor diretor : diretorDAO.listarDiretores()) {
			modeloTabela.addRow(new Object[] {diretor.getId(), diretor.getNome(),diretor.getData_nascimento()});
		}
		
		getContentPane().setLayout(null);

        // Cria a tabela e define o modelo de tabela
        tabela = new JTable(modeloTabela);

        // Adiciona a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0, 51, 765, 377);
        getContentPane().add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Catálogo de Diretores");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(27, 11, 389, 43);
        getContentPane().add(lblNewLabel);
    }

    public static void main(String[] args) {
    	FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new DiretorListagem().setVisible(true));
    }
	}


