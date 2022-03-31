package schoolproject.model;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.dao.identifiiables.IdentifiableStudentFeedback;
import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Template <T> implements Identifiable<Long, String>,IdentifiableStudentFeedback<T> {
    private Long id;
    private LocalDate date;
    private Subject subject;
    private Student student;
    private T value;

     public Template()
     {}
    public Template(LocalDate date, Subject subject, Student student, T value) {
        this.date = date;
        this.subject = subject;
        this.student = student;
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Template.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("date=" + date)
               // .add("subject=" + subject)
               // .add("student=" + student)
                .add("value=" + value)
                .toString();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return String.valueOf(this.getClass());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}