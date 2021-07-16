package by.jwd.pravdivets.task8.xmlmobile.staxevent;

import by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter;


public class TariffStaxEventConsole {
	public static void printTariffsToConsole(String fileName) {
		TariffsStAXEventBuilder staxBuilder = new TariffsStAXEventBuilder();
		staxBuilder.buildListTariffs(fileName);
		TariffsListPrinter.printTariffsFromList(staxBuilder.getTariffs());
		
		
	}
}