package finalproject.Ger_garage.Enums;

public enum ServiceType {
	ANNUAL_SERVICE("Annual Service"),
	MAJOR_SERVICE("Major Service"),
	REPAIR("Repair"),
	MAJOR_REPAIR("Major Repair");
	
	
	private String displayServiceType;

	private ServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
	}

	public String getDisplayServiceType() {
		return displayServiceType;
	}

	public void setDisplayServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
	}
	
	
}
