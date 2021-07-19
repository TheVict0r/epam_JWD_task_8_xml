package by.jwd.pravdivets.task8.xmlmobile.sax;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class TariffSaxConsoleMain {
	public static void main(String[] args) {
		String fileName = FilePaths.fileName;
		
		TariffSaxConsole.parseWithSAX(fileName);
	  
  }
}
