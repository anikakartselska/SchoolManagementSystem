package schoolproject.util;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.AbsenceRepositoryImpl;
import schoolproject.model.Absence;
import schoolproject.model.StudentFeedback;

import java.time.LocalDate;

public class ValidAbsence {
    private AbsenceRepository absenceRepository;

    public ValidAbsence(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }
    public void validate(Absence absence) throws InvalidEntityDataException {
        if(absence.getDate().isAfter(LocalDate.now()))
        {
            throw  new InvalidEntityDataException(absence.getClass().getName()+ " date "+ absence.getDate()+
                    " The date shouldn't be in the future ");
        }
        if(absence.getValue()!=0.5 || absence.getValue()!=1)
        {
            throw  new InvalidEntityDataException(absence.getClass().getName()+ " value "+absence.getValue()+
                    " Absence value should be 0.5 or 1 ");
        }
    }


}
