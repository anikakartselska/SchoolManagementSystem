package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.enums.Gender;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface UserService <V>{
    Collection<V> getAllUsersFromThisRole();
    V getUserById(Long id) throws EntityNotFoundException;
    V register(V user) ;
    V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException;
    V deleteAccount(V user) throws EntityNotFoundException;
    V changeOwnFirstName(V user,String newFirstName) throws EntityNotFoundException, InvalidEntityDataException;
    V changeOwnSecondName(V user,String newSecondName) throws InvalidEntityDataException, EntityNotFoundException;
    V changeOwnThirdName(V user,String newThirdName) throws InvalidEntityDataException, EntityNotFoundException;
    V changeOwnPassword(V user,String newPassword) throws InvalidEntityDataException, EntityNotFoundException;
    V changeOwnGender(V user, Gender newGender) throws EntityNotFoundException;
    V changeOwnPhoneNumber(V user,String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException;
    V changeAddress(V user,String newAddress) throws EntityNotFoundException;
    V logIn(String email,String username,String password) throws InvalidEntityDataException, EntityNotFoundException;

}
