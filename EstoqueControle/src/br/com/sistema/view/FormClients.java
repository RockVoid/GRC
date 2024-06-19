package br.com.sistema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.sistema.dao.ClienteDAO;
import br.com.sistema.model.Cliente;
import br.com.sistema.utils.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class FormClients extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField codeTextField;
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JFormattedTextField phoneNumberTextField;
	private JFormattedTextField telephoneNumberTextField;
	private JFormattedTextField CEPTextField;
	private MaskFormatter CEP;
	private MaskFormatter phoneNumberBR;
	private MaskFormatter telephoneNumberBR;
	private MaskFormatter CPF;
	private JTextField numeroTextField;
	private JTextField enderecoTextField;
	private JTextField bairroTextField;
	private JTextField cidadeTextField;
	private JTextField complementoTextField;
	private JTextField CPFTextField;
	private JTextField labelNomeConsultaClientes;
	private JTextField RGTextField;
	private JTable tableCadastroClientes;
	private String[] colsTableConsulta = {
			"Nome", 
			"Telefone", 
			"Email", 
			"CPF", 
			"CEP", 
			"Endereço"
	};

	private String[] estadosBR= {
			"AC",
			"AL",
			"AP",
			"AM",
			"BA",
			"CE",
			"DF",
			"ES",
			"GO",
			"MA",
			"MT",
			"MS",
			"MG",
			"PA",
			"PB",
			"PR",
			"PE",
			"PI",
			"RJ",
			"RN",
			"RS",
			"RO",
			"RR",
			"SC",
			"SP",
			"SE",
			"TO"
	};
	private JComboBox estadosComboBox = new JComboBox(estadosBR);
	Utils util = new Utils();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormClients frame = new FormClients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillClientTable() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.listClients();
		
		DefaultTableModel data = (DefaultTableModel) tableCadastroClientes.getModel();
		data.setNumRows(0);
		
		for (Cliente cliente : lista) {
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
	
	public void getClientByName() {
		String name = nomeTextField.getText();
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		cliente = clienteDao.search(name);
		
		if(cliente.getNome() != null) {
			codeTextField.setText(String.valueOf(cliente.getId()));
			nomeTextField.setText(cliente.getNome());
			RGTextField.setText(cliente.getRG());
			CPFTextField.setText(cliente.getCPF());
			emailTextField.setText(cliente.getEmail());
			telephoneNumberTextField.setText(cliente.getTelefone());
			phoneNumberTextField.setText(cliente.getCelular());
			CEPTextField.setText(cliente.getCEP());
			enderecoTextField.setText(cliente.getEndereco());
			numeroTextField.setText(String.valueOf(cliente.getNumero()));
			complementoTextField.setText(cliente.getComplemento());
			bairroTextField.setText(cliente.getBairro());
			cidadeTextField.setText(cliente.getCidade());
			estadosComboBox.setSelectedItem(cliente.getEstado());
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
		}
	}
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FormClients() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 589);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 915, 125);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE CLIENTES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(237, 41, 437, 41);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		tabbedPane.setBounds(0, 131, 915, 280);
		getContentPane().add(tabbedPane);
		
		JPanel dados_pessoais_panel = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, dados_pessoais_panel, null);
		tabbedPane.setEnabledAt(0, true);
		dados_pessoais_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CÓDIGO: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 62, 13);
		dados_pessoais_panel.add(lblNewLabel_1);
		
		codeTextField = new JTextField();
		codeTextField.setEditable(false);
		lblNewLabel_1.setLabelFor(codeTextField);
		codeTextField.setBounds(82, 8, 96, 19);
		dados_pessoais_panel.add(codeTextField);
		codeTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NOME: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 40, 45, 13);
		dados_pessoais_panel.add(lblNewLabel_2);
		
		nomeTextField = new JTextField();
		nomeTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					getClientByName();
				}
			}
		});
		lblNewLabel_2.setLabelFor(nomeTextField);
		nomeTextField.setBounds(82, 37, 200, 19);
		dados_pessoais_panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getClientByName();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(296, 37, 105, 21);
		dados_pessoais_panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("TELEFONE:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(306, 69, 72, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(82, 69, 200, 19);
		dados_pessoais_panel.add(emailTextField);
		
		phoneNumberBR = new MaskFormatter("(##) 9####-####");
		phoneNumberTextField = new JFormattedTextField(phoneNumberBR);
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(700,69,181, 19);
		dados_pessoais_panel.add(phoneNumberTextField);

		telephoneNumberBR = new MaskFormatter("(##) ####-####");
		telephoneNumberTextField = new JFormattedTextField(telephoneNumberBR);
		lblNewLabel_2_1.setLabelFor(telephoneNumberTextField);
		telephoneNumberTextField.setColumns(10);
		telephoneNumberTextField.setBounds(388,69,200, 19);
		dados_pessoais_panel.add(telephoneNumberTextField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("EMAIL:");
		lblNewLabel_2_1_1.setLabelFor(emailTextField);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 69, 45, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("CELULAR:");
		lblNewLabel_2_1_2.setLabelFor(phoneNumberTextField);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_2.setBounds(618, 69, 72, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_2);
		
		CEP = new MaskFormatter("#####-###");
		CEPTextField = new JFormattedTextField(CEP);
		CEPTextField.setColumns(10);
		CEPTextField.setBounds(82,108,200, 19);
		dados_pessoais_panel.add(CEPTextField);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1.setLabelFor(CEPTextField);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 108, 45, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1);
		
		numeroTextField = new JTextField();
		numeroTextField.setColumns(10);
		numeroTextField.setBounds(700, 108, 51, 19);
		dados_pessoais_panel.add(numeroTextField);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("ENDEREÇO:");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_3.setBounds(306, 111, 72, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_3);
		
		enderecoTextField = new JTextField();
		lblNewLabel_2_1_3.setLabelFor(enderecoTextField);
		enderecoTextField.setColumns(10);
		enderecoTextField.setBounds(388, 108, 200, 19);
		dados_pessoais_panel.add(enderecoTextField);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("NÚMERO:");
		lblNewLabel_2_1_2_1.setLabelFor(numeroTextField);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_2_1.setBounds(618, 111, 72, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("BAIRRO:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1.setBounds(10, 158, 62, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1_1);
		
		bairroTextField = new JTextField();
		lblNewLabel_2_1_1_1_1.setLabelFor(bairroTextField);
		bairroTextField.setColumns(10);
		bairroTextField.setBounds(82, 158, 200, 19);
		dados_pessoais_panel.add(bairroTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("CIDADE:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1_1.setBounds(306, 158, 62, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1_1_1);
		
		cidadeTextField = new JTextField();
		lblNewLabel_2_1_1_1_1_1.setLabelFor(cidadeTextField);
		cidadeTextField.setColumns(10);
		cidadeTextField.setBounds(388, 158, 200, 19);
		dados_pessoais_panel.add(cidadeTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("COMPLEMENTO:");
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1_2.setBounds(618, 158, 119, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1_1_2);
		
		complementoTextField = new JTextField();
		lblNewLabel_2_1_1_1_1_2.setLabelFor(complementoTextField);
		complementoTextField.setColumns(10);
		complementoTextField.setBounds(749, 158, 132, 19);
		dados_pessoais_panel.add(complementoTextField);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("ESTADO:");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_2_1_1.setBounds(767, 111, 72, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_2_1_1);
		estadosComboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		estadosComboBox.setBounds(835, 107, 46, 21);
		dados_pessoais_panel.add(estadosComboBox);
		
		JLabel lblNewLabel_2_1_1_1_1_3 = new JLabel("CPF");
		lblNewLabel_2_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1_3.setBounds(10, 209, 62, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1_1_3);
		
		CPF = new MaskFormatter("###.###.###-##");
		CPFTextField = new JFormattedTextField(CPF);
		lblNewLabel_2_1_1_1_1_3.setLabelFor(CPFTextField);
		CPFTextField.setColumns(10);
		CPFTextField.setBounds(82, 210, 200, 19);
		dados_pessoais_panel.add(CPFTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel("RG:");
		lblNewLabel_2_1_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1_3_1.setBounds(306, 209, 62, 16);
		dados_pessoais_panel.add(lblNewLabel_2_1_1_1_1_3_1);
		
		RGTextField = new JTextField();
		RGTextField.setColumns(10);
		RGTextField.setBounds(388, 209, 200, 19);
		dados_pessoais_panel.add(RGTextField);
		
		JPanel consulta_clientes_panel = new JPanel();
		tabbedPane.addTab("Consulta de clientes", null, consulta_clientes_panel, null);
		consulta_clientes_panel.setLayout(null);
		
		JLabel nomeLabelConsulta = new JLabel("NOME: ");
		nomeLabelConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomeLabelConsulta.setBounds(10, 13, 45, 13);
		consulta_clientes_panel.add(nomeLabelConsulta);
		
		labelNomeConsultaClientes = new JTextField();
		labelNomeConsultaClientes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				util.searchClientsByName(labelNomeConsultaClientes, tableCadastroClientes);
			}
		});
		nomeLabelConsulta.setLabelFor(labelNomeConsultaClientes);
		labelNomeConsultaClientes.setColumns(10);
		labelNomeConsultaClientes.setBounds(82, 10, 200, 19);
		consulta_clientes_panel.add(labelNomeConsultaClientes);
		
		JButton btnNewButton_1 = new JButton("PESQUISAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				util.searchClientsByName(labelNomeConsultaClientes, tableCadastroClientes);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(296, 10, 115, 21);
		consulta_clientes_panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 890, 185);
		consulta_clientes_panel.add(scrollPane);
		
		tableCadastroClientes = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Email", "Celular", "Telefone", "CEP", "Endere\u00E7o", "Numero", "Cidade", "Bairro", "Complemento", "UF", "RG", "CPF"
			}
		));
		tableCadastroClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
				codeTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 0).toString());
				nomeTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 1).toString());
				emailTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 2).toString());
				phoneNumberTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 3).toString());
				telephoneNumberTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 4).toString());
				CEPTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 5).toString());
				enderecoTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 6).toString());
				numeroTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 7).toString());
				cidadeTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 8).toString());
				bairroTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 9).toString());
				complementoTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 10).toString());
				estadosComboBox.setSelectedItem(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 11).toString());
				RGTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 12).toString());
				CPFTextField.setText(tableCadastroClientes.getValueAt(tableCadastroClientes.getSelectedRow(), 13).toString());
			}
		});
		scrollPane.setViewportView(tableCadastroClientes);
		tableCadastroClientes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setEnabledAt(1, true);
		fillClientTable();
		
		JButton novoClienteBTN = new JButton("NOVO CLIENTE");
		novoClienteBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		novoClienteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				util.clearScreen(dados_pessoais_panel);
			}
		});
		novoClienteBTN.setIcon(new ImageIcon(FormClients.class.getResource("/br/com/sistema/imagens/novo.png")));
		novoClienteBTN.setBounds(40, 458, 140, 34);
		getContentPane().add(novoClienteBTN);
		
		JButton salvarClienteBTN = new JButton("SALVAR CLIENTE");
		salvarClienteBTN.setIcon(new ImageIcon(FormClients.class.getResource("/br/com/sistema/imagens/salvar.png")));
		salvarClienteBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		salvarClienteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(nomeTextField.getText());
				cliente.setRG(RGTextField.getText());
				cliente.setCPF(CPFTextField.getText());
				cliente.setEmail(emailTextField.getText());
				cliente.setTelefone(telephoneNumberTextField.getText());
				cliente.setCelular(phoneNumberTextField.getText());
				cliente.setCEP(CEPTextField.getText());
				cliente.setEndereco(enderecoTextField.getText());
				cliente.setNumero(Integer.valueOf(numeroTextField.getText()));
				cliente.setComplemento(complementoTextField.getText());
				cliente.setBairro(bairroTextField.getText());
				cliente.setCidade(cidadeTextField.getText());
				cliente.setEstado(estadosComboBox.getSelectedItem().toString());
				
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.save(cliente);
				util.clearScreen(dados_pessoais_panel);
			}
		});
		salvarClienteBTN.setBounds(203, 458, 140, 34);
		getContentPane().add(salvarClienteBTN);
		
		JButton editarClienteBTN = new JButton("EDITAR CLIENTE");
		editarClienteBTN.setIcon(new ImageIcon(FormClients.class.getResource("/br/com/sistema/imagens/editar.png")));
		editarClienteBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		editarClienteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editarClienteBTN.setBounds(365, 458, 140, 34);
		getContentPane().add(editarClienteBTN);
		
		JButton excluirClienteBTN = new JButton("EXCLUIR CLIENTE");
		excluirClienteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteDAO clienteDAO = new ClienteDAO();
				
				Cliente cliente = new Cliente();
				cliente.setId(Integer.valueOf(codeTextField.getText()));
				clienteDAO.delete(cliente);
				util.clearScreen(dados_pessoais_panel);
			}
		});
		excluirClienteBTN.setIcon(new ImageIcon(FormClients.class.getResource("/br/com/sistema/imagens/excluir.png")));
		excluirClienteBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		excluirClienteBTN.setBounds(527, 458, 140, 34);
		getContentPane().add(excluirClienteBTN);
		
		JButton imprimirBTN = new JButton("IMPRIMIR");
		imprimirBTN.setIcon(new ImageIcon(FormClients.class.getResource("/br/com/sistema/imagens/printer.png")));
		imprimirBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		imprimirBTN.setBounds(690, 458, 140, 34);
		getContentPane().add(imprimirBTN);
	}
}
