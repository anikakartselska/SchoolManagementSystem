package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.User;

import java.util.Collection;
import java.util.HashMap;

public interface SchoolAdminService<V> extends UserService<V>{

    V approveRegisterRequest(V user) throws EntityNotFoundException;
    V changeOwnGender(V user, Gender newGender) throws EntityNotFoundException;
    V changeOwnPhoneNumber(V user,String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException;
    V changeAddress(V user,String newAddress) throws EntityNotFoundException;
     V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException;
     V deleteAccount(V user) throws EntityNotFoundException;
     V changeOwnFirstName(V user,String newFirstName) throws EntityNotFoundException, InvalidEntityDataException;
     V changeOwnSecondName(V user,String newSecondName) throws InvalidEntityDataException, EntityNotFoundException;
     V changeOwnThirdName(V user,String newThirdName) throws InvalidEntityDataException, EntityNotFoundException;
     Collection<V> getAllUsersFromThisRole();
}
