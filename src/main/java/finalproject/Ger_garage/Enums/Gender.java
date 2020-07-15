package finalproject.Ger_garage.Enums;

public enum Gender {
	MALE("Male"),
	FEMALE ("Female");

	
	private String displayGender;

	private Gender(String displayGender) {
		this.displayGender = displayGender;
	}

	public String getDisplayGender() {
		return displayGender;
	}

	public void setDisplayGender(String displayGender) {
		this.displayGender = displayGender;
	}




	
}

