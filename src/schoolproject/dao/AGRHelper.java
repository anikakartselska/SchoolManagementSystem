package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.StudentFeedback;

public interface AGRHelper<K,S,V extends IdentifiableAGR<K,S>> {
         V addAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
          V addRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
           V addGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException;
      V removeAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
       V removeRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
        V removeGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException;
      V updateAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException;
       V updateRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException;
        V updateGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException;
}

