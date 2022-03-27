package schoolproject.util;

import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.rolesrepoimpl.UserRepositoryImpl;
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

    private UserRepository userRepository;

    public ValidParent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(Parent parent) throws InvalidEntityDataException {
        new ValidUser(userRepository).validate(parent);

        if(parent.getMonthIncome()<0)
        {
            throw  new InvalidEntityDataException(parent.getClass().getName()+ "monthIncome"+parent.getMonthIncome()+
                            "Month income shouldn't be negative ");
        }
    }

    public static void main(String[] args) {
        UserRepository ur=new UserRepositoryImpl();
        ValidParent vu=new ValidParent(ur);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            vu.validate(new Parent("Anika","Petrova","Kartselska","aa@abv.bg","anika","Anikaaa444$", Gender.FEMALE,"0894673436","rupite", LocalDate.parse("09.12.2001",dtf),new HashMap<>(),-34));
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }


    }
    }

