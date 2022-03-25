package schoolproject.model;

import schoolproject.dao.Identifiable;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class Subject implements Identifiable<Long, String> {
    private Long id;
    private int subName;
    private Teacher teacher;
    private double averageGrade;
    private HashMap<Long,StudentFeedback.Absence> absences=new HashMap<>();
    private HashMap<Long,StudentFeedback.Remark>remarks= new HashMap<>();
    private HashMap<Long,StudentFeedback.Grade>grades=new HashMap<>();
    private HashMap<Long,Lesson>lessons;

    //array of lessons
  public Subject() {
   }
    public Subject(int name, Teacher teacher, double averageGrade, HashMap<Long, StudentFeedback.Absence> absences, HashMap<Long, StudentFeedback.Remark> remarks, HashMap<Long, StudentFeedback.Grade> grades) {
        this.subName = name;
        this.teacher = teacher;
        this.averageGrade = averageGrade;
        this.absences = absences;
        this.remarks = remarks;
        this.grades = grades;
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

    public int getSubName() {
        return subName;
    }

    public void setSubName(int name) {
        this.subName = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public HashMap<Long, StudentFeedback.Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(HashMap<Long, StudentFeedback.Absence> absences) {
        this.absences = absences;
    }

    public HashMap<Long, StudentFeedback.Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(HashMap<Long, StudentFeedback.Remark> remarks) {
        this.remarks = remarks;
    }

    public HashMap<Long, StudentFeedback.Grade> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<Long, StudentFeedback.Grade> grades) {
        this.grades = grades;
    }

    public Subject(int name, Teacher teacher) {
        this.subName = name;
        this.teacher = teacher;
    }
}
