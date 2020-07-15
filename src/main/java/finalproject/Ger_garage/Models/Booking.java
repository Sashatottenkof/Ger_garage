package finalproject.Ger_garage.Models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import finalproject.Ger_garage.Enums.BookingStatus;

import finalproject.Ger_garage.Enums.ServiceType;

@Entity
@Table(name = "BOOKING_REQUEST")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ServiceType type;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BookingStatus status;
	


	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name = "MECHANIC_ID")
	private Mechanic mechanic;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Choose your day of service")
	private Date date;
	
	@Lob
	private String comment;
	@Transient
	Integer vehicleId;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer id, ServiceType type, BookingStatus status, User user, Vehicle vehicle, Mechanic mechanic,
			@NotNull(message = "Choose your day of service") Date date, String comment,Integer vehicleId) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
		this.user = user;
		this.vehicle = vehicle;
		this.mechanic = mechanic;
		this.date = date;
		this.comment = comment;
		this.vehicleId = vehicleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Booking booking = (Booking) o;
		return Objects.equals(id, booking.id) &&
				type == booking.type &&
				status == booking.status &&
				Objects.equals(user, booking.user) &&
				Objects.equals(vehicle, booking.vehicle) &&
				Objects.equals(mechanic, booking.mechanic) &&
				Objects.equals(date, booking.date) &&
				Objects.equals(comment, booking.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, status, user, vehicle, mechanic, date, comment);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", type=" + type +
				", status=" + status +
				", user=" + user +
				", vehicle=" + vehicle +
				", mechanic=" + mechanic +
				", date=" + date +
				", comment='" + comment + '\'' +
				'}';
	}
}