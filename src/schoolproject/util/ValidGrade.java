package schoolproject.util;

import schoolproject.dao.GradeRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.GradeRepositoryImpl;
import schoolproject.model.Absence;
import schoolproject.model.Grade;
import schoolproject.model.StudentFeedback;

import java.time.LocalDate;

public class ValidGrade implements Validation<Grade>{
    private GradeRepository gradeRepository;

    public ValidGrade(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
public void validate(Grade grade) throws InvalidEntityDataException {
    if(grade.getDate().isAfter(LocalDate.now()))
    {
        throw  new InvalidEntityDataException(grade.getClass().getName()+ " date "+ grade.getDate()+
                " The date shouldn't be in the future ");
    }
    if(grade.getValue()<2 || grade.getValue()>6)
    {
        throw  new InvalidEntityDataException(grade.getClass().getName()+ " value "+grade.getValue()+
                " Grade should be between 2 and 6 ");
    }
}

}
