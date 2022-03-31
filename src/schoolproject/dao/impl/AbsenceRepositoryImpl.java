package schoolproject.dao.impl;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Absence;
import schoolproject.model.enums.AbsenceStatus;

public class AbsenceRepositoryImpl  extends StudentFeedbackTempRepoImpl<Double> implements AbsenceRepository{
    @Override
    public Absence changeStatus(Absence absence) throws EntityNotFoundException {
        if(absence.getStatus().equals(AbsenceStatus.EXCUSED))
            absence.setStatus(AbsenceStatus.UNEXCUSED);
        else absence.setStatus(AbsenceStatus.EXCUSED);
        return (Absence) update(absence);
    }
}
