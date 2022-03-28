package schoolproject.dao.impl;


import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;


import java.util.HashMap;

public class SchoolClassRepoImpl extends RepositoryImpl<Long,String, SchoolClass> implements SchoolClassRepo {
    @Override
    public SchoolClass addLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {

        schoolClass.getLessons().put(lesson.getId(),lesson);
        return update(schoolClass);
    }

    @Override
    public SchoolClass updateLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {


        if(schoolClass.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getLessons().put(lesson.getId(),lesson);
        }

        return update(schoolClass);
    }

    @Override
    public SchoolClass deleteLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {

        if(schoolClass.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            schoolClass.getLessons().remove(lesson.getId());
        }

        return update(schoolClass);
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
