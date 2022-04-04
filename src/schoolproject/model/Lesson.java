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
    private SchoolClass schoolClass;
    private HashMap<Student,StudentFeedback> feedbacks=new HashMap<>();

    public HashMap<Student, StudentFeedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(HashMap<Student, StudentFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }


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
                .add("schoolClass=" + schoolClass)
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

    public static void main(String[] args) {
        LessonRepository lessonRepository=new LessonRepositoryImpl(new LongIdGenerator());
        lessonRepository.add(new Lesson());
        //System.out.println(lessonRepository.findById(1L));
        GradeRepository gradeRepository=new GradeRepositoryImpl(new LongIdGenerator());
        StudentRepository studentRepository=new StudentRepositoryImpl(new LongIdGenerator());
        SubjectRepository subjectRepository=new SubjectRepositoryImpl(new LongIdGenerator());
        subjectRepository.add(new Subject());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        studentRepository.add(new Student("Mariya","Petrova","Petrova","mppp@abv.bg","mimi","Mimmmii55$", Gender.FEMALE,"0894673336","rupite", LocalDate.parse("09.08.2009",dtf)));
        gradeRepository.add(new Grade(LocalDate.now(),subjectRepository.findById(1L),studentRepository.findById(1L),6));
        gradeRepository.add(new Grade(LocalDate.now(),subjectRepository.findById(1L),studentRepository.findById(1L),5));
       // gradeRepository.add(new Grade(LocalDate.now(),subjectRepository.findById(1L),studentRepository.findById(1L),6));

        try {
            subjectRepository.addGrade(subjectRepository.findById(1L), (Grade) gradeRepository.findById(1L));
            subjectRepository.addGrade(subjectRepository.findById(1L), (Grade) gradeRepository.findById(2L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(subjectRepository.findById(1L));
        try {
            System.out.println(studentRepository.changeAverageGrade(studentRepository.findById(1L)));
            System.out.println(studentRepository.findById(1L).getAverageGrade());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }
    //date, subject, student, value
}
