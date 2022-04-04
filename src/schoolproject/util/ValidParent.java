package schoolproject.util;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.model.Absence;
import schoolproject.model.roles.Parent;


public class ValidParent extends ValidUser<Parent> implements Validation<Parent>{


    public ValidParent(ParentRepository parentRepository) {
        super(parentRepository);
    }

    public void validate(Parent parent) throws InvalidEntityDataException {
        super.validate(parent);

        if(parent.getMonthIncome()<0)
        {
            throw  new InvalidEntityDataException(parent.getClass().getName()+ "monthIncome"+parent.getMonthIncome()+
                            "Month income shouldn't be negative ");
        }
    }


    }

