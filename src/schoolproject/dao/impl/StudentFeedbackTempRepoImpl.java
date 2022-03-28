package schoolproject.dao.impl;

import schoolproject.dao.StudentFeedbackTempRepo;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;
import java.time.LocalDate;


public class StudentFeedbackTempRepoImpl<T> extends RepositoryImpl<Long,String, StudentFeedback.Template<T>> implements StudentFeedbackTempRepo<T> {

    @Override
    public StudentFeedback.Template<T> changeDate(StudentFeedback.Template<T> temp, LocalDate newDate) throws EntityNotFoundException {
        temp.setDate(newDate);
        return update(temp);
    }

    @Override
    public StudentFeedback.Template<T> changeSubject(StudentFeedback.Template<T> temp, Subject newSubject) throws EntityNotFoundException {
        temp.setSubject(newSubject);
        return update(temp);
    }

    @Override
    public StudentFeedback.Template<T> changeStudent(StudentFeedback.Template<T> temp, Student newStudent) throws EntityNotFoundException {
        temp.setStudent(newStudent);
        return update(temp);
    }

    @Override
    public StudentFeedback.Template<T> changeValue(StudentFeedback.Template<T> temp, T newValue) throws EntityNotFoundException {

        temp.setValue(newValue);
        return update(temp);
    }
}
