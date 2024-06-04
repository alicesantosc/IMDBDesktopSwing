package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.AtorDAO;
import dao.ElencoDAO;
import dao.FilmeDAO;
import model.Ator;
import model.Elenco;
import model.Filme;

public class ElencoForm extends JFrame {

    private JComboBox<String> atorComboBox;
    private JComboBox<String> filmeComboBox;
    
    private JTextField papelField;
    private JButton adicionarButton;
    private ElencoDAO elencoDAO;

    public ElencoForm() {
        setTitle("Adicionar Elenco");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblFilmeId = new JLabel("Filme ID:");
        lblFilmeId.setBounds(10, 10, 80, 25);
        getContentPane().add(lblFilmeId);

        filmeComboBox = new JComboBox<>();
        filmeComboBox.setBounds(100, 10, 160, 25);
        getContentPane().add(filmeComboBox);

        JLabel lblAtor = new JLabel("Ator:");
        lblAtor.setBounds(10, 50, 80, 25);
        getContentPane().add(lblAtor);

        atorComboBox = new JComboBox<>();
        atorComboBox.setBounds(100, 50, 160, 25);
        getContentPane().add(atorComboBox);

        JLabel lblPapel = new JLabel("Papel:");
        lblPapel.setBounds(10, 90, 80, 25);
        getContentPane().add(lblPapel);

        papelField = new JTextField();
        papelField.setBounds(100, 90, 160, 25);
        getContentPane().add(papelField);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(100, 130, 160, 25);
        getContentPane().add(adicionarButton);

        elencoDAO = new ElencoDAO();
        carregarAtores();
        carregarFilmes();

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarElenco();
            }
        });
    }
    
    private void carregarFilmes() {
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filme> filmes = filmeDAO.listarFilmes();
        for (Filme filme : filmes) {
            System.out.println("Carregando filme: " + filme.getTitulo());
            filmeComboBox.addItem(filme.getTitulo());  // Corrigido de atorComboBox para filmeComboBox
        }
    }


    private void carregarAtores() {
        AtorDAO atorDAO = new AtorDAO();
        List<Ator> atores = atorDAO.listarAtores();

        for (Ator ator : atores) {
            atorComboBox.addItem(ator.getNome());
        }
    }

    private void adicionarElenco() {
        String filmeTitulo = (String) filmeComboBox.getSelectedItem();
        String atorNome = (String) atorComboBox.getSelectedItem();
        String papel = papelField.getText();

        System.out.println("Filme Titulo: " + filmeTitulo);
        System.out.println("Ator Nome: " + atorNome);

        AtorDAO atorDAO = new AtorDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        int atorId = atorDAO.buscarIdPorNome(atorNome);
        int filmeId = filmeDAO.buscarIdporTituloFilme(filmeTitulo);

        System.out.println("Ator ID: " + atorId);
        System.out.println("Filme ID: " + filmeId);

        if (atorId != -1 && filmeId != -1) {
            Elenco elenco = new Elenco();
            elenco.setFilmeID(filmeId);
            elenco.setAtorID(atorId);
            elenco.setPapel(papel);

            elencoDAO.adicionarElenco(elenco);
            JOptionPane.showMessageDialog(this, "Elenco adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Filme ou Ator não encontrado.");
        }
    }


    public static void main(String[] args) {
    	FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new ElencoForm().setVisible(true));
    }
}

