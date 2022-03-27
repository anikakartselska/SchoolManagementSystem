package schoolproject.model.roles;

import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.time.LocalDate;
import java.util.Date;
import java.util.StringJoiner;

public class SchoolAdmin extends User implements UserIdentifiable {

    public SchoolAdmin(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.SCHOOL_ADMIN);
    }

    public SchoolAdmin(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, LocalDate birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.setRole(Role.SCHOOL_ADMIN);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SchoolAdmin.class.getSimpleName() + super.toString(),"")
                .toString();
    }
}
