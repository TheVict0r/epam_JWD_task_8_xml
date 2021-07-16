package by.jwd.pravdivets.task8.xmlmobile.sax2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;
import by.jwd.pravdivets.task8.xmlmobile.errorhandler.TariffsErrorHandler;
import by.jwd.pravdivets.task8.xmlmobile.factory.AbstractTariffsBuilder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class TariffsSaxBuilder extends AbstractTariffsBuilder {
	private List<Tariff> tariffs;
	private TariffHandler handler = new TariffHandler();
	private XMLReader reader;
	private static Logger logger = LogManager.getLogger();

	public TariffsSaxBuilder() {
		initTariffsSaxBuilder();
	}

	public TariffsSaxBuilder(List<Tariff> tariffs) {
		super(tariffs);
		initTariffsSaxBuilder();
	}

	private void initTariffsSaxBuilder() {
		// reader configuration
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			reader = saxParser.getXMLReader();
		} catch (ParserConfigurationException e) {
			logger.error("Something goes wrong with the configuration of the parser. " + e.getMessage());
		} catch (SAXException e) {
			logger.error("SAX error occured during processing. " + e.getMessage());
		}
		reader.setErrorHandler(new TariffsErrorHandler());
		reader.setContentHandler(handler);
	}

	public List<Tariff> getTariffs() {
		return tariffs;
	}

	@Override
	public void buildListTariffs(String fileName) {
		try {
			reader.parse(fileName);
		} catch (SAXException e) {
			logger.error(fileName + " is not correct or valid. " + e.getMessage());
		} catch (IOException e) {
			logger.error("Can't read the file " + fileName + ". " + e.getMessage());
		}
		tariffs = handler.getTariffs();
	}
}