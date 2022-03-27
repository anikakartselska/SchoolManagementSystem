package schoolproject.util;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.RemarkRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.StudentFeedback;

import java.time.LocalDate;

public class ValidRemark {
    private RemarkRepository remarkRepository;

    public ValidRemark(RemarkRepository remarkRepository) {
        this.remarkRepository = remarkRepository;
    }

    public void validate(StudentFeedback.Remark remark) throws InvalidEntityDataException {
        if(remark.getDate().isAfter(LocalDate.now()))
        {
            throw  new InvalidEntityDataException(remark.getClass().getName()+ " date "+ remark.getDate()+
                    " The date shouldn't be in the future ");
        }
        if(remark.getValue().length()<5 || remark.getValue().length()>30)
        {
            throw  new InvalidEntityDataException(remark.getClass().getName()+ " value "+remark.getValue()+
                    " Remark text length should be between 5 and 30 characters ");
        }
    }
}
