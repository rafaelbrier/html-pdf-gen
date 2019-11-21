package com.report.html.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.report.html.models.Book;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;

@Controller
@RequestMapping("report")
public class ReportResource {

	@GetMapping
	public void gerarRelatorio(HttpServletResponse response) throws Exception {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
		books.add(new Book("Life, the Universe and Everything", 5.60, false));
		books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stylesheet", getClass().getResource("/template/index.css").toString());
		model.put("books", books);
		model.put("pageName", "My Bookshelf");

		String html = Jade4J.render(getClass().getResource("/template/index.jade"), model);
		buildAndExportPdf(response, html, "", "relatorio");

	}

	protected void buildAndExportPdf(HttpServletResponse response, String html, String htmlContentPath, String fileName)
			throws IOException {
		try {
			PdfRendererBuilder builder = new PdfRendererBuilder();
			builder.useFastMode();
			builder.withHtmlContent(html, htmlContentPath);
			builder.toStream(response.getOutputStream());
			builder.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=" + fileName);
	}

}
