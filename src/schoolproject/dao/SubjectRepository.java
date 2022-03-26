package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;

public interface SubjectRepository extends AGRHelper<Long,String,Subject>{
Subject changeName(Subject subject,String newName) throws EntityNotFoundException;
Subject changeTeacher(Subject subject, Teacher newTeacher) throws EntityNotFoundException;
Subject changeClass(Subject subject, SchoolClass newClass) throws EntityNotFoundException;
Subject changeWeeklyLessons(Subject subject,Integer weeklyLessons) throws EntityNotFoundException;
Subject changeAverageGrade(Subject subject) throws EntityNotFoundException;
Subject addLesson(Subject subject, Lesson lesson) throws EntityNotFoundException;
Subject updateLesson(Subject subject, Lesson lesson) throws EntityNotFoundException;
Subject deleteLesson(Subject subject, Lesson lesson) throws EntityNotFoundException;
}
