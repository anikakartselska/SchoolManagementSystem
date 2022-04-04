package schoolproject.service.implementations;
import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.SchoolAdminRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchoolAdminServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends UserServiceImpl<SchoolAdmin> implements SchoolAdminService<V> {

    private UserRepository<V> userRepository;
    private ValidUser<V> validUser;

    public SchoolAdminServiceImpl(UserRepository<SchoolAdmin> userRepository, ValidUser<SchoolAdmin> userValidator) {
        super(userRepository, userValidator);
    }

    @Override
    public V approveRegisterRequest(V user, UserRepository<V> userRepo) throws EntityNotFoundException {
       userRepo.changeStatus(user,Status.ACTIVE);
       userRepo.save();
       return user;
    }
    @Override
    public Collection<V> getAllUsersFromThisRole( UserRepository<V> userRepo) {
        return userRepo.findAll();
    }
    @Override
    public V updateUser(V user, UserRepository<V> userRepo,ValidUser<V>validation) throws EntityNotFoundException, InvalidEntityDataException {


       validation.validate(user);
       userRepo.update(user);
        userRepo.save();
        return user;

    }

    @Override
    public V deleteAccount(V entity,UserRepository<V>userRepo) throws EntityNotFoundException {
        var old = userRepo.delete(entity);
        userRepo.save();
        return old;
    }

    @Override
    public V changeFirstName(V user, UserRepository<V> userRepo, String newFirstName) throws InvalidEntityDataException, EntityNotFoundException {

        var firstNameLen = newFirstName.trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newFirstName+
                    " First name should be between 1 and 20 characters");
        }
        userRepo.changeFirstName(user,newFirstName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeSecondName(V user, UserRepository<V> userRepo, String newSecondName) throws InvalidEntityDataException, EntityNotFoundException {
        var secondNameLen = newSecondName.trim().length();
        if(secondNameLen < 2 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newSecondName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepo.changeSecondName(user,newSecondName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeThirdName(V user, UserRepository<V> userRepo, String newThirdName) throws InvalidEntityDataException, EntityNotFoundException {
        var thirdNameLen = newThirdName.trim().length();
        if(thirdNameLen < 2 || thirdNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newThirdName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepo.changeThirdName(user,newThirdName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeGender(V user, UserRepository<V> userRepo, Gender newGender) throws EntityNotFoundException {
       userRepo.changeGender(user,newGender);
        userRepo.save();
        return user;
    }

    @Override
    public V changePhoneNumber(V user, UserRepository<V> userRepo, String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(newPhoneNumber);

        if (!matcher.matches() || getUserRepository().findByPhoneNumber(newPhoneNumber)!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+newPhoneNumber+
                    " Phone number should be 10 digits or is already used.");
        }
        userRepo.changePhoneNumber(user,newPhoneNumber);
        userRepo.save();
        return user;
    }

    @Override
    public V changeAddress(V user, UserRepository<V> userRepo, String newAddress) throws EntityNotFoundException {
        userRepo.changeAddress(user,newAddress);
        userRepo.save();
        return user;
    }

}
