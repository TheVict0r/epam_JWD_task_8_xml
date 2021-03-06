package by.jwd.pravdivets.task8.xmlmobile.factory;

import by.jwd.pravdivets.task8.xmlmobile.parsers.TariffsDomBuilder;
import by.jwd.pravdivets.task8.xmlmobile.parsers.TariffsSaxBuilder;
import by.jwd.pravdivets.task8.xmlmobile.parsers.TariffsStAXEventBuilder;

public class TariffsBuilderFactory {

	private enum TypeParser {
		SAX, STAX, DOM
	}

	private TariffsBuilderFactory() { }
	
	public static AbstractTariffsBuilder createTariffsBuilder(String typeParser) {
		// insert parser name validation
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		
		switch (type) {
		case DOM:
			return  new TariffsDomBuilder();
		case STAX:
			return  new TariffsStAXEventBuilder();
		case SAX:
			return  new TariffsSaxBuilder();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());	
		}
		
	}
	
	
	
	
	
}