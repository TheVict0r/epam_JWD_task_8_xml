package by.jwd.pravdivets.task8.xmlmobile.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ConsoleTariffHandler extends DefaultHandler {
	@Override
	public void startDocument() {
		//System.out.println("Parsing started");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		String tagData = qName + " ";
		for (int i = 0; i < attrs.getLength(); i++) {
			tagData += "\n" + attrs.getQName(i) + "      | " + attrs.getValue(i) + "\n";
		}
		
		if ("tariffs".equals(qName)) {
			System.out.println("Tariff list parsed from xml file (SAX parser)" + "\n");
			
		} else if ("tariff".equals(qName)) {
			System.out.println("TARIFF");
			System.out.println("=================================");
		} else if ("calls".equals(qName)){
			System.out.println("  CALLS:           |");
		} else if ("messages".equals(qName)){
			System.out.println("  MESSAGES:        |");
		} else {
			System.out.printf("%-18s", tagData);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		String element = new String(ch, start, length).trim();
		if(!element.isEmpty()) {
			System.out.println(" | " + element);
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if("tariff".equals(qName)) {
			System.out.println("---------------------------------");
			System.out.println();
		}
		
	}

	@Override
	public void endDocument() {
		//System.out.println("\nParsing ended");
	}
}
