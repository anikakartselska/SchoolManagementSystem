package schoolproject.model.roles;

import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Teacher extends User implements UserIdentifiable {
    private HashMap<Long, Subject>teachingSubjects=new HashMap<>();
   private SchoolClass ownClass;
    private final HashMap<Integer,HashMap<Integer,Subject>>program=setProgram(new HashMap<>());

    @Override
    public String toString() {
        return new StringJoiner("| ", Teacher.class.getSimpleName() + super.toString(),"")
                .toString();
    }
    public String additionalInfo(){
        return new StringJoiner("| ", Teacher.class.getSimpleName(),"")
                .add("teachingClasses=" + teachingSubjects)
                .add("ownClass=" + ownClass)
                .add("program:\n" + mapToString(program))
                .toString();
    }
    public static <K, V> String mapToString(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining("\n ", "{", "}"));
    }

    public HashMap<Long, Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

    public void setTeachingSubjects(HashMap<Long, Subject> teachingSubjects) {
        this.teachingSubjects = teachingSubjects;
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

    public static HashMap<Integer,HashMap<Integer,Subject>> setProgram(HashMap<Integer,HashMap<Integer,Subject>> program) {

        program.put(1,new HashMap<>());
        program.put(2,new HashMap<>());
        program.put(3,new HashMap<>());
        program.put(4,new HashMap<>());
        program.put(5,new HashMap<>());
        return program;
    }

public Teacher()
{

}

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, Subject>teachingSubjects, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingSubjects = teachingSubjects;
        this.ownClass = ownClass;
        this.setRole(Role.TEACHER);

    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, Subject>teachingSubjects) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.teachingSubjects = teachingSubjects;
        this.setRole(Role.TEACHER);

    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, LocalDate birthday, HashMap<Long, Subject>teachingSubjects) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingSubjects = teachingSubjects;
        this.setRole(Role.TEACHER);
    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  String phoneNumber, String address, LocalDate birthday, HashMap<Long, Subject>teachingSubjects, SchoolClass ownClass) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.teachingSubjects = teachingSubjects;
        this.ownClass = ownClass;
        this.setRole(Role.TEACHER);



    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.TEACHER);

    }

    public Teacher(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, LocalDate birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender,phoneNumber, address, birthday);
        this.setRole(Role.TEACHER);

    }
}
