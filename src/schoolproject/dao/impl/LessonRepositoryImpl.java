package schoolproject.dao.impl;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
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
    public Lesson addAbsence(Lesson lesson, StudentFeedback.Absence newAbsence) {
        return null;
    }

    @Override
    public Lesson addRemark(Lesson lesson, StudentFeedback.Remark newRemark) {
        return null;
    }

    @Override
    public Lesson addGrade(Lesson lesson, StudentFeedback.Grade newGrade) {
        return null;
    }

    @Override
    public Lesson removeAbsence(Lesson lesson, StudentFeedback.Absence newAbsence) {
        return null;
    }

    @Override
    public Lesson removeRemark(Lesson lesson, StudentFeedback.Remark newRemark) {
        return null;
    }

    @Override
    public Lesson removeGrade(Lesson lesson, StudentFeedback.Grade newGrade) {
        return null;
    }
}
