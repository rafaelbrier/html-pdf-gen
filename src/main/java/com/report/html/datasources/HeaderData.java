package com.report.html.datasources;

import java.util.ArrayList;
import java.util.List;

import com.report.html.models.Text;
import com.report.html.utils.AbstractPropertyExtractor;

public class HeaderData extends AbstractPropertyExtractor {

	public HeaderData() {
		super("/reports/properties/main.properties");
	}

	public String getHeaderLogo() {
		return getClass().getResource("/reports/images/LogoBB.png").toString();

	}

	public List<Text> getHeaderTextList() {
		List<Text> textList = new ArrayList<Text>();
		textList.add(new Text(getMessage("header.text1"), true));
		textList.add(new Text(getMessage("header.text2"), false));
		textList.add(new Text(getMessage("header.text3"), false));
		textList.add(new Text(getMessage("header.text4"), false));
		textList.add(new Text(getMessage("header.text5"), false));
		return textList;
	}

}
