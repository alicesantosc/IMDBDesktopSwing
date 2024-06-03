package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.DiretorDAO;
import dao.FilmeDAO;
import dao.InicializarDB;
import model.Diretor;
import model.Filme;

public class FilmeForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -179557890643713538L;
	private JTextField tituloField;
    private JTextField anoField;
    private JTextField generoField;
    private JButton salvarButton;

    public FilmeForm() {
        setTitle("Adicionar Filme");
        setSize(882, 570);
        ///setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    @SuppressWarnings("rawtypes")
	public void initComponents() {
        tituloField = new JTextField(20);
        tituloField.setBackground(Color.BLACK);
        tituloField.setBounds(131, 110, 166, 20);
        anoField = new JTextField(4);
        anoField.setBackground(Color.BLACK);
        anoField.setBounds(131, 156, 166, 20);
        generoField = new JTextField(20);
        generoField.setBackground(Color.BLACK);
        generoField.setBounds(131, 209, 166, 20);
        salvarButton = new JButton("Salvar");
        salvarButton.setBounds(82, 351, 63, 23);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        
        @SuppressWarnings("JComboBox")
		JComboBox diretorcomboBox = new JComboBox();
        diretorcomboBox.setBackground(Color.BLACK);
        diretorcomboBox.setBounds(134, 275, 163, 22);
        diretorcomboBox.addItem("Selecione um diretor");
        ///metodo para carregar diretores
        carregarDiretores(diretorcomboBox);
        panel.add(diretorcomboBox);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Diretor diretorSelecionado = (Diretor) diretorcomboBox.getSelectedItem();
            	 if (diretorSelecionado == null) {
                     JOptionPane.showMessageDialog(FilmeForm.this, "Por favor, selecione um diretor.");
                     return;
                 }
            	
            	
                Filme filme = new Filme();
                filme.setTitulo(tituloField.getText());
                filme.setAno(Integer.parseInt(anoField.getText()));
                filme.setGenero(generoField.getText());
                filme.setDiretorId(diretorSelecionado.getId());
              
                new FilmeDAO().adicionarFilme(filme);
                JOptionPane.showMessageDialog(FilmeForm.this, "Filme adicionado com sucesso!");
            }
        });

       
        
        JButton btnNewButton = new JButton("Cadastrar Diretor");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DiretorForm diretorForm = new DiretorForm();
				diretorForm.setVisible(true);
        	}
        });
        
        JButton btnNewButton_1 = new JButton("Lista de Filmes");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FilmeListagem filmeListagem = new FilmeListagem();
				filmeListagem.setVisible(true);
        	}
        });
        btnNewButton_1.setBackground(Color.GRAY);
        btnNewButton_1.setBounds(163, 351, 185, 23);
        panel.add(btnNewButton_1);
        btnNewButton.setBounds(327, 275, 179, 23);
        panel.add(btnNewButton);
        
        
        
        JLabel lblNewLabel_3 = new JLabel("Cadastre um novo filme");
        lblNewLabel_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(54, 61, 349, 41);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Título");
        lblNewLabel_2.setBounds(54, 113, 46, 14);
        panel.add(lblNewLabel_2);
        panel.add(tituloField);
        JLabel label_1 = new JLabel("Ano:");
        label_1.setBounds(54, 159, 66, 14);
        panel.add(label_1);
        panel.add(anoField);
        JLabel label_2 = new JLabel("Gênero:");
        label_2.setBounds(54, 212, 66, 14);
        panel.add(label_2);
        panel.add(generoField);
        JLabel lblDiretor = new JLabel("Diretor:");
        lblDiretor.setBackground(Color.BLACK);
        lblDiretor.setBounds(54, 279, 79, 14);
        panel.add(lblDiretor);
        panel.add(salvarButton);

        getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(FilmeForm.class.getResource("/Imagem/assets-cached.jpg")));
        lblNewLabel_1.setBounds(0, -98, 576, 598);
        panel.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(450, 274, 2, 2);
        panel.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(FilmeForm.class.getResource("/Imagem/4691398_imdb_icon.png")));
        lblNewLabel.setBounds(439, -26, 562, 546);
        panel.add(lblNewLabel);
    }
    
    

    public void carregarDiretores(JComboBox diretorcomboBox) {
		// TODO Auto-generated method stub
    	DiretorDAO diretorDAO = new DiretorDAO();
    	List<Diretor> diretores = diretorDAO.listarDiretores();
    	 for (Diretor diretor : diretores) {
    		
    		 diretorcomboBox.addItem(diretor);
         }
	}

	public static void main(String[] args) {
    	FlatDarkLaf.setup();

    	InicializarDB.initialize();
    	SwingUtilities.invokeLater(() -> new FilmeForm().setVisible(true));
    }
}