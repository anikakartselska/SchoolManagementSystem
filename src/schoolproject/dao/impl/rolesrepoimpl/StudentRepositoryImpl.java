package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.User;

import java.util.*;

public class StudentRepositoryImpl extends UserRepositoryImpl<Student> implements StudentRepository {


    @Override
    public Student addAbsence(Student student, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {

        student.getAbsences().put(newAbsence.getId(),newAbsence);
        return update(student);

    }

    @Override
    public Student addRemark(Student student, StudentFeedback.Remark newRemark) throws EntityNotFoundException {


        student.getRemarks().put(newRemark.getId(),newRemark);
        return update(student);
    }

    @Override
    public Student addGrade(Student student, StudentFeedback.Grade newGrade) throws EntityNotFoundException {

        student.getGrades().put(newGrade.getId(),newGrade);

        return update(student);
    }

    @Override
    public Student removeAbsence(Student student, StudentFeedback.Absence removeAbsence) throws EntityNotFoundException {


        if(student.getAbsences().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getAbsences().remove(removeAbsence.getId());
        }

        return update(student);
    }

    @Override
    public Student removeRemark(Student student, StudentFeedback.Remark removeRemark) throws EntityNotFoundException {


        if(student.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getRemarks().remove(removeRemark.getId());
        }

        return update(student);

    }

    @Override
    public Student removeGrade(Student student, StudentFeedback.Grade removeGrade) throws EntityNotFoundException {


        if(student.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getGrades().remove(removeGrade.getId());
        }

        return update(student);
    }

    @Override
    public Student updateAbsence(Student student, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {

        if(student.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getAbsences().put(newAbsence.getId(),newAbsence);
        }

        return update(student);
    }

    @Override
    public Student updateRemark(Student student, StudentFeedback.Remark newRemark) throws EntityNotFoundException {


        if(student.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getRemarks().put(newRemark.getId(),newRemark);
        }

        return update(student);
    }

    @Override
    public Student updateGrade(Student student, StudentFeedback.Grade newGrade) throws EntityNotFoundException {


        if(student.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            student.getGrades().put(newGrade.getId(),newGrade);
        }

        return update(student);
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

        double average=0;
        var i=0;
        for(StudentFeedback.Grade grade: student.getGrades().values())
        { average+= grade.getValue();
        i++;}

        student.setAverageGrade(average/i);
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
