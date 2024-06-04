package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.AvaliacaoDAO;
import model.MediaFilme;

public class RelatorioAvaliacaoMedia extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1447518383406111926L;
	private JTable tabela;
    private DefaultTableModel modeloTabela;

    public RelatorioAvaliacaoMedia() {
        setTitle("Relatório de Avaliação Média por Filme");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Filme");
        modeloTabela.addColumn("Média");

        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        carregarRelatorio();

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
    }

    private void carregarRelatorio() {
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        List<MediaFilme> mediaAvaliacoes = avaliacaoDAO.calcularMediaAvaliacoesFilme();

        for (MediaFilme filmeMedia : mediaAvaliacoes) {
            modeloTabela.addRow(new Object[]{filmeMedia.getTitulo(), filmeMedia.getMedia()});
        }
    }

    public static void main(String[] args) {
    	FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new RelatorioAvaliacaoMedia().setVisible(true));
    }
}
