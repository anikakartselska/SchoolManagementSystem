package schoolproject.dao.rolerepositories;

import schoolproject.dao.Repository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;

public interface TeacherRepository extends UserRepository<Teacher> {
    Teacher changeOwnClass(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher addTeachingSubject(Teacher teacher, Subject subject) throws EntityNotFoundException;
    Teacher removeTeachingSubject(Teacher teacher, Subject subject) throws EntityNotFoundException;
    Teacher updateTeachingSubject(Teacher teacher, Subject subject) throws EntityNotFoundException;
    Teacher addSubjectToProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher removeSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher updateSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException;
    Teacher removeSubjectFromWholeProgram(Teacher teacher, Subject subject) throws EntityNotFoundException;
    Teacher updateSubjectInWholeProgram(Teacher teacher, Subject subject) throws EntityNotFoundException;
}
