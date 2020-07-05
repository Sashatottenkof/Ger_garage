package finalproject.Ger_garage.Vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import finalproject.Ger_garage.ServiceRequest.ServiceRequest;
import finalproject.Ger_garage.UserDetails.User;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicle_id;

	@JsonProperty
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private typeVehicle type;

	@Column(nullable = false)
	@JsonProperty
	private String licence;

	@Column(nullable = false)
	@JsonProperty
	@Enumerated(EnumType.STRING)
	private Engine engine;

	@Column(nullable = false)
	private String make;

	@JsonProperty
	@Column(nullable = false)
	private int kilometers;

	@JsonProperty
	@Column(nullable = false)
	private int age;

	@Lob
	// for large amount information
	@JsonProperty
	private String other_details;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public Vehicle() {

	}

	public Vehicle(typeVehicle type, String licence, String make, int kilometers, int age, String other_details) {
		super();

		this.type = type;
		this.licence = licence;
		this.make = make;
		this.kilometers = kilometers;
		this.age = age;
		this.other_details = other_details;
	}

	public Integer getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public typeVehicle getType() {
		return type;
	}

	public void setType(typeVehicle type) {
		this.type = type;
	}

	public String getLicencePlate() {
		return licence;
	}

	public void setLicencePlate(String licencePlate) {
		this.licence = licencePlate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", type=" + type + ", licence=" + licence + ", engine=" + engine
				+ ", make=" + make + ", kilometers=" + kilometers + ", age=" + age + ", other_details=" + other_details
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + kilometers;
		result = prime * result + ((licence == null) ? 0 : licence.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((other_details == null) ? 0 : other_details.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vehicle_id == null) ? 0 : vehicle_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (age != other.age)
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (kilometers != other.kilometers)
			return false;
		if (licence == null) {
			if (other.licence != null)
				return false;
		} else if (!licence.equals(other.licence))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (other_details == null) {
			if (other.other_details != null)
				return false;
		} else if (!other_details.equals(other.other_details))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vehicle_id == null) {
			if (other.vehicle_id != null)
				return false;
		} else if (!vehicle_id.equals(other.vehicle_id))
			return false;
		return true;
	}

}
