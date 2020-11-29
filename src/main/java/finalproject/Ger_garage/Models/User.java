package finalproject.Ger_garage.Models;

import java.time.LocalDate;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "USER_DETAILS")

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 50, message = "Your name should be between 4 and 50 characters")
    @NotBlank(message = "Name is mandatory")
    private String username;


    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(nullable = false)
    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "Your first name should can't be that long")
    private String first_name;

    @Column(nullable = false)
    @Size(max = 50, message = "Your last name should can't be that long")
    private String last_name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @Size(max = 50, message = "Your phone number can't be that long")
    private String phone_number;

    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday is mandatory")
    private LocalDate date_of_birth;

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
    private Collection<Role> roles;

    private boolean enabled;

//  @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
////@JoinColumn(name = "VEHICLE_ID")
//  private List<Vehicle> vehicle = new ArrayList<Vehicle>();

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(Boolean enabled) {
        this.enabled = false;
    }

    public User(Integer id, @Size(min = 4, max = 50, message = "Your name should be between 4 and 50 characters") @NotBlank(message = "Name is mandatory") String username, @NotBlank(message = "Email is mandatory") @Email(message = "Email is invalid") String email, @NotBlank(message = "Password is mandatory") String password, @NotBlank(message = "First name is mandatory") @Size(max = 50, message = "Your first name should can't be that long") String first_name, @Size(max = 50, message = "Your last name should can't be that long") String last_name, @NotNull Gender gender, @Size(max = 50, message = "Your phone number can't be that long") String phone_number, @NotNull(message = "Birthday is mandatory") LocalDate date_of_birth) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
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

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
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

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userRoles = getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
                if(enabled == true) {
            return  true;
        }
        else return false;
    }
}
