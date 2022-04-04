package schoolproject.model;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.io.Serializable;
import java.util.HashMap;

public class SchoolClass implements Identifiable<Long, String>, Serializable {
    private Long id;
    private Teacher mainTeacher;
    private HashMap<Long,Subject>subjects=new HashMap<>();
    private HashMap<Long, Student>students=new HashMap<>();
    private HashMap<Integer,HashMap<Integer,Subject>>program=Teacher.setProgram(new HashMap<>());

    public SchoolClass(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }
    public SchoolClass()
     {}

    public SchoolClass(Long id, Teacher mainTeacher, HashMap<Long, Subject> subjects, HashMap<Long, Student> students, HashMap<Integer, HashMap<Integer, Subject>> program) {
        this.id = id;
        this.mainTeacher = mainTeacher;
        this.subjects = subjects;
        this.students = students;
        this.program = program;
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


    public HashMap<Integer, HashMap<Integer, Subject>> getProgram() {
        return program;
    }


    public SchoolClass(Teacher mainTeacher, HashMap<Long, Subject> subjects, HashMap<Long, Student> students) {
        this.mainTeacher = mainTeacher;
        this.subjects = subjects;
        this.students = students;
    }
}
