package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.impl.helperrepositories.LongIdGenerator;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;

import java.util.*;

public class StudentRepositoryImpl extends UserRepositoryImpl<Student> implements StudentRepository {


    public StudentRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }

    @Override
    public Student changeNumberInClass(Student student, int newNumber) throws EntityNotFoundException {

        student.setNumberInClass(newNumber);
        return update(student);
    }

    @Override
    public Student changeSchoolClass(Student student, SchoolClass schoolClass) throws EntityNotFoundException {

        student.setSchoolClass(schoolClass);
        return update(student);
    }

    @Override
    public Student changeAverageGrade(Student student) throws EntityNotFoundException {
        student.setAverageGrade(
                student.getSubjects().values().stream().map(Subject::getAverageGrade).mapToDouble(Double::doubleValue).sum()/student.getSubjects().size());
          return update(student);
    }


    @Override
    public Student addParent(Student student, Parent parent) throws EntityNotFoundException {

        student.getParents().put(parent.getId(),parent);
        return update(student);
    }

    @Override
    public Student addSubject(Student student, Subject subject) throws EntityNotFoundException {

        student.getSubjects().put(subject.getId(),subject);
        return update(student);
    }

    @Override
    public Student removeParent(Student student, Parent parent) throws EntityNotFoundException {


        if(student.getParents().get(parent.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getParents().remove(parent.getId());
        }

        return update(student);
    }

    @Override
    public Student removeSubject(Student student, Subject subject) throws EntityNotFoundException {


        if(student.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getSubjects().remove(subject.getId());
        }

        return update(student);
    }

    @Override
    public Student updateParent(Student student, Parent parent) throws EntityNotFoundException {


        if(student.getParents().get(parent.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getParents().put(parent.getId(),parent);
        }

        return update(student);
    }

    @Override
    public Student updateSubject(Student student, Subject subject) throws EntityNotFoundException {


        if(student.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getSubjects().put(subject.getId(),subject);
        }

        return update(student);
    }

    @Override
    public List<Student> findAllSorted(Comparator<Student> comparator) { // O(1)
        var sorted = new ArrayList<>(findAll());
        sorted.sort(comparator);
        return sorted;
    }
}
