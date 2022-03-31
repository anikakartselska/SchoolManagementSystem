package schoolproject.dao.impl.helperrepositories;

import schoolproject.dao.AGRHelper;
import schoolproject.dao.identifiiables.IdentifiableAGR;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.*;
import schoolproject.model.roles.Student;

import java.util.stream.Collectors;

public class AGFHelperImpl<K,S,V extends IdentifiableAGR<K,S>> extends RepositoryImpl<K,S,V> implements AGRHelper<K,S,V> {
    @Override
    public V addAbsence(V entity, Absence newAbsence) throws EntityNotFoundException {
         StudentFeedback studentFeedback=entity.getFeedbacks().get(newAbsence.getStudent());
         if(studentFeedback==null)
             studentFeedback=new StudentFeedback();


             studentFeedback.getAbsences().put(newAbsence.getId(),newAbsence);
             entity.getFeedbacks().put(newAbsence.getStudent(),studentFeedback);


        return update(entity);
    }

    @Override
    public V addRemark(V entity, Remark newRemark) throws EntityNotFoundException {

        StudentFeedback studentFeedback=entity.getFeedbacks().get(newRemark.getStudent());
        if(studentFeedback==null)
            studentFeedback=new StudentFeedback();


        studentFeedback.getRemarks().put(newRemark.getId(),newRemark);
        entity.getFeedbacks().put(newRemark.getStudent(),studentFeedback);


        return update(entity);
    }



    @Override
    public V addGrade(V entity, Grade newGrade) throws EntityNotFoundException {

        StudentFeedback studentFeedback=entity.getFeedbacks().get(newGrade.getStudent());
        if(studentFeedback==null)
            studentFeedback=new StudentFeedback();


        studentFeedback.getGrades().put(newGrade.getId(),newGrade);
        entity.getFeedbacks().put(newGrade.getStudent(),studentFeedback);

        return update(entity);
    }

    @Override
    public V removeAbsence(V entity, Absence removeAbsence) throws EntityNotFoundException {
        StudentFeedback studentFeedback=entity.getFeedbacks().get(removeAbsence.getStudent());
        if(studentFeedback==null || studentFeedback.getGrades().get(removeAbsence.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getGrades().remove(removeAbsence.getId());


        return update(entity);
    }

    @Override
    public V removeRemark(V entity, Remark removeRemark) throws EntityNotFoundException {

        StudentFeedback studentFeedback=entity.getFeedbacks().get(removeRemark.getStudent());
        if(studentFeedback==null || studentFeedback.getRemarks().get(removeRemark.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getRemarks().remove(removeRemark.getId());


        return update(entity);

    }

    @Override
    public V removeGrade(V entity, Grade removeGrade) throws EntityNotFoundException {


        StudentFeedback studentFeedback=entity.getFeedbacks().get(removeGrade.getStudent());
        if(studentFeedback==null || studentFeedback.getGrades().get(removeGrade.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getGrades().remove(removeGrade.getId());


        return update(entity);

    }

    @Override
    public V updateAbsence(V entity, Absence newAbsence) throws EntityNotFoundException {

        StudentFeedback studentFeedback=entity.getFeedbacks().get(newAbsence.getStudent());
        if(studentFeedback==null || studentFeedback.getAbsences().get(newAbsence.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getAbsences().put(newAbsence.getId(),newAbsence);


        return update(entity);
    }

    @Override
    public V updateRemark(V entity, Remark newRemark) throws EntityNotFoundException {

        StudentFeedback studentFeedback=entity.getFeedbacks().get(newRemark.getStudent());
        if(studentFeedback==null || studentFeedback.getRemarks().get(newRemark.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getRemarks().put(newRemark.getId(),newRemark);


        return update(entity);
    }

    @Override
    public V updateGrade(V entity, Grade newGrade) throws EntityNotFoundException {
        StudentFeedback studentFeedback=entity.getFeedbacks().get(newGrade.getStudent());
        if(studentFeedback==null || studentFeedback.getGrades().get(newGrade.getId())==null)
            throw new EntityNotFoundException();

        else studentFeedback.getGrades().put(newGrade.getId(),newGrade);


        return update(entity);

    }

    @Override
    public V averageGrade(V entity, Student student) throws EntityNotFoundException {

        if(entity.getFeedbacks().get(student)==null)
            throw new EntityNotFoundException();
        entity.getFeedbacks().get(student).setAverageGrade( entity.getFeedbacks().get(student).getGrades().values()
                .stream().map(Grade::getValue).mapToDouble(Integer::doubleValue).sum()/entity.getFeedbacks().get(student).getGrades().size());

        return update(entity);


    }
}
