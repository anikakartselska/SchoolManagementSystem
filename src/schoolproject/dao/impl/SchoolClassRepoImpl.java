package schoolproject.dao.impl;


import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class SchoolClassRepoImpl extends RepositoryImpl<Long,String, SchoolClass> implements SchoolClassRepo {
    @Override
    public SchoolClass addLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        updatedSchoolClass.getLessons().put(lesson.getId(),lesson);
        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass updateLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getLessons().put(lesson.getId(),lesson);
        }

        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass deleteLesson(SchoolClass schoolClass, Lesson lesson) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getLessons().remove(lesson.getId());
        }

        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass addStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        updatedSchoolClass.getStudents().put(student.getId(),student);
        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass updateStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getStudents().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getStudents().put(student.getId(),student);
        }

        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass deleteStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getStudents().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getStudents().remove(student.getId());
        }

        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass addSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        updatedSchoolClass.getSubjects().put(subject.getId(),subject);
        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass updateSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getSubjects().put(subject.getId(),subject);
        }

        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass deleteSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSchoolClass.getSubjects().remove(subject.getId());
        }

        return update(updatedSchoolClass);
    }
    @Override
    public SchoolClass removeSubjectFromWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        updatedSchoolClass.getProgram().forEach((key,value)->
                value.entrySet().removeIf(e -> e.getValue().equals(subject)));

        return update(updatedSchoolClass);
    }
    @Override
    public SchoolClass updateSubjectInWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        updatedSchoolClass.getProgram().forEach((key,value)->
                {for (HashMap.Entry<Integer, Subject> entry : value.entrySet())
                    if(entry.getValue().equals(subject))
                        entry.setValue(subject);
                }
        );
        return update(updatedSchoolClass);
    }
    @Override
    public SchoolClass addSubjectToProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;

        if(updatedSchoolClass.getProgram().get(day).putIfAbsent(classNumber,subject)==null)
            throw new BusyClassException();
        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass removeSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        if(updatedSchoolClass.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else updatedSchoolClass.getProgram().get(day).remove(classNumber);
        return update(updatedSchoolClass);
    }

    @Override
    public SchoolClass updateSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        SchoolClass updatedSchoolClass=schoolClass;
        if(updatedSchoolClass.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else updatedSchoolClass.getProgram().get(day).put(classNumber,subject);
        return update(updatedSchoolClass);
    }
}
