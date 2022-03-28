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

        subject.setSubName(newName);
        return update(subject);
    }

    @Override
    public Subject changeTeacher(Subject subject, Teacher newTeacher) throws EntityNotFoundException {

        subject.setTeacher(newTeacher);
        return update(subject);
    }

    @Override
    public Subject changeClass(Subject subject, SchoolClass newClass) throws EntityNotFoundException {

        subject.setSchoolClass(newClass);
        return update(subject);
    }

    @Override
    public Subject changeWeeklyLessons(Subject subject, Integer weeklyLessons) throws EntityNotFoundException {

        subject.setWeeklyLessons(weeklyLessons);
        return update(subject);
    }

    @Override
    public Subject changeAverageGrade(Subject subject) throws EntityNotFoundException {

        double average=0;
        var i=0;
        for(StudentFeedback.Grade grade: subject.getGrades().values())
        { average+= grade.getValue();
            i++;}

        subject.setAverageGrade(average/i);
        return update(subject);
    }

    @Override
    public Subject addLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {

        subject.getLessons().put(lesson.getId(),lesson);
        return update(subject);
    }

    @Override
    public Subject updateLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {


        if(subject.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            subject.getLessons().put(lesson.getId(),lesson);
        }

        return update(subject);
    }

    @Override
    public Subject deleteLesson(Subject subject, Lesson lesson) throws EntityNotFoundException {


        if(subject.getLessons().get(lesson.getId())==null)
            throw new EntityNotFoundException();
        else {
            subject.getLessons().remove(lesson.getId());
        }

        return update(subject);
    }
}
