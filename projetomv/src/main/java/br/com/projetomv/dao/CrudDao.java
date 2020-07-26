package br.com.projetomv.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetomv.infra.DatabaseManager;
import br.com.projetomv.model.Pessoa;

public class CrudDao {

	String pj;

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


	public List<Pessoa> relatorio() {

		Connection con = null;

		PreparedStatement st = null;

		ResultSet rs = null;

		List<Pessoa> listaRelatorio = new ArrayList<>();

		String sql1 = "SELECT * FROM cliente";

		try {

			con = DatabaseManager.getInstance().getConnection();
			st = con.prepareStatement(sql1);
			rs = st.executeQuery();

			while (rs.next()) {

				Pessoa p = new Pessoa();

				p.setPersonalId(rs.getString("personalid"));
				p.setNome(rs.getString("nome"));
				p.setTelefone(rs.getString("telefone"));
				p.setEmail(rs.getString("email"));
				p.setRg(rs.getString("rg"));
				p.setSexo(rs.getString("sexo"));
				listaRelatorio.add(p);
			}

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

		return listaRelatorio;

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



