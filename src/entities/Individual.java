package entities;

public class Individual extends TaxPlayer{
	private Double healthSpending;
	
	public Individual () {
		super();
	}
	
	public Individual (String name, Double anualIncome, Double healthSpending) {
		super(name, anualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}
	
	@Override
	public Double tax () {
		double tax = 0.0;
		
		if (anualIncome < 20000.0) {
			if (healthSpending > 0.0) {
				tax = (anualIncome * 0.15) - (healthSpending * 0.5);
			} else {
				tax = anualIncome * 0.15;
			}
		} else if (anualIncome >= 20000.0) {
			if (healthSpending > 0.0) {
				tax = (anualIncome * 0.25) - (healthSpending * 0.5);
			} else {
				tax = + anualIncome * 0.25;
			}
		}
		
		return tax;
	}
	
}
