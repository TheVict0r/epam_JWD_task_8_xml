package by.jwd.pravdivets.task8.xmlmobile.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;

/*
 * Можно печатать и через toString класса Tariff, 
 * но решил сделать ещё и в виде форматированной таблицы
 */

public class TariffsListPrinter {

	public static void printTariffsFromList(List<Tariff> tariffs) {
		
		for( Tariff tariff: tariffs ) {
			
			String id = tariff.getId();
			String name = tariff.getName();
			String operator = tariff.getOperator();
			String status = tariff.getStatus();
			Date releaseDate = tariff.getReleaseDate();  
			int regularPayment = tariff.getRegularPayment();
			int connectionFee = tariff.getConnectionFee();
			String billingModel = tariff.getBillingModel(); 
			
			int callsWithinNetwork = tariff.getCallsWithinNetwork();
			int callsOtherNetworks = tariff.getCallsOtherNetworks();
			int callLandlines = tariff.getCallLandlines();
			int callAbroad = tariff.getCallAbroad();
			int callVideo = tariff.getCallVideo();
			
			int favouriteNumbers = tariff.getFavouriteNumbers();
			int sms = tariff.getSms();
			int mms = tariff.getMms();			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
						
		   System.out.println("TARIFF");
		   System.out.println("-------------------------------");
			System.out.printf(" ID                |%10s\n", id);
			System.out.printf(" Name              |%10s\n", name);
			System.out.printf(" Operator          |%10s\n", operator);
			System.out.printf(" Status            |%10s\n", status);
			System.out.printf(" Release date      |%10s\n", formatter.format(releaseDate));
			System.out.printf(" Regular payment   |%10s\n", regularPayment);
			System.out.printf(" Connection fee    |%10s\n", connectionFee);
			System.out.printf(" Billing model     |%10s\n", billingModel);
		   System.out.println("   Calls:          |");
			System.out.printf(" Within network    |%10s\n", callsWithinNetwork);
			System.out.printf(" Other networks    |%10s\n", callsOtherNetworks);
			System.out.printf(" Landlines         |%10s\n", callLandlines);
			System.out.printf(" Abroad            |%10s\n", callAbroad);
			System.out.printf(" Videocalls        |%10s\n", callVideo);
			System.out.printf(" Favourite numbers |%10s\n", favouriteNumbers);
		   System.out.println("   Messages:       |");
			System.out.printf(" SMS               |%10s\n", sms);
			System.out.printf(" MMS               |%10s\n", mms);
		   System.out.println("===============================\n");

			
			
		}
		
		
	}
	
}
