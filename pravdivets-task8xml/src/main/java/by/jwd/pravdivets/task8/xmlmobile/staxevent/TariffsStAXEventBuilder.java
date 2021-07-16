package by.jwd.pravdivets.task8.xmlmobile.staxevent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;
import by.jwd.pravdivets.task8.xmlmobile.factory.AbstractTariffsBuilder;

public class TariffsStAXEventBuilder extends AbstractTariffsBuilder {
	private static Logger logger = LogManager.getLogger();

	private List<Tariff> tariffs = new ArrayList<>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

	public TariffsStAXEventBuilder() {
	}

	public TariffsStAXEventBuilder(List<Tariff> tariffs) {
		super(tariffs);
	}
	
	@Override
	public List<Tariff> getTariffs() {
		return tariffs;
	}

	@Override
	public void buildListTariffs(String fileName) {
		Tariff tariff = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = inputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart().equals("tariff")) {
						tariff = new Tariff();
					} else if (startElement.getName().getLocalPart().equals("ID")) {
						event = reader.nextEvent();
						tariff.setId(event.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("name")) {
						event = reader.nextEvent();
						tariff.setName(event.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("operator")) {
						event = reader.nextEvent();
						tariff.setOperator(event.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("status")) {
						event = reader.nextEvent();
						tariff.setStatus(event.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("release_date")) {
						event = reader.nextEvent();
						try {
							tariff.setReleaseDate(formatter.parse(event.asCharacters().getData()));
						} catch (ParseException e) {
							logger.error(
									"Something went wrong while parsing the <release_date> tag. " + e.getMessage());
						}
					} else if (startElement.getName().getLocalPart().equals("regular_payment")) {
						event = reader.nextEvent();
						tariff.setRegularPayment(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("connection_fee")) {
						event = reader.nextEvent();
						tariff.setConnectionFee(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("calls")) {
						event = reader.nextEvent();
						Attribute billMode = startElement.getAttributeByName(new QName("billing_model"));
						tariff.setBillingModel(billMode.getValue());
					} else if (startElement.getName().getLocalPart().equals("within_network")) {
						event = reader.nextEvent();
						tariff.setCallsWithinNetwork(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("other_networks")) {
						event = reader.nextEvent();
						tariff.setCallsOtherNetworks(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("landlines")) {
						event = reader.nextEvent();
						tariff.setCallLandlines(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("abroad")) {
						event = reader.nextEvent();
						tariff.setCallAbroad(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("videocall")) {
						event = reader.nextEvent();
						tariff.setCallVideo(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("favourite_numbers")) {
						event = reader.nextEvent();
						tariff.setFavouriteNumbers(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("SMS")) {
						event = reader.nextEvent();
						tariff.setSms(Integer.parseInt(event.asCharacters().getData()));
					} else if (startElement.getName().getLocalPart().equals("MMS")) {
						event = reader.nextEvent();
						tariff.setMms(Integer.parseInt(event.asCharacters().getData()));
					}
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals("tariff")) {
						tariffs.add(tariff);
					}
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File " + fileName + " not found. " + e.getMessage());
		} catch (XMLStreamException e) {
			logger.error("Well-formedness errors or unexpected processing conditions happened. " + e.getMessage());
		}
	}
}
