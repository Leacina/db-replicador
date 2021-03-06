package br.com.dbreplicador.model;

import java.sql.Timestamp;

public class TableModel extends AbstractModel {
	private Integer codigo_replicacao;
	private Timestamp data_atual;
	private Timestamp data_atual_de;
	private String usuario;
	private String processo;
	private Integer ordem;
	private String tabela_origem;
	private String tabela_destino;
	private String coluna_tipo;
	private String coluna_chave;
	private String coluna_controle;
	private boolean backup_incremental;
	private Integer linhas_maximo;
	private boolean erro_ignorar;
	private boolean habilitado;
	
	/**
	 * codigo_replicacao
	 */
	public Integer getReplicationCode() {
		return codigo_replicacao;
	}
	
	/**
	 * codigo_replicacao
	 * 
	 * @param replicationCode
	 */
	public void setReplicationCode(Integer replicationCode) {
		this.codigo_replicacao = replicationCode;
	}
	
	/**
	 * data_atual
	 */
	public Timestamp getCurrentDate() {
		return data_atual;
	}
	
	/**
	 * data_atual
	 * 
	 * @param currentDate
	 */
	public void setCurrentDate(Timestamp currentDate) {
		this.data_atual = currentDate;
	}
	
	/**
	 * usuario
	 */
	public String getUser() {
		return usuario;
	}
	
	/**
	 * usuario
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.usuario = user;
	}
	
	/**
	 * processo
	 */
	public String getProcess() {
		return processo;
	}
	
	/**
	 * processo
	 * 
	 * @param process
	 */
	public void setProcess(String process) {
		this.processo = process;
	}
	
	/**
	 * ordem
	 */
	public Integer getOrder() {
		return ordem;
	}
	
	/**
	 * ordem
	 * 
	 * @param order
	 */
	public void setOrder(Integer order) {
		this.ordem = order;
	}
	
	/**
	 * tabela_origem
	 */
	public String getOriginTable() {
		return tabela_origem;
	}
	
	/**
	 * tabela_origem
	 * 
	 * @param originTable
	 */
	public void setOriginTable(String originTable) {
		this.tabela_origem = originTable;
	}
	
	/**
	 * tabela_destino
	 */
	public String getDestinationTable() {
		return tabela_destino;
	}
	
	/**
	 * tabela_destino
	 * 
	 * @param destinationTable
	 */
	public void setDestinationTable(String destinationTable) {
		this.tabela_destino = destinationTable;
	}
	
	/**
	 * coluna_tipo
	 */
	public String getTypeColumn() {
		return coluna_tipo;
	}
	
	/**
	 * coluna_tipo
	 * 
	 * @param typeColumn
	 */
	public void setTypeColumn(String typeColumn) {
		this.coluna_tipo = typeColumn;
	}
	
	/**
	 * coluna_chave
	 */
	public String getKeyColumn() {
		return coluna_chave;
	}
	
	/**
	 * coluna_chave
	 * 
	 * @param keyColumn
	 */
	public void setKeyColumn(String keyColumn) {
		this.coluna_chave = keyColumn;
	}
	
	/**
	 * coluna_controle
	 */
	public String getControlColumn() {
		return coluna_controle;
	}
	
	/**
	 * coluna_controle
	 * 
	 * @param keyColumn
	 */
	public void setControlColumn(String controlColumn) {
		this.coluna_controle = controlColumn;
	}
	
	/**
	 * backup_incremental
	 */
	public boolean isIncrementalBackup() {
		return backup_incremental;
	}
	
	/**
	 * backup_incremental
	 * 
	 * @param backupIncremental
	 */
	public void setIncrementalBackup(boolean incremental) {
		this.backup_incremental = incremental;
	}
	
	/**
	 * linhas_maximo
	 */
	public Integer getMaximumLines() {
		return linhas_maximo;
	}
	
	/**
	 * linhas_maximo
	 * 
	 * @param maximumLines
	 */
	public void setMaximumLines(Integer maximumLines) {
		this.linhas_maximo = maximumLines;
	}
	
	/**
	 * erro_ignorar
	 */
	public boolean isErrorIgnore() {
		return erro_ignorar;
	}
	
	/**
	 * erro_ignorar
	 * 
	 * @param errorIgnore
	 */
	public void setErrorIgnore(boolean errorIgnore) {
		this.erro_ignorar = errorIgnore;
	}
	
	/**
	 * habilitado
	 */
	public boolean isEnable() {
		return habilitado;
	}
	
	/**
	 * habilitado
	 * 
	 * @param enable
	 */
	public void setEnable(boolean enable) {
		this.habilitado = enable;
	}	
	
	/**
	 * data_atual_de
	 */
	public Timestamp getCurrentDateOf() {
		return data_atual_de;
	}
	
	/**
	 * data_atual_de
	 * 
	 * @param currentDateOf
	 */
	public void setCurrentDateOf(Timestamp currentDateOf) {
		this.data_atual_de = currentDateOf;
	}

}
