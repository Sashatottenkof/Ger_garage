package finalproject.Ger_garage.Enums;

public enum BookingStatus {
	BOOKED("Booked"),
	IN_SERVICE("In Service"),
	COMPLETED("Completed"),
	COLLECTED("Collected"),
	UNREPAIRABLE("Unrepairable");
	
	private String displayBookingStatus;

	private BookingStatus(String displayBookingStatus) {
		this.displayBookingStatus = displayBookingStatus;
	}

	public String getDisplayBookingStatus() {
		return displayBookingStatus;
	}

	public void setDisplayBookingStatus(String displayBookingStatus) {
		this.displayBookingStatus = displayBookingStatus;
	}
	
}
