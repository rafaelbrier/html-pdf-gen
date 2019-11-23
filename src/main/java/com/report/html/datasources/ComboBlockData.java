package com.report.html.datasources;

public class ComboBlockData {

	private static final String EMPTY = "----";

	private String nomeCombo;
	private String valorComboSemDesconto;
	private String valorComboComDescontoInteiro;
	private String valorComboComDescontoDecimal;
	private String parcelasBemEmGarantia;
	private String parcelasBemNaoGarantia;

	public ComboBlockData() {
		super();
	}

	public ComboBlockData(String nomeCombo, String valorComboSemDesconto, String valorComboComDescontoInteiro, String valorComboComDescontoDecimal,
			String parcelasBemEmGarantia, String parcelasBemNaoGarantia) {
		super();
		this.nomeCombo = nomeCombo;
		this.valorComboSemDesconto = valorComboSemDesconto;
		this.valorComboComDescontoDecimal = valorComboComDescontoDecimal;
		this.valorComboComDescontoInteiro = valorComboComDescontoInteiro;
		this.parcelasBemEmGarantia = parcelasBemEmGarantia;
		this.parcelasBemNaoGarantia = parcelasBemNaoGarantia;
	}

	public String getNomeCombo() {
		return nomeCombo != null ? nomeCombo.toUpperCase() : EMPTY;
	}

	public void setNomeCombo(String nomeCombo) {
		this.nomeCombo = nomeCombo;
	}

	public String getValorComboSemDesconto() {
		return valorComboSemDesconto != null ? valorComboSemDesconto : EMPTY;
	}

	public void setValorComboSemDesconto(String valorComboSemDesconto) {
		this.valorComboSemDesconto = valorComboSemDesconto;
	}

	public String getValorComboComDescontoInteiro() {
		return valorComboComDescontoInteiro != null ? valorComboComDescontoInteiro : EMPTY;
	}

	public void setValorComboComDescontoInteiro(String valorComboComDescontoInteiro) {
		this.valorComboComDescontoInteiro = valorComboComDescontoInteiro;
	}

	public String getValorComboComDescontoDecimal() {
		return valorComboComDescontoDecimal != null ? valorComboComDescontoDecimal : EMPTY; 
	}

	public void setValorComboComDescontoDecimal(String valorComboComDescontoDecimal) {
		this.valorComboComDescontoDecimal = valorComboComDescontoDecimal;
	}

	public String getParcelasBemEmGarantia() {
		return parcelasBemEmGarantia != null ? parcelasBemEmGarantia : EMPTY;
	}

	public void setParcelasBemEmGarantia(String parcelasBemEmGarantia) {
		this.parcelasBemEmGarantia = parcelasBemEmGarantia;
	}

	public String getParcelasBemNaoGarantia() {
		return parcelasBemNaoGarantia != null ? parcelasBemNaoGarantia : EMPTY;
	}

	public void setParcelasBemNaoGarantia(String parcelasBemNaoGarantia) {
		this.parcelasBemNaoGarantia = parcelasBemNaoGarantia;
	}
}
