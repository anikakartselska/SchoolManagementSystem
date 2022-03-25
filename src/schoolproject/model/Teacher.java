package schoolproject.model;

import java.util.Date;
import java.util.HashMap;

public class Teacher extends User{
   private HashMap<Integer,SchoolClass>teachingClasses=new HashMap<>();
   private SchoolClass ownClass;
    private HashMap<String,HashMap<Integer,Subject>>program=new HashMap<>();

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, role);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        this.program = program;
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, role);
        this.teachingClasses = teachingClasses;
        this.program = program;
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role, String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, role, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        this.program = program;
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role, String phoneNumber, String address, Date birthday, HashMap<Integer, SchoolClass> teachingClasses, SchoolClass ownClass, HashMap<String, HashMap<Integer, Subject>> program) {
        super(firstName, secondName, thirdName, email, username, password, gender, role, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        this.program = program;
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role) {
        super(firstName, secondName, thirdName, email, username, password, gender, role);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, Role role, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, role, phoneNumber, address, birthday);
    }
}
