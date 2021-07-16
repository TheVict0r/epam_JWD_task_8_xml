package by.jwd.pravdivets.task8.xmlmobile.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;
import by.jwd.pravdivets.task8.xmlmobile.entity.TariffXmlTag;
import by.jwd.pravdivets.task8.xmlmobile.factory.AbstractTariffsBuilder;


public class TariffsStAXBuilder  extends AbstractTariffsBuilder {
	private static Logger logger = LogManager.getLogger();
	
	private List<Tariff> tariffs = new ArrayList<>();
	private XMLInputFactory inputFactory;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	
	public TariffsStAXBuilder() {
		initTariffsStAXBuilder();
	}

	public TariffsStAXBuilder(List<Tariff> tariffs) {
		super(tariffs);
		initTariffsStAXBuilder();
	}
	
	private void initTariffsStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
	@Override
	public List<Tariff> getTariffs() {
		return tariffs ;
	}

	@Override
	public void buildListTariffs(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			// StAX parsing
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (TariffXmlTag.valueOf(name.toUpperCase()) == TariffXmlTag.TARIFF) {
						Tariff tariff = buildTariff(reader);
						tariffs.add(tariff);
					}
				}
			}
		} catch (XMLStreamException ex) {
			logger.error("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			logger.error("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("Impossible close file " + fileName + " : " + e);
			}
		}
	}

	private Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
		Tariff tariff = new Tariff();
	
		tariff.setBillingModel(getXMLBillingModelAttribute(reader));
		
		String name;
		
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (TariffXmlTag.valueOf(name.toUpperCase())) {
				case ID:
					tariff.setId(getXMLText(reader));
					break;
				case NAME:
					tariff.setName(getXMLText(reader));
					break;
				case OPERATOR:
					tariff.setOperator(getXMLText(reader));
					break;
				case STATUS:
					tariff.setStatus(getXMLText(reader));
					break;
				case RELEASE_DATE:
					try {
						tariff.setReleaseDate(formatter.parse(getXMLText(reader)));
					} catch (ParseException e) {
						logger.error("Something went wrong while parsing the <release_date> tag. " + e.getMessage());
					} 
					break;
				case REGULAR_PAYMENT:
					name = getXMLText(reader);
					tariff.setRegularPayment(Integer.parseInt(name));
					break;
				case CONNECTION_FEE:
					name = getXMLText(reader);
					tariff.setConnectionFee(Integer.parseInt(name));
					break;
				case WITHIN_NETWORK:
					name = getXMLText(reader);
					tariff.setCallsWithinNetwork(Integer.parseInt(name));
					break;
				case OTHER_NETWORKS:
					name = getXMLText(reader);
					tariff.setCallsOtherNetworks(Integer.parseInt(name));
					break;
				case LANDLINES:
					name = getXMLText(reader);
					tariff.setCallLandlines(Integer.parseInt(name));
					break;
				case ABROAD:
					name = getXMLText(reader);
					tariff.setCallAbroad(Integer.parseInt(name));
					break;
				case VIDEOCALL:
					name = getXMLText(reader);
					tariff.setCallVideo(Integer.parseInt(name));
					break;
				case FAVOURITE_NUMBERS:
					name = getXMLText(reader);
					tariff.setFavouriteNumbers(Integer.parseInt(name));
					break;
				case SMS:
					name = getXMLText(reader);
					tariff.setSms(Integer.parseInt(name));
					break;
				case MMS:
					name = getXMLText(reader);
					tariff.setMms(Integer.parseInt(name));
					break;
				}
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (TariffXmlTag.valueOf(name.toUpperCase()) == TariffXmlTag.TARIFF) {
					return tariff;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Tariff");
	}

	private String getXMLBillingModelAttribute(XMLStreamReader reader) {
		String billingModel = "working on";
				
//		if (reader.hasNext()) {
//			int type = reader.next();
//			
//			System.out.println(type);
//			
//			if (type == XMLStreamConstants.START_ELEMENT) {
//			
//				billingModel = reader.getAttributeValue(null, TariffXmlTag.BILLING_MODEL.getValue());
//			}
//		}
		
		return billingModel;
	}

	private String getXMLText(XMLStreamReader reader) {
		String text = null;
		try {
			if (reader.hasNext()) {
				reader.next();
				text = reader.getText();
			}
		} catch (XMLStreamException e) {
			logger.error("Well-formedness error or unexpected processing conditions" + e.getMessage());
		}
		return text;
	}
}
