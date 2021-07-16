package by.jwd.pravdivets.task8.xmlmobile.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.jwd.pravdivets.task8.xmlmobile.constants.Constants;
import by.jwd.pravdivets.task8.xmlmobile.errorhandler.TariffsErrorHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TariffSaxConsole {

	private static Logger logger = LogManager.getLogger();

	public static void parseWithSAX(String fileName) {
		try {
			// SAX parser creating & configuring
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();

			reader.setContentHandler(new ConsoleTariffHandler());
			reader.setErrorHandler(new TariffsErrorHandler());
			reader.parse(fileName);

		} catch (SAXException e) {
			logger.error(fileName + " is not correct or valid. " + e.getMessage());
		} catch (IOException e) {
			logger.error("Can't read the file " + fileName + ". " + e.getMessage());
		} catch (ParserConfigurationException e) {
			logger.error("Something goes wrong with the configuration of the parser. " + e.getMessage());
		}
	}

}