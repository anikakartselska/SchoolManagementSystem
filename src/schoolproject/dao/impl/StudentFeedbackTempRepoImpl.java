package schoolproject.dao.impl;

import schoolproject.dao.StudentFeedbackTempRepo;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;

import java.time.LocalDateTime;

public class StudentFeedbackTempRepoImpl<T> extends RepositoryImpl<Long,String, StudentFeedback.Template<T>> implements StudentFeedbackTempRepo<T> {

    @Override
    public StudentFeedback.Template<T> changeDate(StudentFeedback.Template<T> temp, LocalDateTime newDate) throws EntityNotFoundException {
        StudentFeedback.Template<T> updated=temp;
        updated.setDate(newDate);
        return update(updated);
    }

    @Override
    public StudentFeedback.Template<T> changeSubject(StudentFeedback.Template<T> temp, Subject newSubject) throws EntityNotFoundException {
        StudentFeedback.Template<T> updated=temp;
        updated.setSubject(newSubject);
        return update(updated);
    }

    @Override
    public StudentFeedback.Template<T> changeStudent(StudentFeedback.Template<T> temp, Student newStudent) throws EntityNotFoundException {
        StudentFeedback.Template<T> updated=temp;
        updated.setStudent(newStudent);
        return update(updated);
    }

    @Override
    public StudentFeedback.Template<T> changeValue(StudentFeedback.Template<T> temp, T newValue) throws EntityNotFoundException {
        StudentFeedback.Template<T> updated=temp;
        updated.setValue(newValue);
        return update(updated);
    }
}
