package finalproject.Ger_garage.Enums;

public enum typeVehicle {

	SEDAN("Sedan"),
	ROADSTER("Roadster"),
	MINIVAN("Minivan"),
	COUPE("Coupe"),
	LIMOUSINE("Limousine");
	
	
	private String displayType;

	private typeVehicle(String displayType) {
		this.displayType = displayType;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	
}
