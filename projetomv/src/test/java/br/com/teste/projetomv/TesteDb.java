package br.com.teste.projetomv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetomv.infra.DatabaseManager;

public class TesteDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement prepare = null;
		ResultSet result = null;
		Connection con = null;
		try {
			con = DatabaseManager.getInstance().getConnection();
			prepare = con.prepareStatement("select * from cliente");
			prepare.execute();
			result = prepare.getResultSet();
			while(result.next()) {
				System.out.println(result.getString("nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepare != null) {
					prepare.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(result != null) {
					result.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
