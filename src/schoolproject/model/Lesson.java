package schoolproject.model;

import schoolproject.dao.Identifiable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Lesson implements Identifiable<Long, String> {
    private Long id;
    private Subject subject;
    private LocalDateTime date;
    private SchoolClass schoolClass;
    private HashMap<Long,StudentFeedback.Absence> absences=new HashMap<>();
    private HashMap<Long,StudentFeedback.Remark>remarks= new HashMap<>();
    private HashMap<Long,StudentFeedback.Grade>grades=new HashMap<>();

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return getSubject().getName()+getClass().toString();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Lesson(Subject subject,LocalDateTime date) {
        this.subject = subject;
        this.date=date;
    }

    public Lesson(Subject subject, LocalDateTime date, SchoolClass schoolClass, HashMap<Long, StudentFeedback.Absence> absences, HashMap<Long, StudentFeedback.Remark> remarks, HashMap<Long, StudentFeedback.Grade> grades) {
        this.subject = subject;
        this.date = date;
        this.schoolClass = schoolClass;
        this.absences = absences;
        this.remarks = remarks;
        this.grades = grades;
    }


    public Lesson(Subject subject, LocalDateTime date, HashMap<Long, StudentFeedback.Absence> absences, HashMap<Long, StudentFeedback.Remark> remarks, HashMap<Long, StudentFeedback.Grade> grades) {
        this.subject = subject;
        this.date=date;
        this.absences = absences;
        this.remarks = remarks;
        this.grades = grades;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
}
