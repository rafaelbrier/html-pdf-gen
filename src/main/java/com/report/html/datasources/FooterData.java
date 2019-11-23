package com.report.html.datasources;

import com.report.html.utils.AbstractPropertyExtractor;

public class FooterData extends AbstractPropertyExtractor {

	public FooterData() {
		super("/reports/properties/main.properties");
	}

	public String getObsText() {
		return getMessage("footer.obs.text");

	}

	public String getSacText() {
		return getMessage("footer.sac.text");
	}

}