package by.jwd.pravdivets.task8.xmlmobile.validator;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class ValidatorMain {

	public static void main(String[] args) {
		String language = FilePaths.LANGUAGE;
	    String fileName = FilePaths.fileName;
	    String schemaName = FilePaths.shemaName;
	    
	    boolean res = TariffsValidator.isValide(language, fileName, schemaName);
	    System.out.println(res);
	}

}
