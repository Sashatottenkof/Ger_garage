package finalproject.Ger_garage.Enums;

public enum CarMake {

	MERCEDES("Mercedes"),
	BMW("BMW"),
	AUDI("Audi"),
	OPEL("Opel"),
	PORCHE("Porsche"),
	SMART("Smart"),
	VOLKSWAGEN("Volkswagen"),
	JAGUAR("Jaguar"),
	HONDA("Honda"),
	HYNDAI("Hyundai"),
	TOYOTA("Toyota"),
	DATSUN("Datsun"),
	INFINITI("Infiniti"),
	ISUZU("Isuzu"),
	LEXUS("Lexus"),
	MAZDA("Mazda"),
	MITSIBISHI("Mitsubishi"),
	MITSUOKA("Mitsuoka"),
	NISSAN("Nissan"),
	SUBARU("Subaru"),
	SUZUKI("Suzuki"),
	YAMAHA("Yamaha Motor"),
	CUPRA("Cupra"),
	HURTAN("Hurtan"),
	SEAT("SEAT"),
	MINI("Mini"),
	LAND_ROVER("Land Rover "),
	JEEP("Jeep"),
	FORD("Ford"),
	CHEVROLET("Chevrolet"),
	OTHER("Other");
	
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
