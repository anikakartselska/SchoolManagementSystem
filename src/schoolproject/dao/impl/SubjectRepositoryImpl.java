package schoolproject.dao.impl;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.AGFHelperImpl;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;

public class SubjectRepositoryImpl extends AGFHelperImpl<Long,String,Subject> implements SubjectRepository {
    @Override
    public Subject changeName(Subject subject, String newName) throws EntityNotFoundException {
        Subject updatedSubject=subject;
        updatedSubject.setSubName(newName);
        return update(updatedSubject);
    }

    @Override
    public Subject changeTeacher(Subject subject, Teacher newTeacher) throws EntityNotFoundException {
        Subject updatedSubject=subject;
        updatedSubject.setTeacher(newTeacher);
        return update(updatedSubject);
    }

    @Override
    public Subject changeClass(Subject subject, SchoolClass newClass) throws EntityNotFoundException {
        Subject updatedSubject=subject;
        updatedSubject.setSchoolClass(newClass);
        return update(updatedSubject);
    }

    @Override
    public Subject changeWeeklyLessons(Subject subject, Integer weeklyLessons) throws EntityNotFoundException {
        Subject updatedSubject=subject;
        updatedSubject.setWeeklyLessons(weeklyLessons);
        return update(updatedSubject);
    }

    @Override
    public Subject changeAverageGrade(Subject subject) throws EntityNotFoundException {
        Subject updatedSubject=subject;
        double average=0;
        var i=0;
        for(StudentFeedback.Grade grade: updatedSubject.getGrades().values())
        { average+= grade.getValue();
            i++;}

        updatedSubject.setAverageGrade(average/i);
        return update(updatedSubject);
    }

    @Override
    public Subject addLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {

        Subject updatedSubject=subject;
        updatedSubject.getLessons().put(lesson.getId(),lesson);
        return update(updatedSubject);
    }

    @Override
    public Subject updateLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {
        Subject updatedSubject=subject;

        if(updatedSubject.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSubject.getLessons().put(lesson.getId(),lesson);
        }

        return update(updatedSubject);
    }

    @Override
    public Subject deleteLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {
        Subject updatedSubject=subject;

        if(updatedSubject.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedSubject.getLessons().remove(lesson.getId());
        }

        return update(updatedSubject);
    }
}
