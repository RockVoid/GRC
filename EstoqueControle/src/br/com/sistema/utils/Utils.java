package br.com.sistema.utils;

import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.sistema.dao.ClienteDAO;
import br.com.sistema.model.Cliente;

public class Utils {
	
	public void clearScreen(JPanel container) {
		Component components[] = container.getComponents();
		for(Component component : components) {
			if(component instanceof JTextField) {
				((JTextField)component).setText(null);;
			}
		}
	}
	
	public void searchClientsByName(JTextField label, JTable table) {
		String nome = "%" + label.getText() + "%";
		
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientesBuscados = clienteDAO.searchClients(nome);
		
		DefaultTableModel data = (DefaultTableModel) table.getModel();
		data.setNumRows(0);
		for(Cliente cliente : clientesBuscados) {
			data.addRow(new Object[] {
					cliente.getId(),
					cliente.getNome(),
					cliente.getEmail(),
					cliente.getCelular(),
					cliente.getTelefone(),
					cliente.getCEP(),
					cliente.getEndereco(),
					cliente.getNumero(),
					cliente.getCidade(),
					cliente.getBairro(),
					cliente.getComplemento(),
					cliente.getEstado(),
					cliente.getRG(),
					cliente.getCPF()
			});
		}
	}
}
