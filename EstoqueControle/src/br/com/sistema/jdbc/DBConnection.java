package br.com.sistema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/sistemaestoque";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public Connection createConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error on Database connection " + e.getMessage());
		}
		return null;
	}
}
