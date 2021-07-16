package by.jwd.pravdivets.task8.xmlmobile.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.pravdivets.task8.xmlmobile.constants.Constants;
import by.jwd.pravdivets.task8.xmlmobile.validator.TariffsValidator;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String language = Constants.LANGUAGE;
    String fileName = Constants.FILE_NAME;
    String schemaName = Constants.SHEMA_NAME;
    //private static Logger logger = LogManager.getLogger();
    
    
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
		
		response.setContentType("text/html");
		
		String action = request.getParameter("validate");
		String parcing = request.getParameter("parce");
		
		
		if ("perform_validation".equals(action)) {
			boolean res = TariffsValidator.isValide(language, fileName, schemaName);
		    System.out.println(res);
		} else if ("SAX_parcing".equals(parcing)) {
			System.out.println("PARCE-PARCE!!" + parcing);
		} else if ("StAX_parcing".equals(parcing)) {
			System.out.println("PARCE-PARCE!!" + parcing);
		} else if ("DOM_parcing".equals(parcing)) {
			System.out.println("PARCE-PARCE!!" + parcing);
		}
		
		
		
	}

}
