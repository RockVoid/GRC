package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.sistema.jdbc.DBConnection;
import br.com.sistema.model.Cliente;
import br.com.sistema.model.DBTables;

public class ClienteDAO {
	
	private Connection conn;
	PreparedStatement pstm = null;
	
	public ClienteDAO() {
		this.conn = new DBConnection().createConnection();
	}
	
	public void save(Cliente cliente) {
		String sql = "INSERT INTO " + DBTables.CLIENTES.getTableName() +  " (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)" + 
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getRG());
			pstm.setString(3, cliente.getCPF());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getTelefone());
			pstm.setString(6, cliente.getCelular());
			pstm.setString(7, cliente.getCEP());
			pstm.setString(8, cliente.getEndereco());
			pstm.setInt(9, cliente.getNumero());
			pstm.setString(10, cliente.getComplemento());
			pstm.setString(11, cliente.getBairro());
			pstm.setString(12, cliente.getCidade());
			pstm.setString(13, cliente.getEstado());
			
			pstm.execute();
			
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Client saved with success!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error on Save Cliente " + e.getMessage());
		}
	}
	
	public Cliente search(String nome) {
		
		String sql = "SELECT * FROM " + DBTables.CLIENTES.getTableName() + " WHERE nome = ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			Cliente cliente = new Cliente();
			
			if(rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setRG(rs.getString("rg"));
				cliente.setCEP(rs.getString("cep"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
			}
			
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
		}
		return null;
	}

	public List<Cliente> listClients() {
		String sql = "SELECT * FROM " + DBTables.CLIENTES.getTableName();
		
		List<Cliente> clientes = new ArrayList<>();

		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setRG(rs.getString("rg"));
				cliente.setCEP(rs.getString("cep"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao criar lista de clientes: " + e.getMessage());
		}
		return null;
	}
	
	public List<Cliente> searchClients(String nome) {
		
		String sql = "SELECT * FROM " + DBTables.CLIENTES.getTableName() + " WHERE nome LIKE ?";
		
		List<Cliente> clientes = new ArrayList<>();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nome);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setRG(rs.getString("rg"));
				cliente.setCEP(rs.getString("cep"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + e.getMessage());
		}
		return null;
	}

	public void delete(Cliente cliente) {
		
		String sql = "DELETE FROM " + DBTables.CLIENTES.getTableName() + " WHERE id = ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.execute();
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao deletar cliente!");
		}
	}
}




