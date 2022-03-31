package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.model.Absence;
import schoolproject.model.Grade;
import schoolproject.model.Remark;
import schoolproject.model.StudentFeedback;
import schoolproject.model.roles.Student;

public interface AGRHelper<K,S,V extends IdentifiableAGR<K,S>> {
         V addAbsence(V entity, Absence newAbsence) throws EntityNotFoundException;
          V addRemark(V entity, Remark newRemark) throws EntityNotFoundException;
           V addGrade(V entity, Grade newGrade) throws EntityNotFoundException;
      V removeAbsence(V entity, Absence newAbsence) throws EntityNotFoundException;
      V removeRemark(V entity,  Remark newRemark) throws EntityNotFoundException;
        V removeGrade(V entity, Grade newGrade) throws EntityNotFoundException;
      V updateAbsence(V entity, Absence newAbsence) throws EntityNotFoundException;
       V updateRemark(V entity, Remark newRemark) throws EntityNotFoundException;
        V updateGrade(V entity, Grade newGrade) throws EntityNotFoundException;
        V averageGrade(V entity, Student student) throws EntityNotFoundException;
}

