package br.com.sistema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.sistema.dao.FuncionarioDAO;
import br.com.sistema.model.Funcionario;
import br.com.sistema.utils.Utils;

import javax.swing.border.TitledBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class FormEmployess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoFuncionarioTextField;
	private JTextField nomeFuncionarioTextField;
	private JTextField emailFuncionarioTextField;
	private JTextField numeroFuncionarioTextField;
	private JTextField enderecoFuncionarioTextField;
	private JTextField bairroFuncionarioTextField;
	private JTextField cidadeFuncionarioTextField;
	private JTextField complementoTextField;
	private JTextField RGFuncionarioTextField;
	private JTextField nomeCFtextField;
	private JTextField senhaFuncionarioTextField;
	private JTable tableCadastroFuncionarios;

	Utils util = new Utils();
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEmployess frame = new FormEmployess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormEmployess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 915, 112);
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		
		JLabel formEmployeesHeader = new JLabel("CADASTRO DE FUNCIONÁRIOS");
		formEmployeesHeader.setHorizontalAlignment(SwingConstants.CENTER);
		formEmployeesHeader.setForeground(Color.WHITE);
		formEmployeesHeader.setFont(new Font("Tahoma", Font.BOLD, 34));
		formEmployeesHeader.setBounds(178, 39, 543, 41);
		panel.add(formEmployeesHeader);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 112, 915, 291);
		contentPane.add(tabbedPane);
		
		JPanel dados_pessoais_funcionarios_panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, dados_pessoais_funcionarios_panel, null);
		dados_pessoais_funcionarios_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CÓDIGO: ");
		lblNewLabel_1.setBounds(10, 10, 62, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_1);
		
		codigoFuncionarioTextField = new JTextField();
		lblNewLabel_1.setLabelFor(codigoFuncionarioTextField);
		codigoFuncionarioTextField.setBounds(82, 8, 96, 19);
		codigoFuncionarioTextField.setEditable(false);
		codigoFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(codigoFuncionarioTextField);
		
		JLabel lblNewLabel_2 = new JLabel("NOME: ");
		lblNewLabel_2.setBounds(10, 40, 45, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2);
		
		nomeFuncionarioTextField = new JTextField();
		lblNewLabel_2.setLabelFor(nomeFuncionarioTextField);
		nomeFuncionarioTextField.setBounds(82, 37, 200, 19);
		nomeFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(nomeFuncionarioTextField);
		
		JButton btnPesquisarFuncionario = new JButton("PESQUISAR");
		btnPesquisarFuncionario.setBounds(296, 37, 105, 21);
		btnPesquisarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(btnPesquisarFuncionario);
		
		JLabel lblNewLabel_2_1 = new JLabel("TELEFONE:");
		lblNewLabel_2_1.setBounds(306, 69, 72, 16);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1);
		
		emailFuncionarioTextField = new JTextField();
		emailFuncionarioTextField.setBounds(82, 69, 200, 19);
		emailFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(emailFuncionarioTextField);
		
		JFormattedTextField phoneNumbeFuncionariorTextField = new JFormattedTextField();
		phoneNumbeFuncionariorTextField.setText("(  ) 9    -    ");
		phoneNumbeFuncionariorTextField.setBounds(700, 69, 181, 19);
		phoneNumbeFuncionariorTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(phoneNumbeFuncionariorTextField);
		
		JFormattedTextField telephoneNumberFuncionarioTextField = new JFormattedTextField();
		telephoneNumberFuncionarioTextField.setText("(  )     -    ");
		lblNewLabel_2_1.setLabelFor(telephoneNumberFuncionarioTextField);
		telephoneNumberFuncionarioTextField.setBounds(388, 69, 200, 19);
		telephoneNumberFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(telephoneNumberFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("EMAIL:");
		lblNewLabel_2_1_1.setLabelFor(emailFuncionarioTextField);
		lblNewLabel_2_1_1.setBounds(10, 69, 45, 16);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("CELULAR:");
		lblNewLabel_2_1_2.setLabelFor(phoneNumbeFuncionariorTextField);
		lblNewLabel_2_1_2.setBounds(618, 69, 72, 16);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_2);
		
		JFormattedTextField CEPFuncionarioTextField = new JFormattedTextField();
		CEPFuncionarioTextField.setText("     -   ");
		CEPFuncionarioTextField.setBounds(82, 108, 200, 19);
		CEPFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(CEPFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CEP:");
		lblNewLabel_2_1_1_1.setLabelFor(CEPFuncionarioTextField);
		lblNewLabel_2_1_1_1.setBounds(10, 108, 45, 16);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1);
		
		numeroFuncionarioTextField = new JTextField();
		numeroFuncionarioTextField.setBounds(700, 108, 51, 19);
		numeroFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(numeroFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("ENDEREÇO:");
		lblNewLabel_2_1_3.setBounds(306, 111, 72, 16);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_3);
		
		enderecoFuncionarioTextField = new JTextField();
		lblNewLabel_2_1_3.setLabelFor(enderecoFuncionarioTextField);
		enderecoFuncionarioTextField.setBounds(388, 108, 200, 19);
		enderecoFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(enderecoFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("NÚMERO:");
		lblNewLabel_2_1_2_1.setLabelFor(numeroFuncionarioTextField);
		lblNewLabel_2_1_2_1.setBounds(618, 111, 72, 16);
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("BAIRRO:");
		lblNewLabel_2_1_1_1_1.setBounds(10, 158, 62, 16);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1_1);
		
		bairroFuncionarioTextField = new JTextField();
		lblNewLabel_2_1_1_1_1.setLabelFor(bairroFuncionarioTextField);
		bairroFuncionarioTextField.setBounds(82, 158, 200, 19);
		bairroFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(bairroFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("CIDADE:");
		lblNewLabel_2_1_1_1_1_1.setBounds(306, 158, 62, 16);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1_1_1);
		
		cidadeFuncionarioTextField = new JTextField();
		lblNewLabel_2_1_1_1_1_1.setLabelFor(cidadeFuncionarioTextField);
		cidadeFuncionarioTextField.setBounds(388, 158, 200, 19);
		cidadeFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(cidadeFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("COMPLEMENTO:");
		lblNewLabel_2_1_1_1_1_2.setBounds(618, 158, 119, 16);
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1_1_2);
		
		complementoTextField = new JTextField();
		lblNewLabel_2_1_1_1_1_2.setLabelFor(complementoTextField);
		complementoTextField.setBounds(749, 158, 132, 19);
		complementoTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(complementoTextField);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("ESTADO:");
		lblNewLabel_2_1_2_1_1.setBounds(767, 111, 72, 16);
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_2_1_1);
		
		JComboBox estadosFuncionarioComboBox = new JComboBox(new Object[]{});
		estadosFuncionarioComboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		lblNewLabel_2_1_2_1_1.setLabelFor(estadosFuncionarioComboBox);
		estadosFuncionarioComboBox.setBounds(835, 107, 46, 21);
		dados_pessoais_funcionarios_panel.add(estadosFuncionarioComboBox);
		
		JLabel lblNewLabel_2_1_1_1_1_3 = new JLabel("CPF");
		lblNewLabel_2_1_1_1_1_3.setBounds(10, 209, 62, 16);
		lblNewLabel_2_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1_1_3);
		
		JFormattedTextField CPFFuncionarioTextField = new JFormattedTextField();
		CPFFuncionarioTextField.setText("   .   .   -  ");
		lblNewLabel_2_1_1_1_1_3.setLabelFor(CPFFuncionarioTextField);
		CPFFuncionarioTextField.setBounds(82, 210, 200, 19);
		CPFFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(CPFFuncionarioTextField);
		
		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel("RG:");
		lblNewLabel_2_1_1_1_1_3_1.setBounds(306, 209, 62, 16);
		lblNewLabel_2_1_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		dados_pessoais_funcionarios_panel.add(lblNewLabel_2_1_1_1_1_3_1);
		
		RGFuncionarioTextField = new JTextField();
		lblNewLabel_2_1_1_1_1_3_1.setLabelFor(RGFuncionarioTextField);
		RGFuncionarioTextField.setBounds(388, 209, 200, 19);
		RGFuncionarioTextField.setColumns(10);
		dados_pessoais_funcionarios_panel.add(RGFuncionarioTextField);
		
		senhaFuncionarioTextField = new JTextField();
		senhaFuncionarioTextField.setColumns(10);
		senhaFuncionarioTextField.setBounds(679, 209, 105, 19);
		dados_pessoais_funcionarios_panel.add(senhaFuncionarioTextField);
		
		JLabel senhaFuncionarioLabel = new JLabel("SENHA:");
		senhaFuncionarioLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		senhaFuncionarioLabel.setBounds(618, 212, 51, 16);
		dados_pessoais_funcionarios_panel.add(senhaFuncionarioLabel);
		
		JComboBox nivelAcessoComboBoxFuncionario = new JComboBox(new Object[]{});
		nivelAcessoComboBoxFuncionario.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "USUARIO"}));
		nivelAcessoComboBoxFuncionario.setBounds(794, 208, 87, 21);
		dados_pessoais_funcionarios_panel.add(nivelAcessoComboBoxFuncionario);
		
		JLabel cargoLabel = new JLabel("CARGO: ");
		cargoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cargoLabel.setBounds(618, 41, 51, 16);
		dados_pessoais_funcionarios_panel.add(cargoLabel);
		
		JFormattedTextField cargoFuncionariorTextField = new JFormattedTextField();
		cargoLabel.setLabelFor(cargoFuncionariorTextField);
		cargoFuncionariorTextField.setColumns(10);
		cargoFuncionariorTextField.setBounds(700, 38, 181, 19);
		dados_pessoais_funcionarios_panel.add(cargoFuncionariorTextField);
		
		JPanel consulta_funcionarios_panel = new JPanel();
		tabbedPane.addTab("Consulta de funcionarios", null, consulta_funcionarios_panel, null);
		consulta_funcionarios_panel.setLayout(null);
		
		JLabel nomeLabelConsulta = new JLabel("NOME: ");
		nomeLabelConsulta.setBounds(10, 13, 45, 13);
		nomeLabelConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		consulta_funcionarios_panel.add(nomeLabelConsulta);
		
		nomeCFtextField = new JTextField();
		nomeCFtextField.setBounds(82, 10, 200, 19);
		nomeCFtextField.setColumns(10);
		consulta_funcionarios_panel.add(nomeCFtextField);
		
		JButton btnNewButton_1 = new JButton("PESQUISAR");
		btnNewButton_1.setBounds(296, 10, 115, 21);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		consulta_funcionarios_panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 890, 187);
		consulta_funcionarios_panel.add(scrollPane);
		
		tableCadastroFuncionarios = new JTable(
				new DefaultTableModel(new Object[][] {},
				new String[] {
						"ID", "Nome", "Email", "Celular", "Telefone", "CEP", "Endereco", "Numero", "Cidade", "Bairro", "Complemento", "UF", "RG", "CPF",
						"cargo", "senha", "nivel_acesso"
				})
		);
		scrollPane.setViewportView(tableCadastroFuncionarios);
		
		JButton novoFuncionarioBTN = new JButton("NOVO FUNCIONARIO");
		novoFuncionarioBTN.setIcon(new ImageIcon(FormEmployess.class.getResource("/br/com/sistema/imagens/add1.png")));
		novoFuncionarioBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		novoFuncionarioBTN.setBounds(57, 421, 140, 34);
		contentPane.add(novoFuncionarioBTN);
		
		JButton salvarFuncionarioBTN = new JButton("SALVAR FUNCIONARIO");
		salvarFuncionarioBTN.setIcon(new ImageIcon(FormEmployess.class.getResource("/br/com/sistema/imagens/salvar.png")));
		salvarFuncionarioBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		salvarFuncionarioBTN.setBounds(220, 421, 140, 34);
		salvarFuncionarioBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(nomeFuncionarioTextField.getText());
				funcionario.setEmail(emailFuncionarioTextField.getText());
				funcionario.setCPF(CPFFuncionarioTextField.getText());
				funcionario.setTelefone(telephoneNumberFuncionarioTextField.getText());
				funcionario.setCelular(phoneNumbeFuncionariorTextField.getText());
				funcionario.setRG(RGFuncionarioTextField.getText());
				funcionario.setCEP(CEPFuncionarioTextField.getText());
				funcionario.setEndereco(enderecoFuncionarioTextField.getText());
				funcionario.setNumero(Integer.valueOf(numeroFuncionarioTextField.getText()));
				funcionario.setComplemento(complementoTextField.getText());
				funcionario.setCargo(cargoFuncionariorTextField.getText());
				funcionario.setSenha(senhaFuncionarioTextField.getText());
				funcionario.setNivel_acesso(nivelAcessoComboBoxFuncionario.getSelectedItem().toString());
				
				funcionarioDAO.save(funcionario);
				util.clearScreen(dados_pessoais_funcionarios_panel);
			}
		});
		contentPane.add(salvarFuncionarioBTN);
		
		JButton editarFuncionarioBTN = new JButton("EDITAR FUNCIONARIO");
		editarFuncionarioBTN.setIcon(new ImageIcon(FormEmployess.class.getResource("/br/com/sistema/imagens/editar.png")));
		editarFuncionarioBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		editarFuncionarioBTN.setBounds(382, 421, 140, 34);
		contentPane.add(editarFuncionarioBTN);
		
		JButton excluirFuncionarioBTN = new JButton("EXCLUIR FUNCIONARIO");
		excluirFuncionarioBTN.setIcon(new ImageIcon(FormEmployess.class.getResource("/br/com/sistema/imagens/excluir.png")));
		excluirFuncionarioBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		excluirFuncionarioBTN.setBounds(544, 421, 140, 34);
		contentPane.add(excluirFuncionarioBTN);
		
		JButton imprimirBTN = new JButton("IMPRIMIR");
		imprimirBTN.setIcon(new ImageIcon(FormEmployess.class.getResource("/br/com/sistema/imagens/printer.png")));
		imprimirBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		imprimirBTN.setBounds(707, 421, 140, 34);
		contentPane.add(imprimirBTN);
	}
}
