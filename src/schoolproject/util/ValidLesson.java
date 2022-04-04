package schoolproject.util;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.Absence;
import schoolproject.model.Lesson;
import schoolproject.model.roles.Parent;

import java.time.LocalDate;

public class ValidLesson implements Validation<Lesson>{
    public ValidLesson(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    private LessonRepository lessonRepository;

    public void validate(Lesson lesson) throws InvalidEntityDataException {

        if(!lesson.getSubject().getTeacher().getTeachingSubjects().containsKey(lesson.getSubject().getId()))
            throw new InvalidEntityDataException("This teacher isn't teaching this subject");

        if(lesson.getDate().isAfter(LocalDate.now()))
        {
            throw  new InvalidEntityDataException(lesson.getClass().getName()+ " date "+ lesson.getDate()+
                    " The date shouldn't be in the future ");
        }
    }
}
