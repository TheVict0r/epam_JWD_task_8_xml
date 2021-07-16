package by.jwd.pravdivets.task8.xmlmobile.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Tariff implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String operator;
	private String status;
	private Date releaseDate;  
	private int regularPayment;
	private int connectionFee;
	private String billingModel; 
	
	private int callsWithinNetwork;
	private int callsOtherNetworks;
	private int callLandlines;
	private int callAbroad;
	private int callVideo;
	
	private int favouriteNumbers;
	private int sms;
	private int mms;
	
	public Tariff() {
		
	}

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	//надеюсь, это не сильно противоречит концепции JavaBeans. 
	//Сперва я поместил formatter в метод toString, но потом переместил сюда "на перспективу", 
	//т.к. может понадобиться, если захочу доработать класс 
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOperator() {
		return operator;
	}

	public String getStatus() {
		return status;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public int getRegularPayment() {
		return regularPayment;
	}

	public int getConnectionFee() {
		return connectionFee;
	}

	public String getBillingModel() {
		return billingModel;
	}

	public int getCallsWithinNetwork() {
		return callsWithinNetwork;
	}

	public int getCallsOtherNetworks() {
		return callsOtherNetworks;
	}

	public int getCallLandlines() {
		return callLandlines;
	}

	public int getCallAbroad() {
		return callAbroad;
	}

	public int getCallVideo() {
		return callVideo;
	}

	public int getFavouriteNumbers() {
		return favouriteNumbers;
	}

	public int getSms() {
		return sms;
	}

	public int getMms() {
		return mms;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReleaseDate(Date date) {
		this.releaseDate = date;
	}

	public void setRegularPayment(int regularPayment) {
		this.regularPayment = regularPayment;
	}

	public void setConnectionFee(int connectionFee) {
		this.connectionFee = connectionFee;
	}

	public void setBillingModel(String billingModel) {
		this.billingModel = billingModel;
	}

	public void setCallsWithinNetwork(int callsWithinNetwork) {
		this.callsWithinNetwork = callsWithinNetwork;
	}

	public void setCallsOtherNetworks(int callsOtherNetworks) {
		this.callsOtherNetworks = callsOtherNetworks;
	}

	public void setCallLandlines(int callLandlines) {
		this.callLandlines = callLandlines;
	}

	public void setCallAbroad(int callAbroad) {
		this.callAbroad = callAbroad;
	}

	public void setCallVideo(int callVideo) {
		this.callVideo = callVideo;
	}

	public void setFavouriteNumbers(int favouriteNumbers) {
		this.favouriteNumbers = favouriteNumbers;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public void setMms(int mms) {
		this.mms = mms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billingModel == null) ? 0 : billingModel.hashCode());
		result = prime * result + callAbroad;
		result = prime * result + callLandlines;
		result = prime * result + callVideo;
		result = prime * result + callsOtherNetworks;
		result = prime * result + callsWithinNetwork;
		result = prime * result + connectionFee;
		result = prime * result + favouriteNumbers;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mms;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + regularPayment;
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + sms;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tariff other = (Tariff) obj;
		if (billingModel == null) {
			if (other.billingModel != null)
				return false;
		} else if (!billingModel.equals(other.billingModel))
			return false;
		if (callAbroad != other.callAbroad)
			return false;
		if (callLandlines != other.callLandlines)
			return false;
		if (callVideo != other.callVideo)
			return false;
		if (callsOtherNetworks != other.callsOtherNetworks)
			return false;
		if (callsWithinNetwork != other.callsWithinNetwork)
			return false;
		if (connectionFee != other.connectionFee)
			return false;
		if (favouriteNumbers != other.favouriteNumbers)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mms != other.mms)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (regularPayment != other.regularPayment)
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (sms != other.sms)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {//немного отформатировал возвращаемое значение
							 //используется преимущественно в ходе тестирования
							//за вывод на консоль в виде таблицы отвечает класс 
						   //  by.jwd.pravdivets.task8.xmlmobile.service.TariffsListPrinter
		
		return  "\n==========================\n" +
				"\n" + getClass().getSimpleName() + 
				"\n ID - " + id + 
				"\n Tariff name - " + name + 
				"\n Mobile operator - " + operator + 
				"\n Tariff status - " + status + 
				"\n Release date - " + formatter.format(releaseDate) + 
				"\n Regular payment - " + regularPayment + 
				"\n Connection fee - " + connectionFee + 
				"\n Billing model - " + billingModel + 
				"\n   CALLS:" +
				"\n Within network - " + callsWithinNetwork + 
				"\n Other networks - " + callsOtherNetworks + 
				"\n Landlines - " + callLandlines + 
				"\n Abroad - " + callAbroad + 
				"\n Videocall - " + callVideo + 
				"\n Favourite numbers - " + favouriteNumbers + 
				"\n SMS - " + sms + 
				"\n MMS - " + mms + 
				"\n";
	}
	
}
