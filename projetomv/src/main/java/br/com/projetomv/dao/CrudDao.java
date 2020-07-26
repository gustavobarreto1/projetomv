package br.com.projetomv.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projetomv.infra.DatabaseManager;
import br.com.projetomv.model.Pessoa;

public class CrudDao {

	String personalId;
	String nome;
	String telefone;
	boolean tipoPessoa;
	String cep;
	String rua;
	String numero;
	String banco;
	Date dataConta;
	double valor;

	public void addPessoa(Pessoa p) {

		Connection con = null;
		PreparedStatement st = null;

		String sql1 = "INSERT INTO cliente(personalid,nome,telefone,email,rg,sexo) VALUES(?,?,?,?,?,?)";

		try {

			con = DatabaseManager.getInstance().getConnection();
			st = con.prepareStatement(sql1);
			st.setString(1, p.getPersonalId());
			st.setString(2, p.getNome());
			st.setString(3, p.getTelefone());
			st.setString(4, p.getEmail());
			st.setString(5, p.getRg());
			st.setString(6, p.getSexo());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void excPessoa(Pessoa p) {

		Connection con = null;
		PreparedStatement st = null;

		String sql1 = "DELETE FROM cliente WHERE personalid = ?";

		try {

			con = DatabaseManager.getInstance().getConnection();
			st = con.prepareStatement(sql1);
			st.setString(1, p.getPersonalId());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public void updPessoa(Pessoa p) {

		Connection con = null;
		PreparedStatement st = null;

		String sql1 = "UPDATE cliente set personalid = ?, nome = ?, telefone = ?, email = ?, rg = ?, sexo = ?"
				+ " WHERE personalid = ?";

		try {

			con = DatabaseManager.getInstance().getConnection();
			st = con.prepareStatement(sql1);
			st.setString(1, p.getPersonalId());
			st.setString(2, p.getNome());
			st.setString(3, p.getTelefone());
			st.setString(4, p.getEmail());
			st.setString(5, p.getRg());
			st.setString(6, p.getSexo());
			st.setString(7, p.getPersonalId());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}



