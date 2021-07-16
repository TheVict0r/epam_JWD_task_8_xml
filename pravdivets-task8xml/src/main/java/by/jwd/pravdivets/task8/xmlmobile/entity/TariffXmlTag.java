package by.jwd.pravdivets.task8.xmlmobile.entity;

public enum TariffXmlTag {

	TARIFFS("tariffs"),
	TARIFF("tariff"),
	ID("ID"),
	NAME("name"),
	OPERATOR("operator"),
	STATUS("status"),
	RELEASE_DATE("release_date"),
	REGULAR_PAYMENT("regular_payment"),
	CONNECTION_FEE("connection_fee"),
	CALLS("calls"),
	BILLING_MODEL("billing_model"),
	WITHIN_NETWORK("within_network"),
	OTHER_NETWORKS("other_networks"),
	LANDLINES("landlines"),
	ABROAD("abroad"),
	VIDEOCALL("videocall"),
	FAVOURITE_NUMBERS("favourite_numbers"),
	MESSAGES("messages"),
	SMS("SMS"),
	MMS("MMS");
	
	private String value;

	TariffXmlTag(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}