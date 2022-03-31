package schoolproject.dao.impl;
import schoolproject.dao.Repository;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.AGFHelperImpl;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.*;
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
     subject.setAverageGrade(
       subject.getFeedbacks().values().stream().map(StudentFeedback::getAverageGrade).mapToDouble(Double::doubleValue).sum()/subject.getFeedback().size());
     return update(subject);
    }


}
