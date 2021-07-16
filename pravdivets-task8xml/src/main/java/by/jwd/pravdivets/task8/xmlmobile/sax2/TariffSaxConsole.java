package by.jwd.pravdivets.task8.xmlmobile.sax2;

import by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter;

public class TariffSaxConsole {

	public static void printTariffsToConsole(String fileName) {
		TariffsSaxBuilder saxBuilder = new TariffsSaxBuilder();
		saxBuilder.buildListTariffs(fileName);
		TariffsListPrinter.printTariffsFromList(saxBuilder.getTariffs());
	}
	
}
