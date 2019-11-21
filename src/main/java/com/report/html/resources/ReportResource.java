package com.report.html.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.report.html.models.Book;

import de.neuland.jade4j.Jade4J;

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

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stylesheet", getClass().getResource("/template/index.css").toString());
		model.put("logoBB", getClass().getResource("/template/assets/LogoBB.png").toString());
		model.put("books", books);
		model.put("pdfName", FILE_NAME);

		String html = Jade4J.render(getClass().getResource("/template/index.jade"), model);
		buildAndExportPdf(response, html, "", FILE_NAME);

	}

	protected void buildAndExportPdf(HttpServletResponse response, String html, String htmlContentPath, String fileName)
			throws IOException {
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "inline; filename=" + fileName + ".pdf");
		try {
			PdfRendererBuilder builder = new PdfRendererBuilder();
//			builder.useFastMode();
			builder.withHtmlContent(html, htmlContentPath);
			builder.toStream(response.getOutputStream());
			builder.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
