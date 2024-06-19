package br.com.sistema.model;

public enum DBTables {
	CLIENTES("clientes"),
	FUNCIONARIOS("funcionarios");
	
	private String tableName;
	
	DBTables(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	};
	
}
