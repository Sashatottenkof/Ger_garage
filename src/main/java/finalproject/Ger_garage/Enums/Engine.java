package finalproject.Ger_garage.Enums;

public enum Engine {
	DIESEL("Diesel"),
	PETROL("Petrol"),
	HYBRID("Hybrid"),
	ELECTRIC("Electric");
	
	
	private String displayEngine;

	private Engine(String displayEngine) {
		this.displayEngine = displayEngine;
	}

	public String getDisplayEngine() {
		return displayEngine;
	}

	public void setDisplayEngine(String displayEngine) {
		this.displayEngine = displayEngine;
	}


	
	
}
