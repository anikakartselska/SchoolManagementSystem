package schoolproject.dao.impl;

import schoolproject.dao.AGRHelper;
import schoolproject.dao.Identifiable;
import schoolproject.dao.IdentifiableAGR;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.Lesson;
import schoolproject.model.StudentFeedback;

public class AGFHelperImpl<K,S,V extends IdentifiableAGR<K,S>> extends RepositoryImpl<K,S,V> implements AGRHelper<K,S,V> {
    @Override
    public V addAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        V updatedEntity=entity;
        updatedEntity.getAbsences().put(newAbsence.getId(),newAbsence);
        return update(updatedEntity);

    }

    @Override
    public V addRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException {

        V updatedEntity=entity;
        updatedEntity.getRemarks().put(newRemark.getId(),newRemark);
        return update(updatedEntity);
    }

    @Override
    public V addGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        V updatedEntity=entity;
        updatedEntity.getGrades().put(newGrade.getId(),newGrade);

        return update(updatedEntity);
    }

    @Override
    public V removeAbsence(V entity, StudentFeedback.Absence removeAbsence) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getAbsences().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getAbsences().remove(removeAbsence.getId());
        }

        return update(updatedEntity);
    }

    @Override
    public V removeRemark(V entity, StudentFeedback.Remark removeRemark) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getRemarks().remove(removeRemark.getId());
        }

        return update(updatedEntity);

    }

    @Override
    public V removeGrade(V entity, StudentFeedback.Grade removeGrade) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getGrades().remove(removeGrade.getId());
        }

        return update(updatedEntity);
    }

    @Override
    public V updateAbsence(V entity, StudentFeedback.Absence newAbsence) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getAbsences().put(newAbsence.getId(),newAbsence);
        }

        return update(updatedEntity);
    }

    @Override
    public V updateRemark(V entity, StudentFeedback.Remark newRemark) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getRemarks().put(newRemark.getId(),newRemark);
        }

        return update(updatedEntity);
    }

    @Override
    public V updateGrade(V entity, StudentFeedback.Grade newGrade) throws EntityNotFoundException {
        V updatedEntity=entity;

        if(updatedEntity.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedEntity.getGrades().put(newGrade.getId(),newGrade);
        }

        return update(updatedEntity);
    }
}
