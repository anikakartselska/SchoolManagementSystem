package schoolproject.model.roles;

import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.StringJoiner;

public class HeadTeacher extends User implements UserIdentifiable {
 //this.setRole(Role.HEAD_TEACHER);

    public HeadTeacher() {
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.setRole(Role.HEAD_TEACHER);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HeadTeacher.class.getSimpleName() , super.toString())
                .toString();
    }
}
