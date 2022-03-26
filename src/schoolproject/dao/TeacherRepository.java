package schoolproject.dao;

import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public interface TeacherRepository extends UserRepository<Teacher>,Repository<Long,String,Teacher>{
    Teacher changeOwnClass(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher addTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher removeTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher updateTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher addSubjectToProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher removeSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher updateSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher removeSubjectFromWholeProgram(Teacher teacher, Subject subject) throws EntityNotFoundException;
    Teacher updateSubjectInWholeProgram(Teacher teacher, Subject subject) throws EntityNotFoundException;
}
