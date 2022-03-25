package schoolproject.model.roles;

import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;

public class Student extends User{

    private int numberInClass;
    private HashMap<Integer, Parent>parents=new HashMap<>();
    private SchoolClass schoolClass;
    private HashMap<Long, StudentFeedback.Absence> absences=new HashMap<>();
    private HashMap<Long,StudentFeedback.Remark>remarks= new HashMap<>();
    private HashMap<Long,StudentFeedback.Grade>grades=new HashMap<>();
    private double averageGrade;
    private HashMap<Integer, Subject>subjects=new HashMap<>();

    public Student() {
    }

    public int getNumberInClass() {
        return numberInClass;
    }

    public void setNumberInClass(int numberInClass) {
        this.numberInClass = numberInClass;
    }

    public Student(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, int numberInClass, HashMap<Integer, Parent> parents, SchoolClass schoolClass) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.numberInClass = numberInClass;
        this.parents = parents;
        this.schoolClass = schoolClass;
        this.setRole(Role.STUDENT);
    }

    public Student(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, int numberInClass, HashMap<Integer, Parent> parents, SchoolClass schoolClass) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.numberInClass = numberInClass;
        this.parents = parents;
        this.schoolClass = schoolClass;
        this.setRole(Role.STUDENT);
    }

    public HashMap<Integer, Parent> getParents() {
        return parents;
    }

    public void setParents(HashMap<Integer, Parent> parents) {
        this.parents = parents;
    }


    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
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

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public HashMap<Integer, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<Integer, Subject> subjects) {
        this.subjects = subjects;
    }

    public Student(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.STUDENT);
    }

    public Student(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.setRole(Role.STUDENT);
    }


}
