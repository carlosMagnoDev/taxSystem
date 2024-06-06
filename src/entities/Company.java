package entities;

public class Company extends TaxPlayer{
	private Integer employee;
	
	public Company () {
		super();
	}
	
	public Company (String name, Double annualIncome, Integer employee) {
		super (name, annualIncome);
		this.employee = employee;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
	
	@Override
	public Double tax () {
		Double tax = 0.0;
		
		if (employee < 10) {
			tax = anualIncome * 0.16;
		} else if (employee >= 10) {
			tax = anualIncome * 0.14;
		}
		
		return tax;
	}
	
	
}
