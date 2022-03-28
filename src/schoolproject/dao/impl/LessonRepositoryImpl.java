package schoolproject.dao.impl;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.AGFHelperImpl;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;

import java.time.LocalDate;


public class LessonRepositoryImpl extends AGFHelperImpl<Long,String,Lesson> implements LessonRepository {
    @Override
    public Lesson changeSubject(Lesson lesson, Subject newSubject) throws EntityNotFoundException {
        lesson.setSubject(newSubject);
        return update(lesson);

    }

    @Override
    public Lesson changeDate(Lesson lesson,  LocalDate newDate) throws EntityNotFoundException {

        lesson.setDate(newDate);
        return update(lesson);
    }

    @Override
    public Lesson changeClass(Lesson lesson, SchoolClass newSchoolClass) throws EntityNotFoundException {
        lesson.setSchoolClass(newSchoolClass);
        return update(lesson);
    }


}
