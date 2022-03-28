package schoolproject.dao.impl.helperrepositories;

import schoolproject.dao.AGRHelper;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.StudentFeedback;

public class AGFHelperImpl<K,S,V extends IdentifiableAGR<K,S>> extends RepositoryImpl<K,S,V> implements AGRHelper<K,S,V> {
    @Override
    public V addAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
       entity.getAbsences().put(newAbsence.getId(),newAbsence);
        return update(entity);

    }

    @Override
    public V addRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException {


        entity.getRemarks().put(newRemark.getId(),newRemark);
        return update(entity);
    }

    @Override
    public V addGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException {

        entity.getGrades().put(newGrade.getId(),newGrade);

        return update(entity);
    }

    @Override
    public V removeAbsence(V entity, StudentFeedback.Absence removeAbsence) throws EntityNotFoundException {


        if(entity.getAbsences().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getAbsences().remove(removeAbsence.getId());
        }

        return update(entity);
    }

    @Override
    public V removeRemark(V entity, StudentFeedback.Remark removeRemark) throws EntityNotFoundException {


        if(entity.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getRemarks().remove(removeRemark.getId());
        }

        return update(entity);

    }

    @Override
    public V removeGrade(V entity, StudentFeedback.Grade removeGrade) throws EntityNotFoundException {


        if(entity.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getGrades().remove(removeGrade.getId());
        }

        return update(entity);
    }

    @Override
    public V updateAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {


        if(entity.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getAbsences().put(newAbsence.getId(),newAbsence);
        }

        return update(entity);
    }

    @Override
    public V updateRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException {


        if(entity.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getRemarks().put(newRemark.getId(),newRemark);
        }

        return update(entity);
    }

    @Override
    public V updateGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException {


        if(entity.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            entity.getGrades().put(newGrade.getId(),newGrade);
        }

        return update(entity);
    }
}
