package finalproject.Ger_garage.Models;

import java.util.Collection;
import java.util.Date;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import finalproject.Ger_garage.Enums.Gender;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true)
	@Size(min = 5, max = 50, message= "Your name should be between 5 and 50 characters")
	@NotBlank(message = "Name is mandatory")
	private String username;
	
	
	@Column(nullable = false, unique = true)
	@NotBlank (message = "Email is mandatory")
	@Email (message = "Email is invalid")
	private String email;
	
	@Column(nullable = false)
	@NotBlank (message = "Password is mandatory")
	private String password;

	@Column(nullable = false)
	@NotBlank (message = "First name is mandatory")
	private String first_name;

	@Column(nullable = false)
    private String last_name;

	@Enumerated(EnumType.STRING)
	@NotNull
    private Gender gender;
	
	@Size( max = 50, message= "Your phon number can't be that long")
    private String phone_number;
    
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Birthday is mandatory")
    private Date date_of_birth;

    @CreationTimestamp
    private Date create_time;
    @UpdateTimestamp
    private Date update_time;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
    private Collection < Role > roles;
    
//  @OneToMany
//@JoinColumn(name = "VEHICLE_ID")
//  private List <Vehicle> vehicle = new ArrayList<Vehicle>();
  
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String username, String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
	

	public User(Integer id,
			@Size(min = 5, max = 50, message = "Your name should be between 5 and 50 characters") @NotBlank(message = "Name is mandatory") String username,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email is invalid") String email,
			@NotBlank(message = "Password is mandatory") String password,
			@NotBlank(message = "First name is mandatory") String first_name, String last_name, @NotNull Gender gender,
			@Size(max = 50, message = "Your phon number can't be that long") String phone_number,
			@NotNull(message = "Birthday is mandatory") Date date_of_birth, Date create_time, Date update_time,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.create_time = create_time;
		this.update_time = update_time;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", phone_number="
				+ phone_number + ", date_of_birth=" + date_of_birth + ", create_time=" + create_time + ", update_time="
				+ update_time + ", roles=" + roles + "]";
	}


	
	
	
    
//    @OneToMany
// @JoinColumn(name = "VEHICLE_ID")
//    private List <Vehicle> vehicle = new ArrayList<Vehicle>();
    

    


//	public List <Vehicle> getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(List <Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}
}
