package schoolproject.model;

import schoolproject.dao.*;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.dao.impl.AbsenceRepositoryImpl;
import schoolproject.dao.impl.GradeRepositoryImpl;
import schoolproject.dao.impl.LessonRepositoryImpl;
import schoolproject.dao.impl.SubjectRepositoryImpl;
import schoolproject.dao.impl.rolesrepoimpl.StudentRepositoryImpl;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Student;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.StringJoiner;

public class Lesson implements Identifiable<Long, String>, IdentifiableAGR<Long, String>, Serializable {
    private Long id;
    private Subject subject;
    private LocalDate date;
    private HashMap<Student,StudentFeedback> feedbacks=new HashMap<>();

    public HashMap<Student, StudentFeedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(HashMap<Student, StudentFeedback> feedbacks) {
        this.feedbacks = feedbacks;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Lesson(Subject subject, LocalDate date) {
        this.subject = subject;
        this.date=date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lesson.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("subject=" + subject)
                .add("date=" + date)
                .add("feedbacks=" + feedbacks)
                .toString();
    }
    public Lesson(){}
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


}
