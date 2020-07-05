package finalproject.Ger_garage.ServiceRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import finalproject.Ger_garage.Staff.Mechanic;
import finalproject.Ger_garage.UserDetails.User;
import finalproject.Ger_garage.Vehicle.Vehicle;

@Entity
@Table(name = "SERVICE_REQUEST")
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ServiceType type;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ServiceStatus status;
	


	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "VEHICLE_ID",nullable = false)
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name = "MECHANIC_ID")
	private Mechanic mechanic;
	
	@Lob
	private String comment;
	
//    @ManyToOne
//    @JoinColumn(name = "service_id", nullable = false)
//    private Service service;
	public ServiceRequest() {

	}
	

	public ServiceRequest(ServiceType type, ServiceStatus status, User user, Vehicle vehicle, Mechanic mechanic,
		String comment) {
	super();
	this.type = type;
	this.status = status;
	this.user = user;
	this.vehicle = vehicle;
	this.mechanic = mechanic;
	this.comment = comment;
}


	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	public ServiceStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
