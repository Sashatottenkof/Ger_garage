package finalproject.Ger_garage.Enums;

public enum ServiceType {
	ANNUAL_SERVICE("Annual Service", 200.00),
	MAJOR_SERVICE("Major Service", 300.00),
	REPAIR("Repair", 150.00),
	MAJOR_REPAIR("Major Repair", 400.00);
	
	
	private String displayServiceType;
	private double price;

	private ServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
	}

	ServiceType(String displayServiceType, double price) {
		this.displayServiceType = displayServiceType;
		this.price = price;
	}

	public String getDisplayServiceType() {
		return displayServiceType;
	}

	public void setDisplayServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
