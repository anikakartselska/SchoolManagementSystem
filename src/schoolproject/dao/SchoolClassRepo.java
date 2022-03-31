package schoolproject.dao;

import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;

public interface SchoolClassRepo extends Repository <Long,String, SchoolClass>{

    SchoolClass addStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException;
    SchoolClass updateStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException;
    SchoolClass deleteStudent(SchoolClass schoolClass, Student student) throws EntityNotFoundException;
    SchoolClass addSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException;
    SchoolClass updateSubject(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException;
    SchoolClass deleteSubject(SchoolClass schoolClass,Subject subject) throws EntityNotFoundException;

    SchoolClass removeSubjectFromWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException;

    SchoolClass updateSubjectInWholeProgram(SchoolClass schoolClass, Subject subject) throws EntityNotFoundException;

    SchoolClass addSubjectToProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws EntityNotFoundException, BusyClassException;

    SchoolClass removeSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws EntityNotFoundException;

    SchoolClass updateSubjectFromProgram(SchoolClass schoolClass, Integer day, Integer classNumber, Subject subject) throws  EntityNotFoundException;
}
