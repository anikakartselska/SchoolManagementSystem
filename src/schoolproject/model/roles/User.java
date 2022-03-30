package schoolproject.model.roles;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;
import schoolproject.model.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

public class User implements Identifiable<Long, String>, UserIdentifiable {
    private long id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String email;
    private String username;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private String address;
    private LocalDate birthday;
    private Status status=Status.PENDING;
    public Role getRole() {
        return role;
    }
    public User() {
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private Role role=Role.USER;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return new StringJoiner("| ",  "[", "]\n")
                .add("Id=" + id)
                .add(  firstName+" "+secondName+" "+thirdName )
                .add("email='" + email + "'")
                .add("username='" + username + "'")
                .add("gender=" + gender)
                .add("phoneNumber='" + phoneNumber + "'")
                .add("address='" + address + "'")
                .add("birthday=" + birthday)
                .add("status=" + status)
                .toString();
    }


    public User(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;

    }

    public User( String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, LocalDate birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return firstName+" "+secondName+" "+thirdName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


}
