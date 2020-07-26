package br.com.projetomv.infra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

	public static final String DRIVER = "database.driver";
	public static final String USUARIO = "database.username";
	public static final String SENHA = "database.password";
	public static final String URL = "database.url";

	private static DatabaseManager db;

	public static DatabaseManager getInstance() throws Exception{
		if(db == null) {
			db = new DatabaseManager();
		}
		return db;
	}

	private Properties props = new Properties();

	public DatabaseManager() throws Exception {
		this.init();
	}

	public Connection getConnection() throws Exception {

		Connection conn = null;
		try {
			Properties connectionProps = new Properties();
			connectionProps.put("user", this.props.getProperty(USUARIO));
			connectionProps.put("password", this.props.getProperty(SENHA));
			conn = DriverManager.getConnection(this.props.getProperty(URL), connectionProps);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Não foi possível abrir uma conexão com o banco de dados! Favor verificar os parâmetros!");
		}
		return conn;
	}

	private void init() throws Exception {
		this.loadProperties();
		this.loadDriver();
	}

	private void loadDriver() throws Exception {
		try {
			Class.forName(this.props.getProperty(DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Problema no carregamento do driver \"" + this.props.getProperty(DRIVER) + "\":  " + e.getMessage());
		}
	}

	private void loadProperties() throws Exception {
		this.props = new Properties();
		InputStream input = null;
		try {
			this.props = new Properties();
			input = this.getClass().getResourceAsStream("/database.properties");
			this.props.load(input);
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo \"resources/database.properties\" não encontrado!");
		} catch (IOException e) {
			throw e;
		}finally {
			if(input != null) {
				input.close();
			}
		}
	}

}
