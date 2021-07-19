package by.jwd.pravdivets.task8.xmlmobile.dom;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class TariffsDomConsoleMain {

	public static void main(String[] args) {
		String fileName = FilePaths.fileName;
		TariffsDomConsole.printTariffsToConsole(fileName);
	}

}
