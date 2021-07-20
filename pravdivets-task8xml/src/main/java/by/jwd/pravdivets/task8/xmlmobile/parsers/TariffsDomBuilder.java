package by.jwd.pravdivets.task8.xmlmobile.parsers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;
import by.jwd.pravdivets.task8.xmlmobile.factory.AbstractTariffsBuilder;

public class TariffsDomBuilder extends AbstractTariffsBuilder {
	private static Logger logger = LogManager.getLogger();

	private List<Tariff> tariffs;
	private DocumentBuilder docBuilder;

	public TariffsDomBuilder() {
		initTariffsDomBuilder();
	}

	public TariffsDomBuilder(List<Tariff> tariffs) {
		super(tariffs);
		initTariffsDomBuilder();
	}

	private void initTariffsDomBuilder() {
		tariffs = new ArrayList<Tariff>();
		// configuration
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.error("Something goes wrong with the configuration of the parser. " + e.getMessage());
		}
	}

	public List<Tariff> getTariffs() {
		return tariffs;
	}

	@Override
	public void buildListTariffs(String fileName) {
		Document doc;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			// getting a list of <tariff> child elements
			NodeList tariffsList = root.getElementsByTagName("tariff");
			for (int i = 0; i < tariffsList.getLength(); i++) {
				Element tariffElement = (Element) tariffsList.item(i);
				Tariff tariff = buildTariff(tariffElement);
				tariffs.add(tariff);
			}
		} catch (SAXException e) {
			logger.error(fileName + " is not correct or valid. " + e.getMessage());
		} catch (IOException e) {
			logger.error("Can't read the file " + fileName + ". " + e.getMessage());
		}
	}

	private Tariff buildTariff(Element tariffElement) {
		Tariff tariff = new Tariff();
		// add null check
		tariff.setId(getElementTextContent(tariffElement, "ID"));
		tariff.setName(getElementTextContent(tariffElement, "name"));
		tariff.setOperator(getElementTextContent(tariffElement, "operator"));
		tariff.setStatus(getElementTextContent(tariffElement, "status"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

		try {
			tariff.setReleaseDate(formatter.parse((getElementTextContent(tariffElement, "release_date"))));
		} catch (ParseException e) {
			logger.error("Something went wrong while parsing the <release_date> tag. " + e.getMessage());
		}

		Integer regularPayment = Integer.parseInt(getElementTextContent(tariffElement, "regular_payment"));
		tariff.setRegularPayment(regularPayment);

		Integer connectionFee = Integer.parseInt(getElementTextContent(tariffElement, "connection_fee"));
		tariff.setConnectionFee(connectionFee);

		NodeList callsElements = tariffElement.getElementsByTagName("calls");
		Element callsElement = (Element) callsElements.item(0);
		tariff.setBillingModel(callsElement.getAttribute("billing_model"));

		Integer callWithinNetwork = Integer.parseInt(getElementTextContent(tariffElement, "within_network"));
		tariff.setCallsWithinNetwork(callWithinNetwork);

		Integer callOtherNetworks = Integer.parseInt(getElementTextContent(tariffElement, "other_networks"));
		tariff.setCallsOtherNetworks(callOtherNetworks);

		Integer callLandlines = Integer.parseInt(getElementTextContent(tariffElement, "landlines"));
		tariff.setCallLandlines(callLandlines);

		Integer callAbroad = Integer.parseInt(getElementTextContent(tariffElement, "abroad"));
		tariff.setCallAbroad(callAbroad);

		Integer callVideo = Integer.parseInt(getElementTextContent(tariffElement, "videocall"));
		tariff.setCallVideo(callVideo);

		Integer favouriteNumbers = Integer.parseInt(getElementTextContent(tariffElement, "favourite_numbers"));
		tariff.setFavouriteNumbers(favouriteNumbers);

		Integer sms = Integer.parseInt(getElementTextContent(tariffElement, "SMS"));
		tariff.setSms(sms);

		Integer mms = Integer.parseInt(getElementTextContent(tariffElement, "MMS"));
		tariff.setMms(mms);

		return tariff;
	}

	// get the text content of the tag
	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);

		String text;

		if (!(node == null)) {
			text = node.getTextContent();
		} else {
			text = "0"; // я позволил себе эту "вольность",
						// так как все необязательные элементы (minOccurs="0")
						// в файле tariffs.xml содержат числовые значения
		}

		return text;
	}
}
