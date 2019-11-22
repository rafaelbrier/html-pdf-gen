package com.report.html.models;

public class Text {

	private String text;
	private Boolean isBold;

	public Text() {
		super();
	}

	public Text(String text, Boolean isBold) {
		super();
		this.text = text;
		this.isBold = isBold;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsBold() {
		return isBold;
	}

	public void setIsBold(Boolean isBold) {
		this.isBold = isBold;
	}

}
