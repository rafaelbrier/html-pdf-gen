package com.report.html.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractPropertyExtractor {

	static private Map<String, Properties> cache = new HashMap<>();
	private Properties props;

	public AbstractPropertyExtractor(String filePath) {
		this.load(filePath);
	}

	private void load(String fileName) {
		Properties cachedProps = AbstractPropertyExtractor.cache.get(fileName);
		if (cachedProps != null) {
			props = cachedProps;
		}
		props = new Properties();
		try {
			InputStream propsInputStream = AbstractPropertyExtractor.class.getResourceAsStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(propsInputStream,
					StandardCharsets.UTF_8.name());
			props.load(inputStreamReader);
			AbstractPropertyExtractor.cache.put(fileName, props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Load properties " + fileName + " exception");
		}

	}

	protected String getMessage(String propertyName, final Object... params) {
		return MessageFormat.format(props.getProperty(propertyName), params);
	}

	protected String getMessage(String propertyName) {
		return MessageFormat.format(props.getProperty(propertyName), "");
	}
}