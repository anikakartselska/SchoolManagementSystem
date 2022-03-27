package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;

public class StudentRepositoryImpl extends UserRepositoryImpl<Student> implements StudentRepository {





    @Override
    public Student addAbsence(Student student, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.getAbsences().put(newAbsence.getId(),newAbsence);
        return update(updatedStudent);

    }

    @Override
    public Student addRemark(Student student, StudentFeedback.Remark newRemark) throws EntityNotFoundException {

        Student updatedStudent=student;
        updatedStudent.getRemarks().put(newRemark.getId(),newRemark);
        return update(updatedStudent);
    }

    @Override
    public Student addGrade(Student student, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.getGrades().put(newGrade.getId(),newGrade);

        return update(updatedStudent);
    }

    @Override
    public Student removeAbsence(Student student, StudentFeedback.Absence removeAbsence) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getAbsences().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getAbsences().remove(removeAbsence.getId());
        }

        return update(updatedStudent);
    }

    @Override
    public Student removeRemark(Student student, StudentFeedback.Remark removeRemark) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getRemarks().remove(removeRemark.getId());
        }

        return update(updatedStudent);

    }

    @Override
    public Student removeGrade(Student student, StudentFeedback.Grade removeGrade) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getGrades().remove(removeGrade.getId());
        }

        return update(updatedStudent);
    }

    @Override
    public Student updateAbsence(Student student, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getAbsences().put(newAbsence.getId(),newAbsence);
        }

        return update(updatedStudent);
    }

    @Override
    public Student updateRemark(Student student, StudentFeedback.Remark newRemark) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getRemarks().put(newRemark.getId(),newRemark);
        }

        return update(updatedStudent);
    }

    @Override
    public Student updateGrade(Student student, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getGrades().put(newGrade.getId(),newGrade);
        }

        return update(updatedStudent);
    }

    @Override
    public Student changeNumberInClass(Student student, int newNumber) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.setNumberInClass(newNumber);
        return update(updatedStudent);
    }

    @Override
    public Student changeSchoolClass(Student student, SchoolClass schoolClass) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.setSchoolClass(schoolClass);
        return update(updatedStudent);
    }

    @Override
    public Student changeAverageGrade(Student student) throws EntityNotFoundException {
        Student updatedStudent=student;
        double average=0;
        var i=0;
        for(StudentFeedback.Grade grade: updatedStudent.getGrades().values())
        { average+= grade.getValue();
        i++;}

        updatedStudent.setAverageGrade(average/i);
        return update(updatedStudent);
    }

    @Override
    public Student addParent(Student student, Parent parent) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.getParents().put(parent.getId(),parent);
        return update(updatedStudent);
    }

    @Override
    public Student addSubject(Student student, Subject subject) throws EntityNotFoundException {
        Student updatedStudent=student;
        updatedStudent.getSubjects().put(subject.getId(),subject);
        return update(updatedStudent);
    }

    @Override
    public Student removeParent(Student student, Parent parent) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getParents().get(parent.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getParents().remove(parent.getId());
        }

        return update(updatedStudent);
    }

    @Override
    public Student removeSubject(Student student, Subject subject) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getSubjects().remove(subject.getId());
        }

        return update(updatedStudent);
    }

    @Override
    public Student updateParent(Student student, Parent parent) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getParents().get(parent.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getParents().put(parent.getId(),parent);
        }

        return update(updatedStudent);
    }

    @Override
    public Student updateSubject(Student student, Subject subject) throws EntityNotFoundException {
        Student updatedStudent=student;

        if(updatedStudent.getSubjects().get(subject.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedStudent.getSubjects().put(subject.getId(),subject);
        }

        return update(updatedStudent);
    }
}
