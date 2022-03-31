package schoolproject.service.implementations;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchoolAdminServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends UserServiceImpl<V> implements SchoolAdminService<V> {


    public SchoolAdminServiceImpl(UserRepository<V> userRepository, ValidUser<V> userValidator) {
        super(userRepository, userValidator);
    }

    @Override
    public V approveRegisterRequest(V user) throws EntityNotFoundException {
       return getUserRepository().changeStatus(user,Status.ACTIVE);
    }
    @Override
    public Collection<V> getAllUsersFromThisRole() {
        return getUserRepository().findAll();
    }


    @Override
    public V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException {


        getUserValidator().validate(user);
        return getUserRepository().update(user);

    }

    @Override
    public V deleteAccount(V user) throws EntityNotFoundException {
        return getUserRepository().delete(user);
    }

    @Override
    public V changeOwnFirstName(V user, String newFirstName) throws InvalidEntityDataException, EntityNotFoundException {

        var firstNameLen = newFirstName.trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newFirstName+
                    " First name should be between 1 and 20 characters");
        }
        getUserRepository().changeFirstName(user,newFirstName);
        return user;
    }

    @Override
    public V changeOwnSecondName(V user, String newSecondName) throws InvalidEntityDataException, EntityNotFoundException {
        var secondNameLen = newSecondName.trim().length();
        if(secondNameLen < 2 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newSecondName+
                    " Second name should be between 1 and 20 characters");
        }
        getUserRepository().changeSecondName(user,newSecondName);
        return user;
    }

    @Override
    public V changeOwnThirdName(V user, String newThirdName) throws InvalidEntityDataException, EntityNotFoundException {
        var thirdNameLen = newThirdName.trim().length();
        if(thirdNameLen < 2 || thirdNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newThirdName+
                    " Second name should be between 1 and 20 characters");
        }
        getUserRepository().changeThirdName(user,newThirdName);
        return user;
    }



    @Override
    public V changeOwnGender(V user, Gender newGender) throws EntityNotFoundException {
        return getUserRepository().changeGender(user,newGender);
    }

    @Override
    public V changeOwnPhoneNumber(V user, String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(newPhoneNumber);

        if (!matcher.matches() || getUserRepository().findByPhoneNumber(newPhoneNumber)!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+newPhoneNumber+
                    " Phone number should be 10 digits or is already used.");
        }
        return getUserRepository().changePhoneNumber(user,newPhoneNumber);
    }

    @Override
    public V changeAddress(V user, String newAddress) throws EntityNotFoundException {
        return getUserRepository().changeAddress(user,newAddress);
    }

}
