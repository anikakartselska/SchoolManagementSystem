package schoolproject.util;

import schoolproject.dao.LessonRepository;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.SubjectRepositoryImpl;
import schoolproject.model.Lesson;
import schoolproject.model.Subject;

import java.time.LocalDate;

public class ValidSubject {
    private SubjectRepository subjectRepository;

    public ValidSubject(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    public void validate(Subject subject) throws InvalidEntityDataException {
         var subNameLen=subject.getName().trim().length();
        if(subNameLen<1 || subNameLen>20)
        {
            throw  new InvalidEntityDataException(subject.getClass().getName()+ " subName "+ subject.getSubName()+
                    " The subject name length should be between 1 and 20 ");
        }
        if(subject.getAverageGrade()<2 || subject.getAverageGrade()>6)
        {
            throw  new InvalidEntityDataException(subject.getClass().getName()+ " averageGrade "+ subject.getAverageGrade()+
                    " The average grade should be between 2 and 6 ");
        }
        if(subject.getWeeklyLessons()<0 || subject.getWeeklyLessons()>10)
        {
            throw  new InvalidEntityDataException(subject.getClass().getName()+ " weeklyLessons"+ subject.getWeeklyLessons()+
                    " Weekly lessons shouldn't be > 10 ");
        }
    }
}
