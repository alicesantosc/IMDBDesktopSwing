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
import model.Avaliacao;

public class AvaliacaoListagem extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5040546492883279716L;
	private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JTextField txtDigiteOId;

    public AvaliacaoListagem() {
        setTitle("Listagem de Avaliações");
        setSize(791, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Filme_ID");
        modeloTabela.addColumn("Usuario_ID");
        modeloTabela.addColumn("NOTA");
        modeloTabela.addColumn("COMENTARIO");

        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0, 51, 765, 377);
        getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel("Avaliações");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(123, 1, 389, 43);
        getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("<<");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AvaliacaoForm avaliacaoForm = new AvaliacaoForm();
                avaliacaoForm.setVisible(true);
            }
        });
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(24, 11, 49, 33);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Adicionar Avaliação");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AvaliacaoForm avaliacaoForm = new AvaliacaoForm();
                avaliacaoForm.setVisible(true);
            }
        });
        btnNewButton_2.setBounds(22, 455, 160, 23);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Deletar Avaliacao");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int avaliacaoId = Integer.parseInt(txtDigiteOId.getText());
                    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                    avaliacaoDAO.deletarAvaliacao(avaliacaoId);
                    JOptionPane.showMessageDialog(btnNewButton_3, "Avaliação deletada");

                    atualizarTabela();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(btnNewButton_3, "Digite um ID válido.");
                }
            }
        });
        btnNewButton_3.setBounds(209, 455, 146, 23);
        getContentPane().add(btnNewButton_3);

        txtDigiteOId = new JTextField();
        txtDigiteOId.setText("digite o id");
        txtDigiteOId.setBounds(365, 456, 86, 20);
        getContentPane().add(txtDigiteOId);
        txtDigiteOId.setColumns(10);

        carregarAvaliacoes();
    }

    private void carregarAvaliacoes() {
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
          // Limpa a tabela antes de carregar os dados
        for (Avaliacao avaliacao : avaliacaoDAO.listarAvaliacoes()) {
            modeloTabela.addRow(new Object[]{avaliacao.getId(), avaliacao.getfilmeId(), avaliacao.getusuarioId(), avaliacao.getNota(), avaliacao.getComentario()});
        }
    }

    private void atualizarTabela() {
        carregarAvaliacoes();
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new AvaliacaoListagem().setVisible(true));
    }
}

   