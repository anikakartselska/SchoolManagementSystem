package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;

import java.time.LocalDateTime;

public interface LessonRepository extends Repository <Long,String,Lesson> {
    Lesson changeSubject(Lesson lesson, Subject newSubject) throws EntityNotFoundException;
    Lesson changeDate(Lesson lesson, LocalDateTime newDate) throws EntityNotFoundException;
    Lesson addAbsence(Lesson lesson, StudentFeedback.Absence newAbsence);
    Lesson addRemark(Lesson lesson, StudentFeedback.Remark newRemark);
    Lesson addGrade(Lesson lesson, StudentFeedback.Grade newGrade);
    Lesson removeAbsence(Lesson lesson, StudentFeedback.Absence newAbsence);
    Lesson removeRemark(Lesson lesson, StudentFeedback.Remark newRemark);
    Lesson removeGrade(Lesson lesson, StudentFeedback.Grade newGrade);

}
