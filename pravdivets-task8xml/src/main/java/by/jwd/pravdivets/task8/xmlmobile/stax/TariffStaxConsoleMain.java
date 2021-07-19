package by.jwd.pravdivets.task8.xmlmobile.stax;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class TariffStaxConsoleMain {

	public static void main(String[] args) {
		String fileName = FilePaths.fileName;
		TariffStaxConsole.printTariffsToConsole(fileName);
	}

}
