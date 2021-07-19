package by.jwd.pravdivets.task8.xmlmobile.staxevent;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class TariffStaxEventConsoleMain {
	public static void main(String[] args) {
		String fileName = FilePaths.fileName;
		TariffStaxEventConsole.printTariffsToConsole(fileName);
	}

}
