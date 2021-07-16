package by.jwd.pravdivets.task8.xmlmobile.errorhandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
public class TariffsErrorHandler implements ErrorHandler {
    private static Logger logger = LogManager.getLogger();
    
    public void warning(SAXParseException e) throws SAXException{
        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
        throw new SAXException(e); //добавил здесь и далее иначе TariffValidator не видит ошибки 
    }
    public void error(SAXParseException e) throws SAXException{
        logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
        throw new SAXException(e);
    }
    public void fatalError(SAXParseException e) throws SAXException{
        logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
        throw new SAXException(e);
    }
    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}