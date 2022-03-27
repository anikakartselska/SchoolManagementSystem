package schoolproject.dao.impl;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.AGFHelperImpl;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;

import java.time.LocalDateTime;

public class LessonRepositoryImpl extends AGFHelperImpl<Long,String,Lesson> implements LessonRepository {
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


}
