package entities2;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer() {

	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {
		double salaryMes;
		salaryMes = salaryIncome / 12;
		if (salaryMes < 3000.0) {
			return salaryIncome;
		} else if (salaryMes >= 3000.0 && salaryMes <= 5000.0) {
			return (10.0 / 100.0) * salaryIncome;
		} else if (salaryMes > 5000.0) {
			return (20.0 / 100.0) * salaryIncome;
		}
		return salaryIncome;
	}

	public Double serviceTax() {
		return (15.0 / 100.0) * servicesIncome;
	}

	public Double capitalTax() {
		return (20.0 / 100.0) * capitalIncome;
	}

	public Double grossTax() {
		return serviceTax() + capitalTax() + salaryTax();
	}

	public Double taxRebate() {
		double reducaoImposto;
		double medicalExpenses;
		reducaoImposto = (30.0 / 100.0) * grossTax();
		medicalExpenses = healthSpending + educationSpending;
		if (medicalExpenses > reducaoImposto) {
			return reducaoImposto;
		} else {
			return medicalExpenses;
		}
	}

	public Double netTax() {
		double reducaoImposto;
		double medicalExpenses;
		reducaoImposto = (30.0 / 100.0) * grossTax();
		medicalExpenses = healthSpending + educationSpending;
		if (medicalExpenses > reducaoImposto) {
			return grossTax() - reducaoImposto;
		} else {
			return grossTax() - medicalExpenses;
		}
	}

}
