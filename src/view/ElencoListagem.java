package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import com.formdev.flatlaf.FlatDarkLaf;
import dao.ElencoDAO;
import model.Elenco;

public class ElencoListagem extends JFrame {

    private static final long serialVersionUID = -81221107453986175L;
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    public ElencoListagem() {
        setTitle("Listagem de Elenco");
        setSize(791, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Certifique-se de que a aplicação fecha corretamente

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("filme_id");
        modeloTabela.addColumn("ator_id");
        modeloTabela.addColumn("papel");

        ElencoDAO elencoDAO = new ElencoDAO();

        for (Elenco elenco : elencoDAO.listarElenco()) {
            modeloTabela.addRow(new Object[]{elenco.getId(), elenco.getFilmeID(), elenco.getAtorID(), elenco.getPapel()});
        }

        getContentPane().setLayout(null);

        tabela = new JTable(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0, 51, 765, 377);
        getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel("Catálogo de Elenco");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(27, 11, 389, 43);
        getContentPane().add(lblNewLabel);
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new ElencoListagem().setVisible(true));
    }
}
