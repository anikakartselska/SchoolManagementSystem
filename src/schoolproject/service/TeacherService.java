package schoolproject.service;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.Lesson;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;
import schoolproject.util.ValidLesson;

import java.time.LocalDate;

public interface TeacherService extends UserService<Teacher>{

    Lesson addLesson(Lesson lesson, LessonRepository lessonRepository, ValidLesson validation);

    Lesson deleteLesson(Lesson lesson, LessonRepository lessonRepository) throws EntityNotFoundException;

    Lesson changeDate(Lesson lesson, LessonRepository lessonRepository, LocalDate date) throws EntityNotFoundException, InvalidEntityDataException;

    Lesson changeSubject(Lesson lesson, LessonRepository lessonRepository, Subject subject) throws EntityNotFoundException, InvalidEntityDataException;
}
