package by.jwd.pravdivets.task8.xmlmobile.stax;

import by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter;

public class TariffStaxConsole {

	public static void printTariffsToConsole(String fileName) {
		TariffsStAXBuilder staxBuilder = new TariffsStAXBuilder();
		staxBuilder.buildListTariffs(fileName);
		
		TariffsListPrinter.printTariffsFromList(staxBuilder.getTariffs());
		
		
	}
	
	
}
