package by.jwd.pravdivets.task8.xmlmobile.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.xml.sax.SAXException;

import by.jwd.pravdivets.task8.xmlmobile.errorhandler.TariffsErrorHandler;

public class TariffsValidator {

	private static Logger logger = LogManager.getLogger();
	
	public boolean isValide(String language, String fileName, String schemaName) {
		boolean result;
		result = true;
		SchemaFactory factory = SchemaFactory.newInstance(language);
	    File schemaLocation = new File(schemaName);
	    try {
	      // schema creation
	      Schema schema = factory.newSchema(schemaLocation);
	      // creating a schema-based validator
	      Validator validator = schema.newValidator();
	      Source source = new StreamSource(fileName);
	      // document check
	      validator.setErrorHandler(new TariffsErrorHandler());
	      validator.validate(source);
	      //System.out.println("The end of the validation process");
	    } catch (SAXException e) {
	    	logger.error(fileName + " is not correct or valid. " + e.getMessage());
	    	result = false;
	    	
	    } catch (IOException e) {
	    	logger.error("Can't read the file " + fileName + ". " + e.getMessage());
	    	result = false;
	    }
	    
	    return result;
	}
	
	
}
