package schoolproject.model;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.IdentifiableStudentFeedback;
import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class StudentFeedback {


    public class Template <T> implements Identifiable<Long, String>, IdentifiableStudentFeedback<T> {
        private Long id;
        private LocalDate date;
        private Subject subject;
        private Student student;
        private T value;

        public Template(LocalDate date, Subject subject, Student student, T value) {
            this.date = date;
            this.subject = subject;
            this.student = student;
            this.value = value;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ",  "[", "]")
                    .add("id=" + id)
                    .add("date=" + date)
                    .add("subject=" + subject)
                    .add("student=" + student)
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
 //double
    public class Absence extends Template<Double>{


     public Absence(LocalDate date, Subject subject, Student student, Double value) {
         super( date, subject, student, value);
     }

     @Override
     public String toString() {
         return new StringJoiner(", ", Absence.class.getSimpleName() , super.toString())
                 .toString();
     }
 }

    public class Remark extends Template<String> {

        public Remark( LocalDate  date, Subject subject, Student student, String value) {
            super( date, subject, student, value);
        }
        @Override
        public String toString() {
            return new StringJoiner(", ",Remark.class.getSimpleName() , super.toString())
                    .toString();
        }
    }
    public class Grade extends Template<Integer>{

        public Grade( LocalDate  date, Subject subject, Student student, Integer value) {
            super(date, subject, student, value);
        }
        @Override
        public String toString() {
            return new StringJoiner(", ", Grade.class.getSimpleName() , super.toString())
                    .toString();
        }
    }
    }

