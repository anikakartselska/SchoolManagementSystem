package schoolproject.model.roles;

import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;

public class HeadTeacher extends Teacher{

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, teachingClasses, ownClass, program);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, teachingClasses, program);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday, teachingClasses, program);
        this.setRole(Role.HEAD_TEACHER);
    }

    public HeadTeacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday, teachingClasses, ownClass, program);
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
