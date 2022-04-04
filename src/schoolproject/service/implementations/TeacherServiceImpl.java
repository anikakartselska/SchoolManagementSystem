package schoolproject.service.implementations;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Teacher;
import schoolproject.service.TeacherService;
import schoolproject.util.ValidLesson;
import schoolproject.util.ValidUser;

import java.time.LocalDate;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository teacherRepository, ValidUser<Teacher> userValidator) {
        super(teacherRepository, userValidator);
    }


    @Override
    public Lesson addLesson(Lesson lesson, LessonRepository lessonRepository, ValidLesson validation) {

        try{
            validation.validate(lesson);
            lessonRepository.add(lesson);
            lessonRepository.save();

        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }

        return lesson;

    }

    @Override
    public Lesson deleteLesson(Lesson lesson, LessonRepository lessonRepository) throws EntityNotFoundException {
        var old = lessonRepository.delete(lesson);
        lessonRepository.save();
        return old;
    }

    @Override
    public Lesson changeDate(Lesson lesson, LessonRepository lessonRepository, LocalDate date) throws EntityNotFoundException, InvalidEntityDataException {
        if(date.isAfter(LocalDate.now()))
        {
            throw  new InvalidEntityDataException(lesson.getClass().getName()+ " date "+ date +
                    " The date shouldn't be in the future ");
        }
        lessonRepository.changeDate(lesson,date);
        lessonRepository.save();
        return lesson;
    }
    @Override
    public Lesson changeSubject(Lesson lesson, LessonRepository lessonRepository, Subject subject) throws EntityNotFoundException, InvalidEntityDataException {

        if(!lesson.getSubject().getTeacher().getTeachingSubjects().containsKey(subject.getId()))
            throw new InvalidEntityDataException("This teacher isn't teaching this subject");

        lessonRepository.changeSubject(lesson,subject);
        lessonRepository.save();
        return lesson;
    }
}
