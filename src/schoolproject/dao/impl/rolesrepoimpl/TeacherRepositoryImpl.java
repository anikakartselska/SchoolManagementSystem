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

           if(updatedTeacher.getProgram().get(day).putIfAbsent(classNumber,subject)==null)
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
        for(int i=teacher.getProgram().size();i>0;i--)
            for(int j=teacher.getProgram().get(i).size();j>0;j--)
                if(teacher.getProgram().get(i).get(j).equals(subject))
                    teacher.getProgram().get(i).remove(j);
        return update(updatedTeacher);
    }
    @Override
    public Teacher updateSubjectInWholeProgram(Teacher teacher,Subject subject) throws EntityNotFoundException {
        Teacher updatedTeacher=teacher;
        for(int i=teacher.getProgram().size();i>0;i--)
            for(int j=teacher.getProgram().get(i).size();j>0;j--)
                if(teacher.getProgram().get(i).get(j).equals(subject))
                    teacher.getProgram().get(i).put(j,subject);
        return update(updatedTeacher);
    }

    public static void main(String[] args) {
        HashMap<Integer,HashMap<Integer,String>> hm=new HashMap<>();
        hm.put(1,new HashMap<>());
        hm.put(2,new HashMap<>());
        hm.get(1).put(1,"Anika");
        hm.get(1).put(2,"Raya");
        hm.get(1).put(3,"Anika");
        hm.get(2).put(1,"Anika");
        hm.get(2).put(2,"Raya");
        hm.get(2).put(3,"Anika");
        System.out.println(hm.size());
        System.out.println(hm.get(1).size());
        System.out.println(hm);
        for(int i=hm.size();i>0;i--)
            for(int j=hm.get(i).size();j>0;j--)
                if(hm.get(i).get(j).equals("Anika"))
                    hm.get(i).put(j,"Raya");
        System.out.println(hm);
    }
}
