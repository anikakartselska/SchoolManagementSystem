package schoolproject.model;

import schoolproject.model.enums.AbsenceStatus;
import schoolproject.model.roles.Student;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Absence extends Template<Double> {
    private AbsenceStatus status=AbsenceStatus.UNEXCUSED;


    public AbsenceStatus getStatus() {
        return status;
    }

    public void setStatus(AbsenceStatus status) {
        this.status = status;
    }



    public Absence(LocalDate date, Subject subject, Student student, Double value, AbsenceStatus status) {
        super(date, subject, student, value);
        this.status = status;
    }

    public Absence(LocalDate date, Subject subject, Student student, Double value) {
        super( date, subject, student, value);
    }

    public Absence() {

    }

    public String toString() {
        return new StringJoiner(" ", Absence.class.getSimpleName() + super.toString(), "]")

                .toString();
    }
}
