package by.jwd.pravdivets.task8.xmlmobile.dom;

import by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter;

public class TariffsDomConsole {

	public static void printTariffsToConsole(String fileName) {
		TariffsDomBuilder domBuilder = new TariffsDomBuilder();
		domBuilder.buildListTariffs(fileName);
		TariffsListPrinter.printTariffsFromList(domBuilder.getTariffs());
	}
	
	
}
