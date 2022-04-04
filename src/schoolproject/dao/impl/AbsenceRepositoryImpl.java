package schoolproject.dao.impl;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.impl.helperrepositories.LongIdGenerator;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Absence;
import schoolproject.model.enums.AbsenceStatus;

public class AbsenceRepositoryImpl  extends StudentFeedbackTempRepoImpl<Double> implements AbsenceRepository{


    public AbsenceRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }

    @Override
    public Absence changeStatus(Absence absence) throws EntityNotFoundException {
        if(absence.getStatus().equals(AbsenceStatus.EXCUSED))
            absence.setStatus(AbsenceStatus.UNEXCUSED);
        else absence.setStatus(AbsenceStatus.EXCUSED);
        return (Absence) update(absence);
    }
}
