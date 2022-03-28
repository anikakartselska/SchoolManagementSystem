package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;

public class ParentRepositoryImpl extends UserRepositoryImpl<Parent> implements ParentRepository {
    @Override
    public Parent changeMonthIncome(Parent parent, Double income) throws EntityNotFoundException {

         parent.setMonthIncome(income);
        return parent;
    }

    @Override
    public Parent addStudent(Parent parent, Student student) throws EntityNotFoundException {
        Parent updatedParent=parent;
        updatedParent.getChildren().put(student.getId(),student);
        return update(updatedParent);
    }

    @Override
    public Parent removeStudent(Parent parent, Student student) throws EntityNotFoundException {
        Parent updatedParent=parent;
        if(updatedParent.getChildren().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedParent.getChildren().remove(student.getId());
        }

        return update(updatedParent);
    }

    @Override
    public Parent updateStudent(Parent parent, Student student) throws EntityNotFoundException {
        Parent updatedParent=parent;
        if(updatedParent.getChildren().get(student.getId())==null)
            throw new EntityNotFoundException();
        else {
            updatedParent.getChildren().put(student.getId(),student);
        }
        return update(updatedParent);
    }
}
