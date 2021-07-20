package by.jwd.pravdivets.task8.xmlmobile.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;
import by.jwd.pravdivets.task8.xmlmobile.entity.TariffXmlTag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;

public class TariffHandler  extends DefaultHandler {
	private List<Tariff> tariffs;
	private Tariff tariff;
	private TariffXmlTag currentXmlTag;
	private EnumSet<TariffXmlTag> withText;
	private static final String ELEMENT_TARIFF = "tariff";
	private static final String ELEMENT_CALLS = "calls";
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	private static Logger logger = LogManager.getLogger();
	
	public TariffHandler() {
		tariffs = new ArrayList<Tariff>();
		withText = EnumSet.range(TariffXmlTag.ID, TariffXmlTag.MMS);
	}

	public List<Tariff> getTariffs() {
		return tariffs;
	}

	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		if (ELEMENT_TARIFF.equals(qName)) {
			tariff = new Tariff();
		} else if(ELEMENT_CALLS.equals(qName)){
			tariff.setBillingModel(attrs.getValue(0));
		} else {
			TariffXmlTag temp = TariffXmlTag.valueOf(qName.toUpperCase());
			if (withText.contains(temp)) {
				currentXmlTag = temp;
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if (ELEMENT_TARIFF.equals(qName)) {
			tariffs.add(tariff);
		}
	}

	public void characters(char[] ch, int start, int length) {
		String data = new String(ch, start, length).strip();
		if (currentXmlTag != null) {
			switch (currentXmlTag) {

			case ID:
				tariff.setId(data);
				break;
			case NAME:
				tariff.setName(data);
				break;
			case OPERATOR:
				tariff.setOperator(data);
				break;
			case STATUS:
				tariff.setStatus(data);
				break;
			case RELEASE_DATE:
				try {
					tariff.setReleaseDate(formatter.parse(data));
				} catch (ParseException e) {
					logger.error("Something went wrong while parsing the <release_date> tag. " + e.getMessage());
				}
				break;
			case REGULAR_PAYMENT:
				tariff.setRegularPayment(Integer.parseInt(data));
				break;
			case CONNECTION_FEE:
				tariff.setConnectionFee(Integer.parseInt(data));
				break;
			case CALLS:
				break;
			case WITHIN_NETWORK:
				tariff.setCallsWithinNetwork(Integer.parseInt(data));
				break;
			case OTHER_NETWORKS:
				tariff.setCallsOtherNetworks(Integer.parseInt(data));
				break;
			case LANDLINES:
				tariff.setCallLandlines(Integer.parseInt(data));
				break;
			case ABROAD:
				tariff.setCallAbroad(Integer.parseInt(data));
				break;
			case VIDEOCALL:
				tariff.setCallVideo(Integer.parseInt(data));
				break;
			case FAVOURITE_NUMBERS:
				tariff.setFavouriteNumbers(Integer.parseInt(data));
				break;
			case SMS:
				tariff.setSms(Integer.parseInt(data));
				break;
			case MESSAGES:
				break;
			case MMS:
				tariff.setMms(Integer.parseInt(data));
				break;
				
			default:
				throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
			}
		}
		currentXmlTag = null;
	}
}