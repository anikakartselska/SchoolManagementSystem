package schoolproject.model;

import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;
import java.util.StringJoiner;

public class Subject implements IdentifiableAGR<Long, String> {
    private Long id;
    private String subName;
    private Teacher teacher;
    private double averageGrade;
    private SchoolClass schoolClass;
    private int weeklyLessons;
    private HashMap<Long,StudentFeedback.Absence> absences=new HashMap<>();
    private HashMap<Long,StudentFeedback.Remark>remarks= new HashMap<>();
    private HashMap<Long,StudentFeedback.Grade>grades=new HashMap<>();
    private HashMap<Long,Lesson>lessons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        return getId().equals(subject.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Subject.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("subName='" + subName + "'")
                .add("teacher=" + teacher)
                .add("averageGrade=" + averageGrade)
                .add("schoolClass=" + schoolClass)
                .add("weeklyLessons=" + weeklyLessons)
                .add("absences=" + absences)
                .add("remarks=" + remarks)
                .add("grades=" + grades)
                .add("lessons=" + lessons)
                .toString();
    }

    public int getWeeklyLessons() {
        return weeklyLessons;
    }

    public void setWeeklyLessons(int weeklyLessons) {
        this.weeklyLessons = weeklyLessons;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }



    //array of lessons
  public Subject() {
   }
    public Subject(String name, Teacher teacher,SchoolClass schoolClass,int weeklyLessons, double averageGrade, HashMap<Long, StudentFeedback.Absence> absences, HashMap<Long, StudentFeedback.Remark> remarks, HashMap<Long, StudentFeedback.Grade> grades) {
        this.subName = name;
        this.teacher = teacher;
        this.averageGrade = averageGrade;
        this.absences = absences;
        this.remarks = remarks;
        this.grades = grades;
        this.schoolClass=schoolClass;
        this.weeklyLessons=weeklyLessons;
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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public HashMap<Long, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(HashMap<Long, Lesson> lessons) {
        this.lessons = lessons;
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

    public Subject(String name, Teacher teacher) {
        this.subName = name;
        this.teacher = teacher;
    }
}
