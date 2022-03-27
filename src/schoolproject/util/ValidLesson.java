package schoolproject.util;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.Lesson;
import schoolproject.model.roles.Parent;

import java.time.LocalDate;

public class ValidLesson {
    public ValidLesson(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    private LessonRepository lessonRepository;

    public void validate(Lesson lesson) throws InvalidEntityDataException {

        if(lesson.getDate().isAfter(LocalDate.now()))
        {
            throw  new InvalidEntityDataException(lesson.getClass().getName()+ " date "+ lesson.getDate()+
                    " The date shouldn't be in the future ");
        }
    }
}
