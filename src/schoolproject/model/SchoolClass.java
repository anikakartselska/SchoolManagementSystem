package schoolproject.model;

import schoolproject.dao.Identifiable;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class SchoolClass implements Identifiable<Long, String> {
    private Long id;
    private Teacher mainTeacher;
    private HashMap<Integer,Subject>subjects=new HashMap<>();
    private HashMap<Integer, Student>students=new HashMap<>();
    private HashMap<String,HashMap<Integer,Subject>>program=new HashMap<>();
    private HashMap<Integer,Lesson> lessons=new HashMap<>();

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

    public HashMap<Integer, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<Integer, Subject> subjects) {
        this.subjects = subjects;
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }

    public HashMap<String, HashMap<Integer, Subject>> getProgram() {
        return program;
    }

    public void setProgram(HashMap<String, HashMap<Integer, Subject>> program) {
        this.program = program;
    }

    public HashMap<Integer, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(HashMap<Integer, Lesson> lessons) {
        this.lessons = lessons;
    }

    public SchoolClass(Teacher mainTeacher, HashMap<Integer, Subject> subjects, HashMap<Integer, Student> students, HashMap<String, HashMap<Integer, Subject>> program) {
        this.mainTeacher = mainTeacher;
        this.subjects = subjects;
        this.students = students;
        this.program = program;
    }
}
