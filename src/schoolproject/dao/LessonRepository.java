package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LessonRepository extends Repository<Long,String,Lesson>,AGRHelper<Long,String,Lesson>{
    Lesson changeSubject(Lesson lesson, Subject newSubject) throws EntityNotFoundException;
    Lesson changeDate(Lesson lesson,  LocalDate newDate) throws EntityNotFoundException;
    Lesson changeClass(Lesson lesson, SchoolClass schoolClass) throws EntityNotFoundException;
   /* Lesson addAbsence(Lesson classType, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
    Lesson addRemark(Lesson classType, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
    Lesson addGrade(Lesson classType, StudentFeedback.Grade newGrade) throws EntityNotFoundException;
    Lesson removeAbsence(Lesson classType, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
    Lesson removeRemark(Lesson classType, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
    Lesson removeGrade(Lesson classType, StudentFeedback.Grade newGrade) throws EntityNotFoundException;
    Lesson updateAbsence(Lesson classType, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
    Lesson updateRemark(Lesson classType, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
    Lesson updateGrade(Lesson classType, StudentFeedback.Grade newGrade) throws EntityNotFoundException;*/

}
