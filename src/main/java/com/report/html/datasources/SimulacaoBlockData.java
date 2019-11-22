package com.report.html.datasources;

public class SimulacaoBlockData {

	private static final String EMPTY = "----";

	private String codigoCotacao;
	private String dataSimulacao;
	private String dataValidade;

	public SimulacaoBlockData() {
		super();
	}

	public SimulacaoBlockData(String codigoCotacao, String dataSimulacao, String dataValidade) {
		super();
		this.codigoCotacao = codigoCotacao;
		this.dataSimulacao = dataSimulacao;
		this.dataValidade = dataValidade;
	}

	public String getCodigoCotacao() {
		return codigoCotacao != null ? codigoCotacao : EMPTY;
	}

	public void setCodigoCotacao(String codigoCotacao) {
		this.codigoCotacao = codigoCotacao;
	}

	public String getDataSimulacao() {
		return dataSimulacao != null ? dataSimulacao : EMPTY;
	}

	public void setDataSimulacao(String dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
	}

	public String getDataValidade() {
		return dataValidade != null ? dataValidade : EMPTY;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
