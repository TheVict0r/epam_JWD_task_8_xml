package by.jwd.pravdivets.task8.xmlmobile.factory;

import by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter;

public class TariffBuilderFactoryConsole {

	public static void delieverTariffsToConsole(String fileName, String parcer) {
		AbstractTariffsBuilder builder = TariffsBuilderFactory.createTariffsBuilder(parcer);
		builder.buildListTariffs(fileName);
		TariffsListPrinter.printTariffsFromList(builder.getTariffs());
	}
}
