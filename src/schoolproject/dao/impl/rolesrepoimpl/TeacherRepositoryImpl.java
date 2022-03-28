package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class TeacherRepositoryImpl extends UserRepositoryImpl<Teacher> implements TeacherRepository  {
    @Override
    public Teacher changeOwnClass(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        updatedTeacher.setOwnClass(schoolClass);
        return update(updatedTeacher);
    }

    @Override
    public Teacher addTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        updatedTeacher.getTeachingClasses().put(schoolClass.getId(),schoolClass);
        return update(updatedTeacher);
    }

    @Override
    public Teacher removeTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;

        if(updatedTeacher.getTeachingClasses().get(schoolClass.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedTeacher.getTeachingClasses().remove(schoolClass.getId());
        }

        return update(updatedTeacher);
    }

    @Override
    public Teacher updateTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;

        if(updatedTeacher.getTeachingClasses().get(schoolClass.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedTeacher.getTeachingClasses().put(schoolClass.getId(),schoolClass);
        }

        return update(updatedTeacher);
    }

    @Override
    public Teacher addSubjectToProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        Teacher updatedTeacher=teacher;

           if(updatedTeacher.getProgram().get(day).putIfAbsent(classNumber,subject)!=null)
               throw new BusyClassException();
        return update(updatedTeacher);
    }

    @Override
    public Teacher removeSubjectFromProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        if(updatedTeacher.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else updatedTeacher.getProgram().get(day).remove(classNumber);
        return update(updatedTeacher);
    }

    @Override
    public Teacher updateSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        if(updatedTeacher.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else updatedTeacher.getProgram().get(day).put(classNumber,subject);
        return update(updatedTeacher);
    }
 @Override
    public Teacher removeSubjectFromWholeProgram(Teacher teacher,Subject subject) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;

     updatedTeacher.getProgram().forEach((key,value)->
            value.entrySet().removeIf(e -> e.getValue().equals(subject)));

        return update(updatedTeacher);
    }
    @Override
    public Teacher updateSubjectInWholeProgram(Teacher teacher,Subject subject) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        updatedTeacher.getProgram().forEach((key,value)->
                {for (HashMap.Entry<Integer, Subject> entry : value.entrySet())
                    if(entry.getValue().equals(subject))
                        entry.setValue(subject);
                }
        );
        return update(updatedTeacher);
    }


}
