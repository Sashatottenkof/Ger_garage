package finalproject.Ger_garage.Enums;

public enum CarMake {

	MERCEDES("Mercedes"),
	BMW("BMW");
	
	
	private String displayMake;

	private CarMake(String displayMake) {
		this.displayMake = displayMake;
	}

	public String getDisplayMake() {
		return displayMake;
	}

	public void setDisplayMake(String displayMake) {
		this.displayMake = displayMake;
	}
	
}
