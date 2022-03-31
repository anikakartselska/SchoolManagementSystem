package schoolproject.model;

import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.StringJoiner;

public class StudentFeedback {
    private double averageGrade=0;
    private HashMap<Long,Absence>absences=new HashMap<>();
    private HashMap<Long,Remark>remarks=new HashMap<>();
    private HashMap<Long,Grade>grades=new HashMap<>();

    public StudentFeedback(HashMap<Long, Absence> absences, HashMap<Long, Remark> remarks, HashMap<Long, Grade> grades) {
        this.absences = absences;
        this.remarks = remarks;
        this.grades = grades;
    }
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public StudentFeedback() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentFeedback.class.getSimpleName() + "[", "]")
                //.add("averageGrade=" + averageGrade)
                //.add("absences=" + absences)
               // .add("remarks=" + remarks)
                .add("grades=" + grades)
                .toString();
    }

    public HashMap<Long, Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(HashMap<Long, Absence> absences) {
        this.absences = absences;
    }

    public HashMap<Long, Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(HashMap<Long, Remark> remarks) {
        this.remarks = remarks;
    }

    public HashMap<Long, Grade> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<Long, Grade> grades) {
        this.grades = grades;
    }


    //double




    }

