package schoolproject.dao.impl;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.User;

import java.time.LocalDateTime;

public class LessonRepositoryImpl extends RepositoryImpl<Long,String, Lesson> implements LessonRepository {
    @Override
    public Lesson changeSubject(Lesson lesson, Subject newSubject) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;
        updatedLesson.setSubject(newSubject);
        return update(updatedLesson);

    }

    @Override
    public Lesson changeDate(Lesson lesson, LocalDateTime newDate) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;
        updatedLesson.setDate(newDate);
        return update(updatedLesson);
    }

    @Override
    public Lesson changeClass(Lesson lesson, SchoolClass newSchoolClass) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;
        updatedLesson.setSchoolClass(newSchoolClass);
        return update(updatedLesson);
    }

    @Override
    public Lesson addAbsence(Lesson lesson, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;
        updatedLesson.getAbsences().put(newAbsence.getId(),newAbsence);
        return update(updatedLesson);

    }

    @Override
    public Lesson addRemark(Lesson lesson, StudentFeedback.Remark newRemark) throws EntityNotFoundException {

        Lesson updatedLesson=lesson;
        updatedLesson.getRemarks().put(newRemark.getId(),newRemark);
        return update(updatedLesson);
    }

    @Override
    public Lesson addGrade(Lesson lesson, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;
        updatedLesson.getGrades().put(newGrade.getId(),newGrade);

        return update(updatedLesson);
    }

    @Override
    public Lesson removeAbsence(Lesson lesson, StudentFeedback.Absence removeAbsence) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getAbsences().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getAbsences().remove(removeAbsence.getId());
             }

        return update(updatedLesson);
    }

    @Override
    public Lesson removeRemark(Lesson lesson, StudentFeedback.Remark removeRemark) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getRemarks().remove(removeRemark.getId());
        }

        return update(updatedLesson);

    }

    @Override
    public Lesson removeGrade(Lesson lesson, StudentFeedback.Grade removeGrade) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getGrades().remove(removeGrade.getId());
        }

        return update(updatedLesson);
    }

    @Override
    public Lesson updateAbsence(Lesson lesson, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getAbsences().put(newAbsence.getId(),newAbsence);
        }

        return update(updatedLesson);
    }

    @Override
    public Lesson updateRemark(Lesson lesson, StudentFeedback.Remark newRemark) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getRemarks().put(newRemark.getId(),newRemark);
        }

        return update(updatedLesson);
    }

    @Override
    public Lesson updateGrade(Lesson lesson, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        Lesson updatedLesson=lesson;

        if(updatedLesson.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedLesson.getGrades().put(newGrade.getId(),newGrade);
        }

        return update(updatedLesson);
    }
}
