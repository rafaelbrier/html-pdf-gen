package com.report.html.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.report.html.datasources.ComboBlockData;
import com.report.html.datasources.DadosSolicitanteBlockData;
import com.report.html.datasources.FooterData;
import com.report.html.datasources.HeaderData;
import com.report.html.datasources.SimulacaoBlockData;
import com.report.html.models.Book;

import de.neuland.jade4j.Jade4J.Mode;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.TemplateLoader;

@Controller
@RequestMapping("report")
public class ReportResource {

	private static final String FILE_NAME = "relatorio_simulacao";

	@GetMapping
	public void gerarRelatorio(HttpServletResponse response) throws Exception {
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 60; i++) {
			books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		setBasicParameters(parameters);
		setHeaderData(parameters);
		setFooterData(parameters);
		setSimulacaoBlockData(parameters);
		setDadosSolicitanteBlockData(parameters);
		setComboBlockData(parameters);
		parameters.put("books", books);

		JadeConfiguration jadeConfig = getJadeConfiguration();
		String html = jadeConfig.renderTemplate(jadeConfig.getTemplate("report.jade"), parameters);
		String unescapedHtml = StringEscapeUtils.unescapeHtml4(html);
		buildAndExportPdf(response, unescapedHtml, FILE_NAME);
	}

	private void setBasicParameters(Map<String, Object> parameters) {
		/** Import StylesSheets */
		parameters.put("commonStyleSheet", getClass().getResource("/reports/styles/common.css").toString());
		parameters.put("firstPageStyleSheet", getClass().getResource("/reports/styles/firstPage.css").toString());
		parameters.put("pdfName", FILE_NAME);
	}

	private void setHeaderData(Map<String, Object> parameters) {
		parameters.put("headerData", new HeaderData());
	}

	private void setFooterData(Map<String, Object> parameters) {
		parameters.put("footerData", new FooterData());
	}

	private void setSimulacaoBlockData(Map<String, Object> parameters) {
		parameters.put("simulacaoBlockData", new SimulacaoBlockData("156201911000079", "31/05/1995", "31/05/2021"));
	}

	private void setDadosSolicitanteBlockData(Map<String, Object> parameters) {
		parameters.put("dadosSolicitanteBlockData", new DadosSolicitanteBlockData("EDER CHERUTTI", "315.586.458.37",
				"(11) 11111-1111", "echerute@brasilseg.csadasdadsadsadsom", "5116", "EMPR.GOIANIA", "(55) 11989 3759"));
	}

	private void setComboBlockData(Map<String, Object> parameters) {
		parameters.put("comboBlockData",
				new ComboBlockData("Combo Ideal", "800,00", "720", "00", "4x R$ 420,00", "4x R$ 380,00"));
	}

	protected void buildAndExportPdf(HttpServletResponse response, String html, String fileName) throws IOException {
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "inline; filename=" + fileName + ".pdf");
		try {
			PdfRendererBuilder builder = new PdfRendererBuilder();
			builder.useFastMode();
			builder.withHtmlContent(html, "");
			builder.toStream(response.getOutputStream());
			builder.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JadeConfiguration getJadeConfiguration() {
		JadeConfiguration jadeConfig = new JadeConfiguration();
		TemplateLoader loader = new FileTemplateLoader(getClass().getResource("/reports/templates/").getPath(),
				StandardCharsets.UTF_8.name());
		jadeConfig.setTemplateLoader(loader);
		jadeConfig.setPrettyPrint(true);
		jadeConfig.setMode(Mode.XHTML);
		return jadeConfig;
	}

}
