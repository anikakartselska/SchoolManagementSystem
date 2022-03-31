package schoolproject.model;

import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Grade extends Template<Integer> {

    public Grade(LocalDate date, Subject subject, Student student, Integer value) {
        super(date, subject, student, value);
    }

    public Grade() {

    }
    public String toString() {
        return new StringJoiner(" ", Grade.class.getSimpleName() + super.toString(), "]")

                .toString();
    }

}
