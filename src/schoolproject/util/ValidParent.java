package schoolproject.util;

import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.rolesrepoimpl.UserRepositoryImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ValidParent {

    private ParentRepository parentRepository;

    public ValidParent(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public void validate(Parent parent) throws InvalidEntityDataException {
        new ValidUser<Parent>(parentRepository).validate(parent);

        if(parent.getMonthIncome()<0)
        {
            throw  new InvalidEntityDataException(parent.getClass().getName()+ "monthIncome"+parent.getMonthIncome()+
                            "Month income shouldn't be negative ");
        }
    }


    }

