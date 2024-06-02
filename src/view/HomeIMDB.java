package view;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeIMDB extends JFrame {
	private JTextField textField;

    public HomeIMDB() {
        setTitle("IMDB Clone");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton btnHome = new JButton("Início");
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página inicial
                JOptionPane.showMessageDialog(HomeIMDB.this, "Início clicado");
            }
        });

        JButton btnFilmes = new JButton("Filmes");
        btnFilmes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página de filmes
                JOptionPane.showMessageDialog(HomeIMDB.this, "Filmes clicado");
            }
        });

        JButton btnDiretores = new JButton("Diretores");
        btnDiretores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página de diretores
                JOptionPane.showMessageDialog(HomeIMDB.this, "Diretores clicado");
            }
        });

        JButton btnAtores = new JButton("Atores");
        btnAtores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página de atores
                JOptionPane.showMessageDialog(HomeIMDB.this, "Atores clicado");
            }
        });

        JButton btnUsuarios = new JButton("Usuários");
        btnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página de usuários
                JOptionPane.showMessageDialog(HomeIMDB.this, "Usuários clicado");
            }
        });

        JButton btnAvaliacoes = new JButton("Avaliações");
        btnAvaliacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para navegar para a página de avaliações
                JOptionPane.showMessageDialog(HomeIMDB.this, "Avaliações clicado");
            }
        });

        toolBar.add(btnHome);
        toolBar.add(btnFilmes);
        toolBar.add(btnDiretores);
        toolBar.add(btnAtores);
        toolBar.add(btnUsuarios);
        toolBar.add(btnAvaliacoes);

        getContentPane().add(toolBar, BorderLayout.NORTH);
        
        JButton btnNewButton_1 = new JButton("Login/Cadastro");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		UsuarioForm usuarioForm = new UsuarioForm();
        		usuarioForm.setVisible(true);
        	}
        });
        btnNewButton_1.setForeground(Color.YELLOW);
        toolBar.add(btnNewButton_1);

        JPanel contentPane = new JPanel();
        // Aqui você pode adicionar os painéis de conteúdo para as diferentes seções
        getContentPane().add(contentPane, BorderLayout.CENTER);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(HomeIMDB.class.getResource("/Imagem/Captura de tela 2024-06-01 164554.png")));
        lblNewLabel.setBounds(10, -12, 69, 59);
        contentPane.add(lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(151, 6, 105, 22);
        contentPane.add(comboBox);
        
        JLabel lblNewLabel_1 = new JLabel("Filtrar Gênero");
        lblNewLabel_1.setBounds(78, 10, 98, 14);
        contentPane.add(lblNewLabel_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(3, 39, 781, 6);
        contentPane.add(separator);
        
        textField = new JTextField();
        textField.setBounds(364, 8, 121, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Pesquisar Filme");
        lblNewLabel_2.setBounds(271, 10, 170, 14);
        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("buscar");
        btnNewButton.setBounds(494, 5, 89, 23);
        contentPane.add(btnNewButton);
        
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.BLACK);
        desktopPane.setBounds(550, 39, 234, 499);
        contentPane.add(desktopPane);
        
        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.setBounds(75, 202, 89, 23);
        desktopPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_4 = new JLabel("MELHORES AVALIADOS");
        lblNewLabel_4.setBounds(68, 52, 221, 14);
        desktopPane.add(lblNewLabel_4);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(-18, 65, 252, 10);
        desktopPane.add(separator_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(75, 11, 140, 43);
        desktopPane.add(lblNewLabel_3);
        lblNewLabel_3.setIcon(new ImageIcon(HomeIMDB.class.getResource("/Imagem/Captura de tela 2024-06-01 180253.png")));
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(HomeIMDB.class.getResource("/Imagem/Captura de tela 2024-06-01 211052.png")));
        lblNewLabel_5.setBounds(10, 39, 204, 315);
        contentPane.add(lblNewLabel_5);
        
        JTextPane txtpnFromFilmmakerYorgos = new JTextPane();
        txtpnFromFilmmakerYorgos.setText("From filmmaker Yorgos Lanthimos and producer Emma Stone comes the incredible tale and fantastical evolution of Bella Baxter (Stone), a young woman brought back to life by the brilliant and unorthodox scientist Dr. Godwin Baxter (Willem Dafoe). Under Baxter's protection, Bella is eager to learn. Hungry for the worldliness she is lacking, Bella runs off with Duncan Wedderburn (Mark Ruffalo), a slick and debauched lawyer, on a whirlwind adventure across the continents. Free from the prejudices of her times, Bella grows steadfast in her purpose to stand for equality and liberation.");
        txtpnFromFilmmakerYorgos.setBounds(224, 133, 261, 221);
        contentPane.add(txtpnFromFilmmakerYorgos);
        
        JTextPane txtpnNotaMdia = new JTextPane();
        txtpnNotaMdia.setText("Nota média: 5 estrelas");
        txtpnNotaMdia.setBounds(224, 56, 261, 20);
        contentPane.add(txtpnNotaMdia);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(224, 120, 261, 2);
        contentPane.add(separator_2);
        
        JTextPane txtpnAvaliaes = new JTextPane();
        txtpnAvaliaes.setText("100 Avaliações");
        txtpnAvaliaes.setBounds(224, 89, 261, 20);
        contentPane.add(txtpnAvaliaes);
        
        JLabel lblNewLabel_6 = new JLabel("Comentários:");
        lblNewLabel_6.setBounds(10, 386, 166, 14);
        contentPane.add(lblNewLabel_6);
        
        JTextPane txtpnpoorThingsIsnt = new JTextPane();
        txtpnpoorThingsIsnt.setText("\"Poor things\" isn't for everybody. And when I say that I don t mean that if you don t like it, it went over your head and you should go back to watching Transfomers. No. It's a very very very specific type of weird, that won't be for everyone. Like Twin Peaks, or Everything everywhere all at once ( which I hated). It's like a fever dream on the strangest coqtail of psychedelics. If it happes to be your kind of weird, you will love it.");
        txtpnpoorThingsIsnt.setBounds(10, 407, 475, 120);
        contentPane.add(txtpnpoorThingsIsnt);
    }

    public static void main(String[] args) {
    	FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new HomeIMDB().setVisible(true));
    }
}
