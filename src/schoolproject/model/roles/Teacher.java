package schoolproject.model.roles;

import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;

public class Teacher extends User{
   private HashMap<Integer, SchoolClass>teachingClasses=new HashMap<>();
   private SchoolClass ownClass;
    private HashMap<String,HashMap<Integer, Subject>>program=new HashMap<>();


    public HashMap<Integer, SchoolClass> getTeachingClasses() {
        return teachingClasses;
    }

    public void setTeachingClasses(HashMap<Integer, SchoolClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public SchoolClass getOwnClass() {
        return ownClass;
    }

    public void setOwnClass(SchoolClass ownClass) {
        this.ownClass = ownClass;
    }

    public HashMap<String, HashMap<Integer, Subject>> getProgram() {
        return program;
    }

    public void setProgram(HashMap<String, HashMap<Integer, Subject>> program) {
        this.program = program;
    }



    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        this.program = program;
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingClasses = teachingClasses;
        this.program = program;
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        this.program = program;
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        this.program = program;
        this.setRole(Role.TEACHER);

    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender,phoneNumber, address, birthday);
        this.setRole(Role.TEACHER);
    }
}
