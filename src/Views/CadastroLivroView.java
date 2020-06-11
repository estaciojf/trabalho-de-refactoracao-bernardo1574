package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.CadastroLivroController;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CadastroLivroView extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textAuthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivroView frame = new CadastroLivroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroLivroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(28, 76, 61, 16);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(28, 140, 61, 16);
		contentPane.add(lblAutor);
		
		JLabel lblGnero = new JLabel("Gênero");
		lblGnero.setBounds(266, 76, 61, 16);
		contentPane.add(lblGnero);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(266, 140, 61, 16);
		contentPane.add(lblAno);
		
		JCheckBox checkRead = new JCheckBox("Já leu?");
		checkRead.setBounds(28, 204, 128, 23);
		contentPane.add(checkRead);
		
		textTitle = new JTextField();
		textTitle.setBounds(78, 71, 130, 26);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(78, 135, 130, 26);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JComboBox comboGender = new JComboBox();
		comboGender.setBounds(321, 72, 106, 27);
		contentPane.add(comboGender);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setBounds(321, 136, 106, 27);
		contentPane.add(comboYear);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(270, 215, 117, 29);
		contentPane.add(btnCadastrar);
		
		
		CadastroLivroController handle = new CadastroLivroController(textTitle, textAuthor, comboGender, comboYear, checkRead);
		btnCadastrar.addActionListener(handle);
		
		
	}
}
