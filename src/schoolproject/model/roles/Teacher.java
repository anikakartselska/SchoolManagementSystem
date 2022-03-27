package schoolproject.model.roles;

import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;
import java.util.StringJoiner;

public class Teacher extends User implements UserIdentifiable {

    private HashMap<Long, SchoolClass>teachingClasses=new HashMap<>();
   private SchoolClass ownClass;
    private HashMap<Integer,HashMap<Integer,Subject>>program=new HashMap<Integer,HashMap<Integer, Subject>>();

    @Override
    public String toString() {
        return new StringJoiner(", ", Teacher.class.getSimpleName() + super.toString(),"")
                .add("teachingClasses=" + teachingClasses)
                .add("ownClass=" + ownClass)
                .add("program=" + program)
                .toString();
    }

    public HashMap<Long, SchoolClass> getTeachingClasses() {
        return teachingClasses;
    }

    public void setTeachingClasses(HashMap<Long, SchoolClass> teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public SchoolClass getOwnClass() {
        return ownClass;
    }

    public void setOwnClass(SchoolClass ownClass) {
        this.ownClass = ownClass;
    }

    public HashMap<Integer, HashMap<Integer, Subject>> getProgram() {
        return program;
    }

    public void setProgram() {

        this.program.put(1,new HashMap<>());
        this.program.put(2,new HashMap<>());
        this.program.put(3,new HashMap<>());
        this.program.put(4,new HashMap<>());
        this.program.put(5,new HashMap<>());
    }

public Teacher()
{
    setProgram();
}

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, SchoolClass> teachingClasses, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        this.setRole(Role.TEACHER);
        setProgram();
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, SchoolClass> teachingClasses) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingClasses = teachingClasses;
        this.setRole(Role.TEACHER);
        setProgram();
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  String phoneNumber, String address, Date birthday, HashMap<Long, SchoolClass> teachingClasses) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        setProgram();
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  String phoneNumber, String address, Date birthday, HashMap<Long, SchoolClass> teachingClasses, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingClasses = teachingClasses;
        this.ownClass = ownClass;
        setProgram();
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
