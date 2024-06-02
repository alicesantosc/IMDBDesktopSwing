package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import dao.DiretorDAO;
import dao.InicializarDB;
import model.Diretor;

public class DiretorForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 968908798817100637L;
	private JTextField nomeField;
    private JTextField dataField;
    private JButton salvarButton;
	

	public DiretorForm() {
		
		setTitle("Adicionar diretor");
        setSize(882, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
	}
	
	private void initComponents() {
        nomeField = new JTextField(20);
        nomeField.setBackground(Color.BLACK);
        nomeField.setBounds(131, 110, 166, 20);
        dataField = new JTextField(4);
        dataField.setBackground(Color.BLACK);
        dataField.setBounds(131, 156, 166, 20);
        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Diretor diretor = new Diretor();
        		diretor.setNome(nomeField.getText());
        		diretor.setData_nascimento(LocalDate.parse(dataField.getText()));
        		new DiretorDAO().adicionarDiretor(diretor);
        		JOptionPane.showMessageDialog(null, "Diretor adicionado com sucesso");
        		
        	}
        	
        });
        salvarButton.setBounds(82, 351, 63, 23);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JButton btnListarDiretores = new JButton("Visualizar");
        btnListarDiretores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new DiretorListagem().setVisible(true);
        		
        	}
        });
        btnListarDiretores.setBounds(175, 351, 89, 23);
        panel.add(btnListarDiretores);
        
        JLabel lblNewLabel_3 = new JLabel("Cadastre um novo diretor");
        lblNewLabel_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(54, 61, 349, 41);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Nome");
        lblNewLabel_2.setBounds(54, 113, 46, 14);
        panel.add(lblNewLabel_2);
        panel.add(nomeField);
        JLabel lblDataDe = new JLabel("Nascimento:");
        lblDataDe.setBounds(54, 159, 166, 14);
        panel.add(lblDataDe);
        panel.add(dataField);
        panel.add(salvarButton);

        getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(DiretorForm.class.getResource("/Imagem/assets-cached.jpg")));
        lblNewLabel_1.setBounds(0, -98, 576, 598);
        panel.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(450, 274, 2, 2);
        panel.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(DiretorForm.class.getResource("/Imagem/4691398_imdb_icon.png")));
        lblNewLabel.setBounds(439, -26, 562, 546);
        panel.add(lblNewLabel);
	

}
	
	public static void main(String[] args) {
    	FlatDarkLaf.setup();

    	InicializarDB.initialize();
    	SwingUtilities.invokeLater(() -> new DiretorForm().setVisible(true));
    }
}
