package schoolproject.model.roles;

import schoolproject.dao.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;

public class SchoolAdmin extends User implements UserIdentifiable {

    public SchoolAdmin(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.SCHOOL_ADMIN);
    }

    public SchoolAdmin(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.setRole(Role.SCHOOL_ADMIN);
    }
}
