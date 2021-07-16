package by.jwd.pravdivets.task8.xmlmobile.factory;

import by.jwd.pravdivets.task8.xmlmobile.constants.Constants;



public class TariffBuilderFactoryMain {

	public static void main(String[] args) {
		String fileName = Constants.FILE_NAME;
		
		String parcer = "stax";
		//String parcer = "sax";
		//String parcer = "dom";
		
		TariffBuilderFactoryConsole.delieverTariffsToConsole(fileName, parcer);

	}

}
