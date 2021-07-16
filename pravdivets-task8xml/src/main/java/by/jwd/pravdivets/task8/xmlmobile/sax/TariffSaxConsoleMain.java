package by.jwd.pravdivets.task8.xmlmobile.sax;

import by.jwd.pravdivets.task8.xmlmobile.constants.Constants;

public class TariffSaxConsoleMain {
	public static void main(String[] args) {
		String fileName = Constants.FILE_NAME;
		
		TariffSaxConsole.parseWithSAX(fileName);
	  
  }
}
