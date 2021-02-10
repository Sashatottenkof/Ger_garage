package finalproject.Ger_garage.Enums;

public enum ServiceType {
	ANNUAL_SERVICE("Annual Service", 200.00),
	MAJOR_SERVICE("Major Service", 300.00),
	REPAIR("Repair", 150.00),
	MAJOR_REPAIR("Major Repair", 400.00);
	
	
	private String type;
	private double price;

	private ServiceType(String type) {
		this.type = type;
	}

	ServiceType(String  type, double price) {
		this.type =  type;
		this.price = price;
	}

	public String getType() {
		return  type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
