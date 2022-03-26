package schoolproject.model.roles;

import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;

public class HeadTeacher extends Teacher{

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, SchoolClass> teachingClasses, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender, teachingClasses, ownClass);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, SchoolClass> teachingClasses) {
        super(firstName, secondName, thirdName, email, username, password, gender, teachingClasses);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Long, SchoolClass> teachingClasses) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday, teachingClasses);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Long, SchoolClass> teachingClasses, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday, teachingClasses, ownClass);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.setRole(Role.HEAD_TEACHER);
    }
}
