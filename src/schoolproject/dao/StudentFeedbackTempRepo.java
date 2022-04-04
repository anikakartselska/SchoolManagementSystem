package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Subject;

import schoolproject.model.Template;
import schoolproject.model.roles.Student;

import java.time.LocalDate;

public interface StudentFeedbackTempRepo<T> extends PersistableRepository <Long,String, Template<T>> {
    Template<T> changeDate (Template<T> temp, LocalDate newDate) throws EntityNotFoundException;

    Template<T> changeSubject (Template<T> temp, Subject newSubject) throws EntityNotFoundException;

    Template<T> changeStudent (Template<T> temp, Student newStudent) throws EntityNotFoundException;

    Template<T> changeValue (Template<T> temp, T newValue) throws EntityNotFoundException;
}
