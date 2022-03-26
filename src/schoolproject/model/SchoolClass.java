package schoolproject.model;

import schoolproject.dao.Identifiable;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class SchoolClass implements Identifiable<Long, String> {
    private Long id;
    private Teacher mainTeacher;
    private HashMap<Long,Subject>subjects=new HashMap<>();
    private HashMap<Long, Student>students=new HashMap<>();
    private HashMap<Long,Lesson> lessons=new HashMap<>();
    private HashMap<Integer,HashMap<Integer,Subject>>program=new HashMap<>();
    public SchoolClass(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return getClass().toString();
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }



    public void setProgram() {
        this.program.put(1,new HashMap<>());
        this.program.put(2,new HashMap<>());
        this.program.put(3,new HashMap<>());
        this.program.put(4,new HashMap<>());
        this.program.put(5,new HashMap<>());
    }

    public HashMap<Long, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<Long, Subject> subjects) {
        this.subjects = subjects;
    }

    public HashMap<Long, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Long, Student> students) {
        this.students = students;
    }

    public HashMap<Long, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(HashMap<Long, Lesson> lessons) {
        this.lessons = lessons;
    }

    public HashMap<Integer, HashMap<Integer, Subject>> getProgram() {
        return program;
    }

    public void setProgram(HashMap<Integer, HashMap<Integer, Subject>> program) {
        this.program = program;
    }

    public SchoolClass(Teacher mainTeacher, HashMap<Long, Subject> subjects, HashMap<Long, Student> students) {
        this.mainTeacher = mainTeacher;
        this.subjects = subjects;
        this.students = students;
        setProgram();
    }
}
