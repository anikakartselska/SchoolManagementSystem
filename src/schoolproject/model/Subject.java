package schoolproject.model;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;
import java.util.StringJoiner;

public class Subject implements Identifiable<Long, String>, IdentifiableAGR<Long, String> {
    private Long id;
    private String subName;
    private Teacher teacher;
    private double averageGrade;
    private SchoolClass schoolClass;
    private int weeklyLessons;
    private HashMap<Student,StudentFeedback> feedbacks=new HashMap<>();

    @Override
    public String toString() {
        return new StringJoiner(", ", Subject.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("subName='" + subName + "'")
                .add("teacher=" + teacher)
                .add("averageGrade=" + averageGrade)
                .add("schoolClass=" + schoolClass)
                .add("weeklyLessons=" + weeklyLessons)
                .add("feedbacks=" + feedbacks)
                .toString();
    }

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

    public HashMap<Student, StudentFeedback> getFeedback() {
        return feedbacks;
    }

    public void setFeedback(HashMap<Student, StudentFeedback> feedbacks) {
        this.feedbacks = feedbacks;
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

    public Subject(Long id, String subName, Teacher teacher, SchoolClass schoolClass, int weeklyLessons) {
        this.id = id;
        this.subName = subName;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.weeklyLessons = weeklyLessons;
    }

    public Subject(Long id, String subName, Teacher teacher, double averageGrade, SchoolClass schoolClass, int weeklyLessons, HashMap<Student, StudentFeedback> feedback) {
        this.id = id;
        this.subName = subName;
        this.teacher = teacher;
        this.averageGrade = averageGrade;
        this.schoolClass = schoolClass;
        this.weeklyLessons = weeklyLessons;
        this.feedbacks = feedback;
    }

    public Subject(Long id, String subName, Teacher teacher, SchoolClass schoolClass, int weeklyLessons, HashMap<Student, StudentFeedback> feedback) {
        this.id = id;
        this.subName = subName;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.weeklyLessons = weeklyLessons;
        this.feedbacks = feedback;
    }
    public Subject() {

    }

    public Subject(String name, Teacher teacher) {
        this.subName = name;
        this.teacher = teacher;
    }

    @Override
    public HashMap<Student, StudentFeedback> getFeedbacks() {
        return feedbacks;
    }

    @Override
    public void setFeedbacks(HashMap<Student, StudentFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
