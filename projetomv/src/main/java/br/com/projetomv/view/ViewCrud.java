package br.com.projetomv.view;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.projetomv.dao.CrudDao;
import br.com.projetomv.infra.DatabaseManager;
import br.com.projetomv.model.Pessoa;
import net.proteanit.sql.DbUtils;

public class ViewCrud {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ViewCrud window = new ViewCrud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Create the application.
	 */
	public ViewCrud() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 568, 394);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa pe = new Pessoa();
				CrudDao dao = new CrudDao();
				pe.setPersonalId(ViewCrud.this.textField.getText());
				pe.setNome(ViewCrud.this.textField_1.getText());
				pe.setTelefone(ViewCrud.this.textField_2.getText());

				pe.setEmail(ViewCrud.this.textField_3.getText());
				pe.setRg(ViewCrud.this.textField_4.getText());
				pe.setSexo(ViewCrud.this.textField_5.getText());
				dao.addPessoa(pe);

			}
		});
		btnNewButton.setBounds(24, 169, 97, 25);
		this.frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa pe = new Pessoa();
				CrudDao dao = new CrudDao();

				pe.setPersonalId(ViewCrud.this.textField.getText());
				pe.setNome(ViewCrud.this.textField_1.getText());
				pe.setTelefone(ViewCrud.this.textField_2.getText());
				pe.setEmail(ViewCrud.this.textField_3.getText());
				pe.setRg(ViewCrud.this.textField_4.getText());
				pe.setSexo(ViewCrud.this.textField_5.getText());
				dao.updPessoa(pe);


			}
		});
		btnNewButton_1.setBounds(171, 169, 97, 25);
		this.frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa pe = new Pessoa();
				CrudDao dao = new CrudDao();

				pe.setPersonalId(ViewCrud.this.textField.getText());
				dao.excPessoa(pe);

			}
		});
		btnNewButton_2.setBounds(299, 169, 97, 25);
		this.frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Relatorio");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				String sql1 = "SELECT * FROM cliente";

				try {
					con = DatabaseManager.getInstance().getConnection();
					st = con.prepareStatement(sql1);

					rs = st.executeQuery();

					ViewCrud.this.table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception b) {
					b.printStackTrace();
				}finally {
					try {
						st.close();
					} catch (SQLException b) {
						b.printStackTrace();
					}
					try {
						rs.close();
					} catch (SQLException b) {
						b.printStackTrace();
					}
					try {
						con.close();
					} catch (SQLException b) {
						b.printStackTrace();
					}
				}
			}
		});
		btnNewButton_3.setBounds(413, 169, 97, 25);
		this.frame.getContentPane().add(btnNewButton_3);

		this.textField = new JTextField();
		this.textField.setBounds(84, 30, 116, 22);
		this.frame.getContentPane().add(this.textField);
		this.textField.setColumns(10);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(84, 65, 116, 22);
		this.frame.getContentPane().add(this.textField_1);
		this.textField_1.setColumns(10);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(84, 100, 116, 22);
		this.frame.getContentPane().add(this.textField_2);
		this.textField_2.setColumns(10);

		this.textField_3 = new JTextField();
		this.textField_3.setBounds(280, 30, 116, 22);
		this.frame.getContentPane().add(this.textField_3);
		this.textField_3.setColumns(10);

		this.textField_4 = new JTextField();
		this.textField_4.setBounds(280, 65, 116, 22);
		this.frame.getContentPane().add(this.textField_4);
		this.textField_4.setColumns(10);

		this.textField_5 = new JTextField();
		this.textField_5.setBounds(280, 100, 116, 22);
		this.frame.getContentPane().add(this.textField_5);
		this.textField_5.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpj/Cnpj");
		lblNewLabel.setBounds(12, 33, 56, 16);
		this.frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(12, 68, 56, 16);
		this.frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(12, 103, 56, 16);
		this.frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("e-mail");
		lblNewLabel_3.setBounds(212, 33, 56, 16);
		this.frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("RG");
		lblNewLabel_4.setBounds(212, 68, 56, 16);
		this.frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setBounds(212, 103, 56, 16);
		this.frame.getContentPane().add(lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 207, 483, 127);
		this.frame.getContentPane().add(scrollPane);

		this.table = new JTable();
		scrollPane.setViewportView(this.table);

		Checkbox checkbox = new Checkbox("Pesso Juridica");
		checkbox.setBounds(13, 139, 108, 24);
		this.frame.getContentPane().add(checkbox);
	}
}
