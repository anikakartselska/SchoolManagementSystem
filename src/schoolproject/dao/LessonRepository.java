package schoolproject.dao;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import java.time.LocalDate;


public interface LessonRepository extends Repository<Long,String,Lesson>,AGRHelper<Long,String,Lesson>{
    Lesson changeSubject(Lesson lesson, Subject newSubject) throws EntityNotFoundException;
    Lesson changeDate(Lesson lesson,  LocalDate newDate) throws EntityNotFoundException;
    Lesson changeClass(Lesson lesson, SchoolClass schoolClass) throws EntityNotFoundException;


}
