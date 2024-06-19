package br.com.sistema.model;

public class Funcionario extends Cliente {
	private String senha;
	private String cargo;
	private String nivel_acesso;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNivel_acesso() {
		return nivel_acesso;
	}
	public void setNivel_acesso(String nivelAcesso) {
		this.nivel_acesso = nivelAcesso;
	}
}
