package schoolproject.dao.impl;


import schoolproject.dao.impl.helperrepositories.LongIdGenerator;
import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;


import java.util.HashMap;

public class SchoolClassRepoImpl extends PersistableRepositoryFileImpl<Long,String,SchoolClass> implements SchoolClassRepo {

    public SchoolClassRepoImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }

    @Override
    public SchoolClass addStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {

        schoolClass.getStudents().put(student.getId(),student);
        return update(schoolClass);
    }

    @Override
    public SchoolClass updateStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {


        if(schoolClass.getStudents().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getStudents().put(student.getId(),student);
        }

        return update(schoolClass);
    }

    @Override
    public SchoolClass deleteStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {


        if(schoolClass.getStudents().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getStudents().remove(student.getId());
        }

        return update(schoolClass);
    }

    @Override
    public SchoolClass addSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {

        schoolClass.getSubjects().put(subject.getId(),subject);
        return update(schoolClass);
    }

    @Override
    public SchoolClass updateSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {


        if(schoolClass.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getSubjects().put(subject.getId(),subject);
        }

        return update(schoolClass);
    }

    @Override
    public SchoolClass deleteSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {


        if(schoolClass.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getSubjects().remove(subject.getId());
        }

        return update(schoolClass);
    }
    @Override
    public SchoolClass removeSubjectFromWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {


        schoolClass.getProgram().forEach((key,value)->
                value.entrySet().removeIf(e -> e.getValue().equals(subject)));

        return update(schoolClass);
    }
    @Override
    public SchoolClass updateSubjectInWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {

        schoolClass.getProgram().forEach((key,value)->
                {for (HashMap.Entry<Integer, Subject> entry : value.entrySet())
                    if(entry.getValue().equals(subject))
                        entry.setValue(subject);
                }
        );
        return update(schoolClass);
    }
    @Override
    public SchoolClass addSubjectToProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {


        if(schoolClass.getProgram().get(day).putIfAbsent(classNumber,subject)==null)
            throw new BusyClassException();
        return update(schoolClass);
    }

    @Override
    public SchoolClass removeSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws  EntityNotFoundException {

        if(schoolClass.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else schoolClass.getProgram().get(day).remove(classNumber);
        return update(schoolClass);
    }

    @Override
    public SchoolClass updateSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws  EntityNotFoundException {

        if(schoolClass.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else schoolClass.getProgram().get(day).put(classNumber,subject);
        return update(schoolClass);
    }
}
