package schoolproject.model;

import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Remark extends Template<String> {

    public Remark(LocalDate date, Subject subject, Student student, String value) {
        super( date, subject, student, value);
    }
    public String toString() {
        return new StringJoiner(" ", Remark.class.getSimpleName() + super.toString(), "]")

                .toString();
    }
}
