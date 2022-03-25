package schoolproject.model;

import schoolproject.dao.Identifiable;

import java.util.Date;
import java.util.StringJoiner;

public class StudentFeedback {


    private class Template <T> implements Identifiable<Long,String> {
        private Long id;
        private Date date;
        private Subject subject;
        private Student student;
        private T value;

        @Override
        public String toString() {
            return new StringJoiner(", ", Template.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("date=" + date)
                    .add("subject=" + subject)
                    .add("student=" + student)
                    .add("value=" + value)
                    .toString();
        }

        public Template(Date date, Subject subject, Student student, T value) {
            this.date = date;
            this.subject = subject;
            this.student = student;
            this.value = value;
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
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
    public class Absence extends Template<Integer>{

        public Absence(Date date, Subject subject, Student student, Integer value) {
            super(date, subject, student, value);
        }
    }

    public class Remark extends Template<String> {

        public Remark( Date date, Subject subject, Student student, String value) {
            super( date, subject, student, value);
        }
    }
    public class Grade extends Template<Integer>{

        public Grade( Date date, Subject subject, Student student, Integer value) {
            super(date, subject, student, value);
        }
    }
    }

