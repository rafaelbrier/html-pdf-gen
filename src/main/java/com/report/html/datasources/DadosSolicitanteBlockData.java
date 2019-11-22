package com.report.html.datasources;

public class DadosSolicitanteBlockData {
	
	private static final String EMPTY = "----";

	private String nomeEmpresa;
	private String cpfCnpj;
	private String telefone;
	private String email;
	private String agenciaRelacionamento;
	private String nomeAgencia;
	private String telefoneAdicional;

	public DadosSolicitanteBlockData() {
		super();
	}

	public DadosSolicitanteBlockData(String nomeEmpresa, String cpfCnpj, String telefone, String email,
			String agenciaRelacionamento, String nomeAgencia, String telefoneAdicional) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
		this.email = email;
		this.agenciaRelacionamento = agenciaRelacionamento;
		this.nomeAgencia = nomeAgencia;
		this.telefoneAdicional = telefoneAdicional;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa != null ? nomeEmpresa : EMPTY;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCpfCnpj() {
		return cpfCnpj != null ? cpfCnpj : EMPTY;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelefone() {
		return telefone != null ? telefone : EMPTY;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email != null ? email : EMPTY;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAgenciaRelacionamento() {
		return agenciaRelacionamento != null ? agenciaRelacionamento : EMPTY;
	}

	public void setAgenciaRelacionamento(String agenciaRelacionamento) {
		this.agenciaRelacionamento = agenciaRelacionamento;
	}

	public String getNomeAgencia() {
		return nomeAgencia != null ? nomeAgencia : EMPTY;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getTelefoneAdicional() {
		return telefoneAdicional != null ? telefone : EMPTY;
	}

	public void setTelefoneAdicional(String telefoneAdicional) {
		this.telefoneAdicional = telefoneAdicional;
	}

}
