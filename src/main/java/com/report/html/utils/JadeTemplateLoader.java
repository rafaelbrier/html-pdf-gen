package com.report.html.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Date;

import de.neuland.jade4j.template.TemplateLoader;

public class JadeTemplateLoader implements TemplateLoader {

	private static final String JADE = "jade";
	private Class<?> clazz;
	private String folderPath;
	private String encoding;

	public JadeTemplateLoader(Class<?> clazz, String folderPath, String encoding) {
		super();
		this.clazz = clazz;
		this.encoding = encoding;
		this.folderPath = folderPath;
	}

	@Override
	public long getLastModified(String name) throws IOException {
		URL url = clazz.getClass().getResource(folderPath + name);
		if (url != null)
			return new Date(url.openConnection().getLastModified()).getTime();
		else
			return -1;
	}

	@Override
	public Reader getReader(String name) throws IOException {
		InputStream inputStream = clazz.getClassLoader().getResourceAsStream(folderPath + name);
		return new InputStreamReader(inputStream, encoding);
	}

	@Override
	public String getExtension() {
		return JADE;
	}

}
