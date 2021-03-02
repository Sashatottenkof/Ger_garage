package finalproject.Ger_garage.Models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;


import finalproject.Ger_garage.Enums.CarMake;
import finalproject.Ger_garage.Enums.Engine;
import finalproject.Ger_garage.Enums.typeVehicle;

import java.util.Objects;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicle_id;

	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private typeVehicle type;

	@Column(nullable = false)
	@NotBlank(message = "Licence is mandatory")
	private String licence;

	@Column(nullable = false)

	@Enumerated(EnumType.STRING)
	private Engine engine;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CarMake make;


	@Column(nullable = false)
	@NotNull(message = "Mileage is mandatory")
	@Range(min = 0, message = "Can't be less then 0")
	private Integer mileage;

	
	@Column(nullable = false)
	@NotNull(message = "Age is mandatory")
	@Range(min = 0, message = "Can't be less then 0")
	private Integer age;

	@Column(nullable = false)
	@NotBlank(message = "Model is mandatory")
	private String model;

	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	// for large amount information
	private String other_details;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;


	public Vehicle() {
	}

	public Vehicle(Integer vehicle_id, typeVehicle type, @NotBlank(message = "Licence is mandatory") String licence, Engine engine, CarMake make, @NotNull(message = "Mileage is mandatory") @Range(min = 0, message = "Can't be less then 0") Integer mileage, @NotNull(message = "Age is mandatory") @Range(min = 0, message = "Can't be less then 0") Integer age, @NotBlank(message = "Model is mandatory") String model, String other_details, User user) {
		this.vehicle_id = vehicle_id;
		this.type = type;
		this.licence = licence;
		this.engine = engine;
		this.make = make;
		this.mileage = mileage;
		this.age = age;
		this.model = model;
		this.other_details = other_details;
		this.user = user;
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

	public CarMake getMake() {
		return make;
	}

	public void setMake(CarMake make) {
		this.make = make;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vehicle vehicle = (Vehicle) o;
		return Objects.equals(vehicle_id, vehicle.vehicle_id) &&
				type == vehicle.type &&
				Objects.equals(licence, vehicle.licence) &&
				engine == vehicle.engine &&
				make == vehicle.make &&
				Objects.equals(mileage, vehicle.mileage) &&
				Objects.equals(age, vehicle.age) &&
				Objects.equals(model, vehicle.model) &&
				Objects.equals(other_details, vehicle.other_details) &&
				Objects.equals(user, vehicle.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vehicle_id, type, licence, engine, make, mileage, age, model, other_details, user);
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"vehicle_id=" + vehicle_id +
				", type=" + type +
				", licence='" + licence + '\'' +
				", engine=" + engine +
				", make=" + make +
				", mileage=" + mileage +
				", age=" + age +
				", model='" + model + '\'' +
				", other_details='" + other_details + '\'' +
				", user=" + user +
				'}';
	}
}
