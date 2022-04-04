package schoolproject.dao.impl;

import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.StudentFeedbackTempRepo;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.Subject;

import schoolproject.model.Template;
import schoolproject.model.roles.Student;
import java.time.LocalDate;


public class StudentFeedbackTempRepoImpl<T> extends PersistableRepositoryFileImpl<Long,String,Template<T>> implements StudentFeedbackTempRepo<T> {


    public StudentFeedbackTempRepoImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }

    @Override
    public Template<T> changeDate(Template<T> temp, LocalDate newDate) throws EntityNotFoundException {
        temp.setDate(newDate);
        return update(temp);
    }

    @Override
    public Template<T> changeSubject(Template<T> temp, Subject newSubject) throws EntityNotFoundException {
        temp.setSubject(newSubject);
        return update(temp);
    }

    @Override
    public Template<T> changeStudent(Template<T> temp, Student newStudent) throws EntityNotFoundException {
        temp.setStudent(newStudent);
        return update(temp);
    }

    @Override
    public Template<T> changeValue(Template<T> temp, T newValue) throws EntityNotFoundException {

        temp.setValue(newValue);
        return update(temp);
    }
}
