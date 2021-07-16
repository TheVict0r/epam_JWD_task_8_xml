package by.jwd.pravdivets.task8.xmlmobile.validator;

import by.jwd.pravdivets.task8.xmlmobile.constants.Constants;

public class ValidatorMain {

	public static void main(String[] args) {
		String language = Constants.LANGUAGE;
	    String fileName = Constants.FILE_NAME;
	    String schemaName = Constants.SHEMA_NAME;
	    
	    boolean res = TariffsValidator.isValide(language, fileName, schemaName);
	    System.out.println(res);
	}

}
