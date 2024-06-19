package br.com.sistema.jdbc;

import javax.swing.JOptionPane;

public class TestConnection {
	public static void main (String[] args) {
		try {
			new DBConnection().createConnection();
			JOptionPane.showMessageDialog(null, "Connected to DB with success!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
