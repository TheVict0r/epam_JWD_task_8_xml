package by.jwd.pravdivets.task8.xmlmobile.factory;

import java.util.ArrayList;
import java.util.List;

import by.jwd.pravdivets.task8.xmlmobile.entity.Tariff;

public abstract class AbstractTariffsBuilder {
	// protected так как к нему часто обращаются из подкласса
	protected List<Tariff> tariffs;

	public AbstractTariffsBuilder() {
		tariffs = new ArrayList<Tariff>();
	}

	public AbstractTariffsBuilder(List<Tariff> tariffs) {
			this.tariffs = tariffs;
		}

	public List<Tariff> getTariffs() {
		return tariffs;
	}

	abstract public void buildListTariffs(String fileName);
}