package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;

import java.time.LocalDateTime;

public interface StudentFeedbackTempRepo<T> extends Repository <Long,String,StudentFeedback.Template<T>> {
    StudentFeedback.Template<T> changeDate (StudentFeedback.Template<T> temp, LocalDateTime newDate) throws EntityNotFoundException;
    StudentFeedback.Template<T> changeSubject (StudentFeedback.Template<T> temp, Subject newSubject) throws EntityNotFoundException;
    StudentFeedback.Template<T> changeStudent (StudentFeedback.Template<T> temp, Student newStudent) throws EntityNotFoundException;
    StudentFeedback.Template<T> changeValue (StudentFeedback.Template<T> temp, T newValue) throws EntityNotFoundException;
}
