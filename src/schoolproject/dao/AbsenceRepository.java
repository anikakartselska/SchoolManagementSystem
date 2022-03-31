package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Absence;

public interface AbsenceRepository extends StudentFeedbackTempRepo<Double> {
    Absence changeStatus(Absence absence) throws EntityNotFoundException;
}
