package by.jwd.pravdivets.task8.xmlmobile.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;
import by.jwd.pravdivets.task8.xmlmobile.factory.TariffBuilderFactoryConsole;
import by.jwd.pravdivets.task8.xmlmobile.uploder.FileUploader;
import by.jwd.pravdivets.task8.xmlmobile.validator.TariffsValidator;

@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger();
    
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String language = FilePaths.LANGUAGE;
	    String fileName = FilePaths.fileName;
	    String schemaName = FilePaths.shemaName;
		
		response.setContentType("text/html");
		
		String validation = request.getParameter("validate");
		String parcing = request.getParameter("parce");
		String fileType = request.getParameter("uploadfile");
				
		if("XML".equals(fileType) || "XSD".equals(fileType)) {
			FileUploader uploader = new FileUploader();
			try {
				uploader.saveFile(fileType, request, response);
			} catch (ServletException  e) {
				logger.error("Something wrong with Controller servlet. " + e.getMessage());
			} catch ( IOException e) {
				logger.error("Something wrong with the " + fileType + " file. " + e.getMessage());
			}
		} else if ("perform_validation".equals(validation)) {
			boolean res = TariffsValidator.isValide(language, fileName, schemaName);
		    System.out.println(res);
		} else if ("SAX".equals(parcing) || "StAX".equals(parcing) || "DOM".equals(parcing)) {
			TariffBuilderFactoryConsole.delieverTariffsToConsole(fileName, parcing);
		}
		
	}

}
