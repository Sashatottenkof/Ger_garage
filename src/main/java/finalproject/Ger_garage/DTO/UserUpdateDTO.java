package finalproject.Ger_garage.DTO;

import finalproject.Ger_garage.Enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class UserUpdateDTO {

    @Size(min = 4, max = 50, message= "Your name should be between 4 and 50 characters")
    @NotBlank(message = "Name is mandatory")
    private String username;

    @NotBlank (message = "Password is mandatory")
    private String password;

    private String confirmPassword;

    @NotBlank (message = "First name is mandatory")
    @Size(max = 50, message= "Your first name should can't be that long")
    private String first_name;

    @Size(max = 50, message= "Your last name should can't be that long")
    private String last_name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @Size( max = 50, message= "Your phone number can't be that long")
    private String phone_number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday is mandatory")
    private LocalDate date_of_birth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
