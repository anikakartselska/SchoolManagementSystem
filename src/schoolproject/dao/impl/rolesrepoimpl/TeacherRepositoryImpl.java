package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;

import java.util.HashMap;

public class TeacherRepositoryImpl extends UserRepositoryImpl<Teacher> implements TeacherRepository  {
    public TeacherRepositoryImpl(LongIdGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    public Teacher changeOwnClass(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {

        teacher.setOwnClass(schoolClass);
        return update(teacher);
    }

    @Override
    public Teacher addTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {

        teacher.getTeachingClasses().put(schoolClass.getId(),schoolClass);
        return update(teacher);
    }

    @Override
    public Teacher removeTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {


        if(teacher.getTeachingClasses().get(schoolClass.getId())==null)
            throw new EntityNotFoundException();
        else {
            teacher.getTeachingClasses().remove(schoolClass.getId());
        }

        return update(teacher);
    }

    @Override
    public Teacher updateTeachingClasses(Teacher teacher, SchoolClass schoolClass) throws EntityNotFoundException {


        if(teacher.getTeachingClasses().get(schoolClass.getId())==null)
            throw new EntityNotFoundException();
        else {
            teacher.getTeachingClasses().put(schoolClass.getId(),schoolClass);
        }

        return update(teacher);
    }

    @Override
    public Teacher addSubjectToProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws BusyClassException, EntityNotFoundException {


           if(teacher.getProgram().get(day).putIfAbsent(classNumber,subject)!=null)
               throw new BusyClassException();
        return update(teacher);
    }

    @Override
    public Teacher removeSubjectFromProgram(Teacher teacher, Integer day, Integer classNumber, Subject subject) throws EntityNotFoundException {

        if(teacher.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else teacher.getProgram().get(day).remove(classNumber);
        return update(teacher);
    }

    @Override
    public Teacher updateSubjectFromProgram(Teacher teacher,  Integer day, Integer classNumber, Subject subject) throws EntityNotFoundException {

        if(teacher.getProgram().get(day).get(classNumber)==null)
            throw new EntityNotFoundException();
        else teacher.getProgram().get(day).put(classNumber,subject);
        return update(teacher);
    }
 @Override
    public Teacher removeSubjectFromWholeProgram(Teacher teacher,Subject subject) throws EntityNotFoundException {


     teacher.getProgram().forEach((key,value)->
            value.entrySet().removeIf(e -> e.getValue().equals(subject)));

        return update(teacher);
    }
    @Override
    public Teacher updateSubjectInWholeProgram(Teacher teacher,Subject subject) throws EntityNotFoundException {

        teacher.getProgram().forEach((key,value)->
                {for (HashMap.Entry<Integer, Subject> entry : value.entrySet())
                    if(entry.getValue().equals(subject))
                        entry.setValue(subject);
                }
        );
        return update(teacher);
    }


}
