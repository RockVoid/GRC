package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.sistema.jdbc.DBConnection;
import br.com.sistema.model.DBTables;
import br.com.sistema.model.Funcionario;

public class FuncionarioDAO {
	private Connection conn;
	PreparedStatement pstm = null;
	
	public FuncionarioDAO() {
		this.conn = new DBConnection().createConnection();
	}
	
	public void save(Funcionario funcionario) {
		String sql = "INSERT INTO " + DBTables.FUNCIONARIOS.getTableName() + 
				"(nome, rg, cpf, email, telefone, celular, "
				+ "cep, endereco, numero, complemento, bairro, cidade, estado" 
				+ ", cargo, senha, nivel_acesso)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getRG());
			pstm.setString(3, funcionario.getCPF());
			pstm.setString(4, funcionario.getEmail());
			pstm.setString(5, funcionario.getTelefone());
			pstm.setString(6, funcionario.getCelular());
			pstm.setString(7, funcionario.getCEP());
			pstm.setString(8, funcionario.getEndereco());
			pstm.setInt(9, funcionario.getNumero());
			pstm.setString(10, funcionario.getComplemento());
			pstm.setString(11, funcionario.getBairro());
			pstm.setString(12, funcionario.getCidade());
			pstm.setString(13, funcionario.getEstado());
			pstm.setString(14, funcionario.getCargo());
			pstm.setString(15, funcionario.getSenha());
			pstm.setString(16, funcionario.getNivel_acesso());
			
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao criar cliente " + e.getMessage());
		}
	}
}
